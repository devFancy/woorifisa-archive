

// const sdk = require('api')('https://api.upbit.com/v1/market/all');

// const { Upbit } = require("upbit-js");

// const sdk = require('api')('@upbit/v1.3.3#1h2zv2al3jq48nm');


// sdk.ticker()
//   .then(({ data }) => console.log(data))
//   .catch(err => console.error(err));

// fetch('@upbit/v1.3.3#1h2zv2al3jq48nm')
//   .then(response => response.json())
//   .then(json => console.log(json))






// const Upbit = require('@upbit-js').Upbit;

// const accessKey = 'djczboHEZA5JPv5Ydliij8yWxmBHsx3pgrrX9OOy';
// const secretKey = 'fL6ER8F91kHSxJLW3l2SHTdBmRKhhoaddgVaa2OV';

// // const Upbit = require('@upbit/upbit-js');

// const upbit = new Upbit(accessKey, secretKey);

// // 잔고 조회
// upbit
//   .getAccounts()
//   .then((result) => {
//     console.log(result);
//   })
//   .catch((error) => {
//     console.error(error);
//   });

// // 시세 조회
// upbit
//   .getMarketAll()
//   .then((result) => {
//     console.log(result);
//   })
//   .catch((error) => {
//     console.error(error);
//   });

// // 주문 예제
// // 매수
// upbit
//   .order({
//     market: 'KRW-BTC',
//     side: 'bid',
//     volume: '0.001',
//     price: '40000000',
//     ord_type: 'limit',
//   })
//   .then((result) => {
//     console.log(result);
//   })
//   .catch((error) => {
//     console.error(error);
//   });

// // 매도
// upbit
//   .order({
//     market: 'KRW-BTC',
//     side: 'ask',
//     volume: '0.001',
//     price: '50000000',
//     ord_type: 'limit',
//   })
//   .then((result) => {
//     console.log(result);
//   })
//   .catch((error) => {
//     console.error(error);
//   });


//   const marketAll = upbit.getMarketAll();

//   console.log(marketAll);

/**
 * npm i upbit-js 터미널 명령
 * 
 */



// upbit.ticker('KRW-BTC').then((ticker) => {
//     console.log(ticker);
//   }).catch((error) => {
//     console.error(error);
//   });



// list all available markets in UPBIT
// upbit.marketAll().then( markets => {
//     const krMarkets = markets.filter(
//         (market) => market.market.split('-')[0] === 'KRW'
//       );
  
//       // 필터링된 코인들의 정보를 출력합니다.
//       krMarkets.forEach((market) => {
//         console.log(`${market.market}: ${market.trade_fee_maker}`);
//       });
//     })
//     .catch((error) => {
//       console.error(error);
// })
// upbit.marketAll().then( value => {
//     console.log(value);
//   })











// const Upbit = require('upbit-js').Upbit;
// const upbit = new Upbit();

// // list all available markets in UPBIT
// upbit.marketAll().then( value => {
//   console.log(value);
// })

// // get 100 candle data for 15 minutes unit of KRW-XRP market
// upbit.candlesMinutes({unit: 15, market: 'KRW-XRP', count: 100, to: undefined})
// .then( value => {
//   console.log(value);
// })
// .catch( err => {
//   console.error(err);
// })

// const sdk = require('upbit-js').Upbit;

// sdk.ticker()
//   .then(({ data }) => console.log(data))
//   .catch(err => console.error(err));


//이부분 마지막
// const options = {method: 'GET', headers: {accept: 'application/json'}};

// fetch('https://api.upbit.com/v1/ticker?markets=KRW-BTC', options)
//   .then(response => response.json())
//   .then(response => console.log(response))
//   .catch(err => console.error(err));







/*
//함수 구현
//섹션1 : 종목 리스트 받아서 랜덤으로 추출
//매개변수 종목 리스트
const randomList = (marketData) => {
  //code	cd	마켓 코드 (ex. KRW-BTC)	String
  const codeList = marketData.code;
  const randomValue = codeList[Math.floor(Math.random() * codeList.length)];

  return randomValue;
}

//섹션2 : 웹 소켓으로 구현 시 리스트 변동 가능
//7, 4, 2의 개수 토대로 리스트 순서 변경
const showList = (marketData, num) => {
  

  return
}
*/


/*
//npm install request-promise
const rp = require("request-promise");

const upbit = new Upbit();

let ticker = [];

upbit.market_all().then((res) => {
  res.data.forEach(element => {
    ticker.push(element.market);
  });
  console.log(ticker);
})

// 시세종목정보
async function market_all() {
  const url = "https://api.upbit.com/v1/market/all";
  let result = await request(url);
  return result;
}

//request
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
*/





/*

//섹션 1


const options = {method: 'GET', headers: {accept: 'application/json'}};

const coinRoulette = () => {
  return fetch('https://api.upbit.com/v1/market/all?isDetails=false', options)
    .then(response => response.json())
    .catch(err => console.error(err));
}

//비동기적 처리 - then()을 안쓰면 Promise가 아직 해결되지 않은 상태에서 문장 처리됨.(undefined)
coinRoulette()
.then(preRoulette => {
  const coins = preRoulette.map(coin => {
    return {
      market_name: coin.market,
      korean_name: coin.korean_name,
      english_name: coin.english_name
    };
  });
  console.log(coins);
  //coin배열 랜덤으로 추출하는 함수 필요 - html이랑 연결
});


//섹션 1 끝

//300
//섹션2

//npm install ccxt
//npm install request-promise

const ccxt = require("ccxt");

setInterval(() => {
  (async () => {
    const exchange = new ccxt.upbit();
    const tickers = await exchange.loadMarkets();

    // Get ticker prices for all symbols
    const tickerPrices = await exchange.fetchTickers(Object.keys(tickers));

    console.log("This is section2");
    // Log ticker prices
    for (const symbol in tickerPrices) {
      const tickerData = tickerPrices[symbol];
      console.log(`Price of ${symbol}: ${tickerData.last}`);
    }
    
  })();
}, 3000);
*/

const options = {method: 'GET', headers: {accept: 'application/json'}};

const coinRoulette = async () => {
  const response = await fetch('https://api.upbit.com/v1/market/all?isDetails=false', options);
  const preRoulette = await response.json();
  
  return preRoulette.map(coin => {
    return {
      market_name: coin.market,
      korean_name: coin.korean_name,
      english_name: coin.english_name
    };
  });
}

const ccxt = require("ccxt");
(async () => {
  const coins = await coinRoulette();
  console.log(section1(coins));
  //기능 1 연결 부분
  // console.log(coins);

  //기능 2 시작
  //processing before comparing
  for (let i = 0; i < coins.length; i++) {
    //-로 스플릿 한 후 해당 코인의 축약형 영문 이름만 추출
    let tmpVar = coins[i].market_name.split('-', 2);
    coins[i].market_name = tmpVar[1];
  }
  // 출력
  // console.log(coins);


 //coinTicker

  setInterval(() => {
    (async () => {
      const exchange = new ccxt.upbit();
      const tickers = await exchange.loadMarkets();
    
      // Get ticker prices for all symbols
      const tickerPrices = await exchange.fetchTickers(Object.keys(tickers));


    
      // console.log("This is section2");
      //market의 ticker와 시세의 ticker 일치할 때 추가할 배열
      const lastTicker = [];
      // Log ticker prices
      for (const symbol in tickerPrices) {
        //symbol slice
        let tmpVar = symbol.split('/',1);

        const tickerData = tickerPrices[symbol];
        // console.log(`Price of ${symbol}: ${tickerData.last}`);
        //compare market ticker
        
        //시장 코드/단위
        // console.log(symbol);
        //가격
        // console.log(tickerData.last);

        for (let i = 0; i < coins.length; i++) {
          // console.log(typeof coins[i].market_name, typeof tmpVar[0]);
      
          if(coins[i].market_name === tmpVar[0]){
              coins[i].cost = tickerData.last;
          }
          
        }


      } 
      //출력
      // console.log(coins);
      console.log(section2(coins, '7'));
    })();
  }, 1000);
})();

const section1 = (coins) => {
  let tmpArr = [];
  for (let i = 0; i < 3; i++) {
    let namePick = Math.floor(Math.random() * coins.length);
    tmpArr.push(coins[namePick].korean_name)
  }
  return tmpArr;
}

//num string으로 받아야합니다.
const section2 = (coins, num) => {

  let tmpArr = [];
  for (let i = 0; i < coins.length; i++) {
    //반복문 시작할 때 배열 길이가 5이면 반환
    if(tmpArr.length === 5){
      return tmpArr;
    }
    //cost String화
    let tmpString = String(coins[i].cost);
    //해당 숫자가 몇 번 반복되는지 확인
    let cnt = 0;
    for(let j = 0; j < tmpString.length; j++){
      if(num === tmpString[j]){
        cnt++;
      }
      //num이 3번 나오면 배열에 추가 후 다음 요소로 넘어감
      if(cnt >= 3){
        tmpArr.push([coins[i].korean_name, coins[i].cost]);
        break;
      }
    }
    
  }

}