# upbit-js

upbit-js provides API of UPBIT crypto currency exchange.

Currently UPBIT API version v1.0.2 is implemented.

Using upbit-js users can:
- easily access to UPBIT exchange's candle data, order books, private order list.
- order bid and ask
- cancel orders
- see list of user's orders
- see list of user's assets
- see available markets


### Installation
```
$ npm install upbit-js
```




### How to code in Javascript

```
const Upbit = require('upbit-js').Upbit;
const upbit = new Upbit();

// list all available markets in UPBIT
upbit.marketAll().then( value => {
  console.log(value);
})

// get 100 candle data for 15 minutes unit of KRW-XRP market
upbit.candlesMinutes({unit: 15, market: 'KRW-XRP', count: 100, to: undefined})
.then( value => {
  console.log(value);
})
.catch( err => {
  console.error(err);
})
```


### How to code in Typescript
```
import { Upbit } from 'upbit-js';
const upbit: Upbit = new Upbit();

// get 200 candle data at day unit of BTC-ETH market
upbit.candlesDays( { market: 'BTC-ETH', count: 200 })
.then( value => {
  console.log(value);
})
.catch( err => {
  console.error(err);
})

```



### Quatation APIs
```
marketAll()
: Promise<void>
```

```
// units: unit of minutes candle. available units are 1, 3, 5, 15, 10, 30, 60, 240
// count: # of candles. max value is 200
// market: available market code can be listed by calling upbit.marketAll()
// to: last datetime of candles. if undefined, request candles to latest time

candlesMinutes(param: {units: number, market: string, count?: number, to?: string })
: Promise<void>
```

```
// count: # of candles. max value is 200
// market: available market code can be listed by calling upbit.marketAll()
// to: last datetime of candles. if undefined, request candles to latest time
candlesDays(param: {market: string, count?: number, to?: string })
: Promise<void>

```

```
// count: # of candles. max value is 200
// market: available market code can be listed by calling upbit.marketAll()
// to: last datetime of candles. if undefined, request candles to latest time
candlesWeeks(param: {market: string, count?: number, to?: string })
: Promise<void>

```

```
// count: # of candles. max value is 200
// market: available market code can be listed by calling upbit.marketAll()
// to: last datetime of candles. if undefined, request candles to latest time
candlesMonths(param: {market: string, count?: number, to?: string })
: Promise<void>

```

```
tradesTicks(param: {market: string, to?: string, count?: number, cursor?: string})
: Promise<void>
```

```
// multiple markets can be iterated using comma 
// ex) 'KRW-BTC,KRW-ETH,KRW-XRP'
ticker(param: {markets: string})
: Promise<void>
```

```
// multiple markets can be iterated using comma 
// ex) 'KRW-BTC,KRW-ETH,KRW-XRP'
orderBook(param: {markets: string})
: Promise<void>
```

### Exchange APIs

```
// To use some exchange APIs, you need to acquire access token and secret key
// You can request for those secrets in Upbit service site.
```

```
// set/get accessToken and secretToken. 
setAuth(accessToken: string, secretToken: string): void
getAccessToken(): string
getSecretToken(): string
```

```
// show all balances of the user. accessToken and secretToken should be set by setAuth
getAccounts(): Promise<void>
```

```
getOrdersChance(market: string): Promise<void>
```

```
// get all order list of a specific market
getOrders(market: string, state?: OrderState, page?: number, orderBy?: string): Promise<void>

// response example:
[{"uuid":"bdf1d5bc-a733-4835-9a19-6f6b6884e5d7","side":"ask","ord_type":"limit","price":"500.0","state":"wait","market":"KRW-XRP","created_at":"2019-04-07T19:15:43+09:00","volume":"100.0","remaining_volume":"100.0","reserved_fee":"0.0","remaining_fee":"0.0","paid_fee":"0.0","locked":"100.0","executed_volume":"0.0","trades_count":0}]
```


```
getOrder(uuid?: string, identifier?: string): Promise<void>

//response example
{"uuid":"bdf1d5bc-a733-4835-9a19-6f6b6884e5d7","side":"ask","ord_type":"limit","price":"500.0","state":"wait","market":"KRW-XRP","created_at":"2019-04-07T19:15:43+09:00","volume":"100.0","remaining_volume":"100.0","reserved_fee":"0.0","remaining_fee":"0.0","paid_fee":"0.0","locked":"100.0","executed_volume":"0.0","trades_count":0,"trades":[]}
```

```
// order trade

// market: REQUIRED
// side: 'ask' | 'bid'  REQUIRED
// volume: amount of coin. ex) '0.283'  REQUIRED
// price: ex) '23.87'  REQUIRED
// ordType: 'limit' REQUIRED
postOrders(market: string, side: string, volume: string, price: string, ordType: string): 
```

```
// cancel order
// need to get uuid by calling getOrders() or getOrder() 
delOrder(uuid: string): Promise<void>
```
