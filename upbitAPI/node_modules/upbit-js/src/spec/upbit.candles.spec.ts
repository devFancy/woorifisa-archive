import * as _ from 'lodash';
import {
  candlesDays,
  candlesMinutes,
  candlesMonths,
  candlesWeeks
} from '../quotation';

describe('Upbit API candles', () => {

  beforeEach( (async () => {
  }));

  it('caldles minutes', (async () => {
    const count = 5;
    const market = 'KRW-BTC';
    const unit = 1;
    const res = await candlesMinutes({unit, market, count});
    expect(res.length).toBe(count);
    expect(_.sample(res).market).toBe(market);
    expect(_.sample(res).unit).toBe(unit);
  }));

  it('caldles days', (async () => {
    const count = 5;
    const market = 'KRW-BTC';
    const res = await candlesDays({market, count});
    expect(res.length).toBe(count);
    expect(_.sample(res).market).toBe(market);
  }));

  it('caldles weeks', (async () => {
    const count = 5;
    const market = 'KRW-BTC';
    const res = await candlesWeeks({market, count});
    expect(res.length).toBe(count);
    expect(_.sample(res).market).toBe(market);
  }));

  it('caldles months', (async () => {
    const count = 5;
    const market = 'KRW-BTC';
    const res = await candlesMonths({market, count});
    expect(res.length).toBe(count);
    expect(_.sample(res).market).toBe(market);
  }));

});
