import * as uuidv4 from 'uuid/v4';
import * as WebSocket from 'ws';
import { WsType } from './interface';
import * as utils from './utils';

export class UpbitWs {

  protected host: string = process.env.UPBIT_WS_URL || 'wss://api.upbit.com/websocket/v1';
  protected ws: WebSocket | undefined = undefined;
  protected _codes: string[] = [ 'KRW-BTC '];

  protected handlers: Map<String, Function> = new Map<String, Function>();
  protected objectMap: Map<String, any>
            = new Map<String, any>();

  constructor(codes: string[],
              type: WsType,
              cb: {
                open?
                close?,
                message?
              },
              opts: {
                isOnlySnapshot: boolean, isOnlyRealtime: boolean, simpleFormat: boolean
              } = { isOnlySnapshot: false, isOnlyRealtime: false, simpleFormat: false}) {
    if (codes) this._codes = codes;

    this._codes.forEach( value => {
      this.objectMap.set(value, { type });
    });

    this.ws = new WebSocket(this.host);
    this.ws.on('open', () => {
      const msg = [
        { ticket: uuidv4() },
        { format: opts && opts.simpleFormat ? 'SIMPLE' : 'DEFAULT' },
        { type,
          codes: this._codes,
          isOnlySnapshot: opts && opts.isOnlySnapshot || false,
          isOnlyRealtime: opts && opts.isOnlyRealtime || false }
      ];
      if (utils.isDebug()) {
        console.log('ws connected..');
        console.log('send..', msg);
      }
      this.ws.send(JSON.stringify(msg));

      if (cb && cb.open) cb.open();
    });

    this.ws.on('close', () => {
      if (utils.isDebug()) console.log('ws disconnected..');
      if (cb && cb.close) cb.close();
    });

    this.ws.on('message', value => {
      if (utils.isDebug()) {
        console.log('msg received..');
        console.log(JSON.parse(value));
      }
      // for raw ws handler
      if (cb && cb.message) cb.message(value);
      // for registered handlers
      const obj = JSON.parse(value);
      this.handlers.forEach( (cb, key) => {
        if (obj.code === key) {
          if (obj.error) cb(obj, undefined);
          else cb(undefined, obj); // ( err, value ) => {}
        }
      });

      this.setObjectMap(obj);

    });
  }

  get socket(): WebSocket {
    return this.ws;
  }
  get codes(): string[] {
    return this._codes;
  }

  public close() {
    try {
      this.ws.close();
    } catch (e) {

    }
  }

  public register(code: String, handler: (err, value) => {} ) {
    this.handlers.set(code, handler);
  }

  public getObject(code: string) {
    return this.objectMap.get(code);
  }

  protected setObjectMap(obj) {
    if (obj.error) return;
    if (this.objectMap.has(obj.code!)) {
      this.objectMap.set(obj.code!, obj);
    }
  }

}
