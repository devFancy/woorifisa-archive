import { WsType } from './interface';
import { UpbitWs } from './upbit-ws';

export default class UpbitWsTicker extends UpbitWs {
  constructor(codes: string[],
              cb: {
                open?
                close?,
                message?
              },
              opts: {
                isOnlySnapshot: boolean, isOnlyRealtime: boolean, simpleFormat: boolean
              } = { isOnlySnapshot: false, isOnlyRealtime: false, simpleFormat: false}) {
    super(codes, WsType.ticker, cb, opts);
  }

}
