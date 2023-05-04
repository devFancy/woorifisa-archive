const rp = require("request-promise");
const sign = require("jsonwebtoken").sign;
const queryEncode = require("querystring").encode;

async function request(url, qs, token, method) {
  if (!method) {
    method = "GET";
  }
  let options = {
    method: method,
    url: url,
    json: true,
    transform: function (body, response) {
      let remain_min = 0;
      let remain_sec = 0;
      if (response.headers && response.headers["remaining-req"]) {
        let items = response.headers["remaining-req"].split(";");
        for (let item of items) {
          let [key, val] = item.split("=");
          if (key.trim() == "min") {
            remain_min = parseInt(val.trim());
          } else if (key.trim() == "sec") {
            remain_sec = parseInt(val.trim());
          }
        }
      }
      return {
        success: true,
        remain_min: remain_min,
        remain_sec: remain_sec,
        data: body,
      };
    },
  };
  if (method == "POST") {
    options.json = qs;
  } else {
    options.qs = qs;
  }
  if (token) {
    options.headers = { Authorization: `Bearer ${token}` };
  }
  let result = { success: false, message: null, name: null };
  try {
    result = await rp(options);
  } catch (e) {
    result.data = null;
    if (e.error.error) {
      result.message = e.error.error.message;
      result.name = e.error.error.name;
    } else {
      result.message = e.message;
    }
  }

  return result;
}

//전체 계좌 조회
async function accounts() {
  const url = "https://api.upbit.com/v1/accounts";

  const payload = {
    access_key: this.accessKey,
    nonce: new Date().getTime(),
  };
  const token = sign(payload, this.secretKey);

  let result = await request(url, {}, token);
  return result;
}

// 주문 리스트
async function order_list(market, state, uuids, page) {
  //market: null KRW-BTC
  //state: wait done
  const url = "https://api.upbit.com/v1/orders";
  let qs = { state: state, page: page };
  if (market) qs["market"] = market;
  if (uuids) qs["uuids"] = uuids;

  const query = queryEncode(qs);
  const payload = {
    access_key: this.accessKey,
    nonce: new Date().getTime(),
    query: query,
  };
  const token = sign(payload, this.secretKey);

  let result = await request(url, qs, token);
  return result;
}

// 주문(매수)
async function order_bid(market, volume, price) {
  //market: KRW-BTC
  const url = "https://api.upbit.com/v1/orders";
  let qs = {
    market: market,
    side: "bid",
    volume: volume,
    price: price,
    ord_type: "limit",
  };

  const query = queryEncode(qs);
  const payload = {
    access_key: this.accessKey,
    nonce: new Date().getTime(),
    query: query,
  };
  const token = sign(payload, this.secretKey);

  let result = await request(url, qs, token, "POST");
  return result;
}

// 주문(매도)
async function order_ask(market, volume, price) {
  //market: KRW-BTC
  const url = "https://api.upbit.com/v1/orders";
  let qs = {
    market: market,
    side: "ask",
    volume: volume,
    price: price,
    ord_type: "limit",
  };

  const query = queryEncode(qs);
  const payload = {
    access_key: this.accessKey,
    nonce: new Date().getTime(),
    query: query,
  };
  const token = sign(payload, this.secretKey);

  let result = await request(url, qs, token, "POST");
  return result;
}

// 주문 상세
async function order_detail(uuid) {
  const url = "https://api.upbit.com/v1/order";
  let qs = { uuid: uuid };

  const query = queryEncode(qs);
  const payload = {
    access_key: this.accessKey,
    nonce: new Date().getTime(),
    query: query,
  };
  const token = sign(payload, this.secretKey);

  let result = await request(url, qs, token);
  return result;
}

// 주문 취소
async function order_delete(uuid) {
  const url = "https://api.upbit.com/v1/order";
  let qs = { uuid: uuid };

  const query = queryEncode(qs);
  const payload = {
    access_key: this.accessKey,
    nonce: new Date().getTime(),
    query: query,
  };
  const token = sign(payload, this.secretKey);

  let result = await request(url, qs, token, "DELETE");
  return result;
}

// 주문 가능 정보
async function order_chance(market) {
  const url = "https://api.upbit.com/v1/orders/chance";
  let qs = { market: market };

  const query = queryEncode(qs);
  const payload = {
    access_key: this.accessKey,
    nonce: new Date().getTime(),
    query: query,
  };
  const token = sign(payload, this.secretKey);

  let result = await request(url, qs, token);
  return result;
}

// 시세종목정보
async function market_all() {
  const url = "https://api.upbit.com/v1/market/all";
  let result = await request(url);
  return result;
}

// 분 캔들
async function market_minute(market, unit, to, count) {
  //unit:  1, 3, 5, 15, 10, 30, 60, 240
  //to: yyyy-MM-dd'T'HH:mm:ssXXX
  const url = "https://api.upbit.com/v1/candles/minutes/" + unit;
  let qs = { market: market };
  if (to) qs.to = to;
  if (count) qs.count = count;

  let result = await request(url, qs);
  return result;
}

// 일 캔들
async function market_day(market, to, count) {
  //to: yyyy-MM-dd'T'HH:mm:ssXXX
  const url = "https://api.upbit.com/v1/candles/days";
  let qs = { market: market };
  if (to) qs.to = to;
  if (count) qs.count = count;

  let result = await request(url, qs);
  return result;
}

// 주 캔들
async function market_week(market, to, count) {
  //to: yyyy-MM-dd'T'HH:mm:ssXXX
  const url = "https://api.upbit.com/v1/candles/weeks";
  let qs = { market: market };
  if (to) qs.to = to;
  if (count) qs.count = count;

  let result = await request(url, qs);
  return result;
}

// 월 캔들
async function market_month(market, to, count) {
  //to: yyyy-MM-dd'T'HH:mm:ssXXX
  const url = "https://api.upbit.com/v1/candles/months";
  let qs = { market: market };
  if (to) qs.to = to;
  if (count) qs.count = count;

  let result = await request(url, qs);
  return result;
}

// 채결 정보
async function market_trade_tick(market, to, count) {
  //to: yyyy-MM-dd'T'HH:mm:ssXXX
  const url = "https://api.upbit.com/v1/trades/ticks";
  let qs = { market: market };
  if (to) qs.to = to;
  if (count) qs.count = count;

  let result = await request(url, qs);
  return result;
}

// 시세 Ticker
async function market_ticker(markets) {
  // markets: KRW-BTC,KRW-ETH
  const url = "https://api.upbit.com/v1/ticker";
  let qs = { markets: markets };

  let result = await request(url, qs);
  return result;
}

// 호가 정보
async function trade_orderbook(markets) {
  // markets: KRW-BTC,KRW-ETH
  const url = "https://api.upbit.com/v1/orderbook";
  let qs = { markets: markets };

  let result = await request(url, qs);
  return result;
}

// class Upbit
function Upbit(s, a) {
  this.secretKey = s;
  this.accessKey = a;
}

Upbit.prototype.accounts = accounts;
Upbit.prototype.order_list = order_list;
Upbit.prototype.order_bid = order_bid;
Upbit.prototype.order_ask = order_ask;
Upbit.prototype.order_detail = order_detail;
Upbit.prototype.order_delete = order_delete;
Upbit.prototype.order_chance = order_chance;
Upbit.prototype.market_all = market_all;
Upbit.prototype.market_minute = market_minute;
Upbit.prototype.market_day = market_day;
Upbit.prototype.market_week = market_week;
Upbit.prototype.market_month = market_month;
Upbit.prototype.market_trade_tick = market_trade_tick;
Upbit.prototype.market_ticker = market_ticker;
Upbit.prototype.trade_orderbook = trade_orderbook;

module.exports = Upbit;
