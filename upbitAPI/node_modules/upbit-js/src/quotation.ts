import * as request from 'superagent';
import * as url from 'url';
import { constant } from './constant';

export async function marketAll() {
  const uri = url.format({
    protocol: 'https',
    hostname: constant.UPBIT_URL_V1,
    pathname: constant.UPBIT_URL_MARKET_ALL
  });
  const res = await request.get(uri);
  return res.body;
}

// candles
export async function candlesMinutes(param: {unit: number, market: string, count?: number, to?: string}) {
  const {unit, market, count, to } = param;
  const uri = url.format({
    protocol: 'https',
    hostname: constant.UPBIT_URL_V1,
    pathname: `${constant.UPBIT_URL_CANDLES_MINUTE}/${unit}`
  });
  const res = await request.get(uri)
    .query({ market })
    .query({ count })
    .query({ to });
  return res.body;
}

export async function candlesDays(param: {market: string, count?: number, to?: string}) {
  const { market, count, to } = param;
  const uri = url.format({
    protocol: 'https',
    hostname: constant.UPBIT_URL_V1,
    pathname: `${constant.UPBIT_URL_CANDLES_DAYS}`
  });
  const res = await request.get(uri)
    .query({ market })
    .query({ count })
    .query({ to });
  return res.body;
}

export async function candlesWeeks(param: {market: string, count?: number, to?: string}) {
  const { market, count, to } = param;
  const uri = url.format({
    protocol: 'https',
    hostname: constant.UPBIT_URL_V1,
    pathname: `${constant.UPBIT_URL_CANDLES_WEEKS}`
  });
  const res = await request.get(uri)
    .query({ market })
    .query({ count })
    .query({ to });
  return res.body;
}

export async function candlesMonths(param: {market: string, count?: number, to?: string}) {
  const { market, count, to } = param;
  const uri = url.format({
    protocol: 'https',
    hostname: constant.UPBIT_URL_V1,
    pathname: `${constant.UPBIT_URL_CANDLES_MONTHS}`
  });
  const res = await request.get(uri)
    .query({ market })
    .query({ count })
    .query({ to });
  return res.body;
}

// trade ticks
export async function tradesTicks(param: {market: string, to?: string, count?: number, cursor?: string}) {
  const { market, to, count, cursor } = param;
  const uri = url.format({
    protocol: 'https',
    hostname: constant.UPBIT_URL_V1,
    pathname: constant.UPBIT_URL_TRADES_TICKS
  });
  const res = await request.get(uri)
    .query({ market })
    .query({ to })
    .query({ count })
    .query({ cursor });

  return res.body;
}

export async function ticker(param: {markets: string}) {
  const uri = url.format({
    protocol: 'https',
    hostname: constant.UPBIT_URL_V1,
    pathname: constant.UPBIT_URL_TICKER
  });
  const res = await request.get(uri)
    .query({ markets: param.markets });
  return res.body;
}

export async function orderBook(param: {markets: string}) {
  const uri = url.format({
    protocol: 'https',
    hostname: constant.UPBIT_URL_V1,
    pathname: constant.UPBIT_URL_ORDERBOOK
  });
  const res = await request.get(uri)
    .query({ markets: param.markets });
  return res.body;
}
