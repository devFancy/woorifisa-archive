
import * as fs from 'fs';
import { ExchangeApi } from './exchange';
import { OrderState } from './interface';
import * as quotation from './quotation';

export default class Upbit {

  private accessKey: string | undefined;
  private secretKey: string | undefined;
  private exchange: ExchangeApi;
  private marketList = [];
  constructor(accessKey?: string, secretKey?: string) {
    this.accessKey = accessKey;
    this.secretKey = secretKey;
    this.exchange = new ExchangeApi(accessKey, secretKey);
  }

  public async updateMarketAll() {

    try {
      this.marketList = await quotation.marketAll();
    } catch (e) {
      const marketAll = await fs.readFileSync('./marketAll.json', { encoding: 'utf-8'});
      this.marketList = JSON.parse(marketAll);
    }
  }

  public setAuth(accessKey: string, secretKey: string) {
    this.accessKey = accessKey;
    this.secretKey = secretKey;
  }

  public getAccessToken() {
    return this.accessKey;
  }
  public getSecretToken() {
    return this.secretKey;
  }

  public getMarketList() {
    return this.marketList;
  }

  public async marketAll() {
    return quotation.marketAll();
  }
  public async candlesMinutes(param: {unit: number, market: string, count?: number, to?: string}) {
    return quotation.candlesMinutes(param);
  }
  public async candlesDays(param: {market: string, count?: number, to?: string}) {
    return quotation.candlesDays(param);
  }
  public async candlesWeeks(param: {market: string, count?: number, to?: string}) {
    return quotation.candlesWeeks(param);
  }
  public async candlesMonths(param: {market: string, count?: number, to?: string}) {
    return quotation.candlesMonths(param);
  }
  public async tradesTicks(param: {market: string, to: string, count: number, cursor: string}) {
    return quotation.tradesTicks(param);
  }
  public async ticker(param: {markets: string}) {
    return quotation.ticker(param);
  }
  public async orderBook(param: {markets: string}) {
    return quotation.orderBook(param);
  }

  // exchange
  public async getAccounts() {
    return this.exchange.getAccounts();
  }
  public async getOrdersChance(market: string) {
    return this.exchange.getOrdersChance(market);
  }
  public async getOrder(uuid?: string, identifier?: string) {
    return this.exchange.getOrder(uuid, identifier);
  }
  public async getOrders(market: string, state?: OrderState, page?: number, orderBy?: string) {
    return this.exchange.getOrders(market, 'wait', 1);
  }

  public async postOrders(market: string, side: string, volume: string, price: string, ordType: string) {
    return this.exchange.postOrders(market, side, volume, price, ordType);
  }

  public async delOrder(uuid: string) {
    return this.exchange.delOrder(uuid);
  }

}
