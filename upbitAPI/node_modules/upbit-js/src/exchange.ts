import * as crypto from 'crypto';
import { sign } from 'jsonwebtoken';
import * as querystring from 'querystring';
import * as request from 'superagent';
import * as url from 'url';
import { constant } from './constant';
import { OrderState } from './interface';

export class ExchangeApi {
  private accessKey: string | undefined;
  private secretKey: string | undefined;
  constructor(accessKey?: string, secretKey?: string) {
    this.accessKey = accessKey;
    this.secretKey = secretKey;
  }
  public async getAccounts() {
    this.checkKeys();
    const payload = {access_key: this.accessKey, nonce: (new Date).getTime()};
    const token = sign(payload, this.secretKey as string);
    const uri = url.format({
      protocol: 'https',
      hostname: constant.UPBIT_URL_V1,
      pathname: constant.UPBIT_URL_ACCOUNTS
    });
    const res = await request.get(uri)
      .set('Authorization', `Bearer ${token}`);
    return res.body;
  }

  public async getOrdersChance(market: string) {
    this.checkKeys();
    const query = querystring.stringify({market});
    const payload = {
      access_key: this.accessKey,
      nonce: (new Date).getTime(),
      query
    };
    const token = sign(payload, this.secretKey as string);
    const uri = url.format({
      protocol: 'https',
      hostname: constant.UPBIT_URL_V1,
      pathname: constant.UPBIT_URL_ORDERS_CHANCE
    });
    const res = await request.get(uri)
      .set('Authorization', `Bearer ${token}`)
      .query({ market });
    return res.body;
  }

  public async getOrder(uuid?: string, identifier?: string) {
    this.checkKeys();
    const query = querystring.stringify({uuid, identifier});
    const payload = {
      access_key: this.accessKey,
      nonce: (new Date).getTime(),
      query
    };
    const token = sign(payload, this.secretKey as string);
    const uri = url.format({
      protocol: 'https',
      hostname: constant.UPBIT_URL_V1,
      pathname: constant.UPBIT_URL_ORDER
    });
    const res = await request.get(uri)
      .set('Authorization', `Bearer ${token}`)
      .query({ uuid })
      .query({ identifier });
    return res.body;
  }

  public async getOrders(market: string, state?: OrderState, page?: number, orderBy?: string) {
    this.checkKeys();
    const query = querystring.stringify({market, state, page, order_by: orderBy});
    const payload = {
      access_key: this.accessKey,
      nonce: (new Date).getTime(),
      query
    };
    const token = sign(payload, this.secretKey as string);
    const uri = url.format({
      protocol: 'https',
      hostname: constant.UPBIT_URL_V1,
      pathname: constant.UPBIT_URL_ORDERS
    });
    const res = await request.get(uri)
      .set('Authorization', `Bearer ${token}`)
      .query({ market })
      .query({ state })
      .query({ page })
      .query({ order_by: orderBy });
    return res.body;
  }
  public async postOrders(market: string, side: string, volume: string, price: string, ordType: string) {
    this.checkKeys();
    const randomBytes = await crypto.randomBytes(64);
    const identifier = randomBytes.toString('hex');
    const body = {market, side, volume, price, ord_type: ordType, identifier};
    const payload = {
      access_key: this.accessKey,
      nonce: (new Date).getTime(),
      query: querystring.stringify(body)
    };
    const token = sign(payload, this.secretKey as string);
    const uri = url.format({
      protocol: 'https',
      hostname: constant.UPBIT_URL_V1,
      pathname: constant.UPBIT_URL_ORDERS
    });
    const res = await request.post(uri)
      .set('Authorization', `Bearer ${token}`)
      .set('Content-type', 'application/json')
      .send(body);
    return res.body;
  }
  public async delOrder(uuid: string) {
    this.checkKeys();
    const query = { uuid };
    const payload = {
      access_key: this.accessKey,
      nonce: (new Date).getTime(),
      query: querystring.stringify(query)
    };
    const token = sign(payload, this.secretKey as string);
    const uri = url.format({
      protocol: 'https',
      hostname: constant.UPBIT_URL_V1,
      pathname: constant.UPBIT_URL_ORDER
    });
    const res = await request.del(uri)
      .set('Authorization', `Bearer ${token}`)
      .set('Content-type', 'application/json')
      .query({ uuid });
    return res.body;
  }

  private checkKeys() {
    if (!this.secretKey || !this.secretKey) throw new Error('API keys are not set');
  }
}
