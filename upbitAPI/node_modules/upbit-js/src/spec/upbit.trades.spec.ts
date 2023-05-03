import * as _ from 'lodash';
import {
  orderBook,
  ticker,
  tradesTicks
} from '../quotation';

describe('Upbit API tickers', () => {

  beforeEach( (async () => {
  }));

  it('trade ticks', (async () => {
    const market = 'KRW-BTC';
    const obj = await tradesTicks({market, count: 5});
    _.map(obj, value => {
      expect(value.market).toEqual(market);
      expect(value.trade_date_utc).not.toBeNull();
      expect(value.trade_time_utc).not.toBeNull();
      expect(value.timestamp).not.toBeNaN();
      expect(value.trade_price).not.toBeNaN();
      expect(value.trade_volume).not.toBeNaN();
      expect(value.prev_closing_price).not.toBeNaN();
      expect(value.change_price).not.toBeNaN();
      // expect(value.ask_bid).toEqual('BID' || 'ASK');
      expect(value.sequential_id).not.toBeNaN();
    });
  }));

  it('ticker', (async () => {
    const obj = await ticker({markets: 'KRW-BTC'});
    obj.forEach( value => {
      expect( (value.change === 'RISE') || (value.change === 'FALL')).toBeTruthy();

      expect(value.trade_timestamp).not.toBeNaN();
      expect(value.opening_price).not.toBeNaN();
      expect(value.high_price).not.toBeNaN();
      expect(value.low_price).not.toBeNaN();
      expect(value.trade_price).not.toBeNaN();
      expect(value.prev_closing_price).not.toBeNaN();
      expect(value.change_price).not.toBeNaN();
      expect(value.change_rate).not.toBeNaN();
      expect(value.signed_change_price).not.toBeNaN();
      expect(value.signed_change_rate).not.toBeNaN();
      expect(value.trade_volume).not.toBeNaN();
      expect(value.acc_trade_price).not.toBeNaN();
      expect(value.acc_trade_price_24h).not.toBeNaN();
      expect(value.acc_trade_volume).not.toBeNaN();
      expect(value.acc_trade_volume_24h).not.toBeNaN();
      expect(value.highest_52_week_price).not.toBeNaN();
      expect(value.lowest_52_week_price).not.toBeNaN();
      expect(value.timestamp).not.toBeNaN();
      // highest_52_week_date: '2018-05-06',
      // lowest_52_week_date: '2018-12-15',
    });
  }));

  it('order Book', (async () => {
    const krwbtc = 'KRW-BTC';
    const krweth = 'KRW-ETH';
    const krwxrp = 'KRW-XRP';
    const obj = await orderBook({markets: `${krwbtc},${krweth},${krwxrp}`});
    // console.log(obj);
    expect(obj.length).toEqual(3);
    obj.forEach( value => {
      expect(value.total_ask_size).not.toBeNaN();
      expect(value.total_bid_size).not.toBeNaN();
      value.orderbook_units.forEach( unit => {
        expect(unit.ask_price).not.toBeNaN();
        expect(unit.bid_price).not.toBeNaN();
        expect(unit.ask_size).not.toBeNaN();
        expect(unit.bid_size).not.toBeNaN();
      });
    });
  }));
});
