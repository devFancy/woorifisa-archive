
export class Constant {

  public static GetConstant() {
    if (!this.constant) this.constant = new Constant();
    return this.constant;
  }
  private static constant: Constant | undefined = undefined;

  // quotation API
  public UPBIT_URL_V1: string                 = 'api.upbit.com/v1';
  public UPBIT_URL_MARKET_ALL: string         = 'market/all';
  public UPBIT_URL_CANDLES_MINUTE: string     = 'candles/minutes';
  public UPBIT_URL_CANDLES_DAYS: string       = 'candles/days';
  public UPBIT_URL_CANDLES_WEEKS: string      = 'candles/weeks';
  public UPBIT_URL_CANDLES_MONTHS: string     = 'candles/months';
  public UPBIT_URL_TRADES_TICKS: string       = 'trades/ticks';
  public UPBIT_URL_TICKER: string             = 'ticker';
  public UPBIT_URL_ORDERBOOK: string          = 'orderbook';

  // exchange API
  public UPBIT_URL_ACCOUNTS: string           = 'accounts';
  public UPBIT_URL_ORDERS_CHANCE: string      = 'orders/chance';
  public UPBIT_URL_ORDER: string              = 'order';
  public UPBIT_URL_ORDERS: string             = 'orders';

  public UPBIT_URL_WITHRAWS: string           = 'withdraws';
  public UPBIT_URL_WITHRAW: string            = 'withdraw';
  public UPBIT_URL_WITHRAWS_CHANCE            = 'withdraws/chance';
  public UPBIT_URL_WITHRAWS_COIN              = 'withdraws/coin';
  public UPBIT_URL_WITHRAWS_KRW               = 'withdraws/krw';

  public UPBIT_URL_DEPOSITS                   = 'deposits';
  public UPBIT_URL_DEPOSIT                    = 'deposit';
  public UPBIT_URL_DEPOSITS_GENERATE_COIN_ADDRESS = 'deposits/generate_coin_address';
  public UPBIT_URL_DEPOSITS_COIN_ADDRESSES    = 'deposits/coin_addresses';
  public UPBIT_URL_DEPOSITS_COIN_ADDRESS      = 'deposits/coin_address';

  private constructor() {
  }

}

export const constant = Constant.GetConstant();
