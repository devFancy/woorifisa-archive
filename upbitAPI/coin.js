const options = {method: 'GET', headers: {accept: 'application/json',}};

const [s1, s2, s3] = document.getElementsByClassName('coin_slot_machine_innerbox_content');

const ballButton = document.getElementById('ball');

ballButton.addEventListener('click', () => {
  fetchCoin();
});

//페이지의 텍스트에 연결하는 부분
const fetchCoin = async () => {
  const coins = await coinRoulette();
  const [coinName1, coinName2, coinName3] = section1(coins);
  s1.textContent = coinName1;
  s2.textContent = coinName2;
  s3.textContent = coinName3;
}

//시세 종목 api 데이터 받아오는 부분
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


const listRoulette = async (varString) => {
  const response = await fetch('https://evening-basin-41678.herokuapp.com/https://api.upbit.com/v1/ticker?markets=' + varString, options);
  const preList = await response.json();

  return preList.map(coin => {
    return {
      market_name: coin.market,
      trade_price: coin.trade_price
    };
  });
}

const section2 = (coins, price, numString) => {
  let emptyArr = []
  console.log(coins)
  console.log(price, price[0].trade_price, price.trade_price)
  let priceString = String(price[0].trade_price);
  let cnt = 0;

    for (let k = 0; k < priceString.length; k++) {
      if (numString === priceString[k]) {
        cnt++;
      }
    }
    if(cnt >= 2){
      for (let j = 0; j < coins.length; j++) {
        if (price[0].market_name === coins[j].market_name) {
          // console.log(coins[j].market_name, coins[j].korean_name)
          emptyArr.push([coins[j].korean_name, price[0].trade_price])
        }
      }

      return emptyArr
    }
}


const getPrices = async ( coins, numString ) => {
  let tempArray = [];
  let cnt = 0;

  for (let i = 0; i < coins.length; i++) {
    const price = await listRoulette(coins[i].market_name);
    tempArray = section2(coins, price, numString);

    if (tempArray !== undefined && cnt < 5) {
      console.log(tempArray);

      renderTable(numString,cnt+1,tempArray);
      cnt++;

    }

    if(cnt === 5){
      break;
    }

  }

}

//랜덤 함수 출력
const section1 = (coins) => {
  let tmpArr = [];
  for (let i = 0; i < 3; i++) {
    let namePick = Math.floor(Math.random() * coins.length);
    tmpArr.push(coins[namePick].korean_name)
  }
  return tmpArr;
}

// 테이블 생성

function renderTable(id, i, numArray){
  console.log(id)
  let trName = '#table' + id + '-'+ i + 'name';
  let trPrice = '#table' + id + '-' + i + 'price';
  console.log(numArray[0][0])
  // trList += toDOM(numArray[0]);
  // for(let i=0; i<numArray.length; i++) {
  //   trList += toDOM(numArray[i]);
  // }
  const tr = document.querySelector(trName)
  tr.textContent = numArray[0][0];
  tr.style.height = '19%';
  tr.style.width = "50%";

  document.querySelector(trPrice).textContent = numArray[0][1];
}

window.onload = async function () {
  const coins = await coinRoulette();
  getPrices(coins, '4');
  getPrices(coins, '7');
  getPrices(coins, '2');

};

// //market 코드 비교 후 배열 생성
// const section2 = (coins, price, numString) => {
//   let emptyArr = [];
//   for (let i = 0; i < price.length; i++) {
//     let priceString = String(price.trade_price);
//     let cnt = 0;
//     for (let k = 0; k < priceString.length; k++) {
//       if(numString === priceString[i]){
//         cnt++;
//       }
//     }
//     if(cnt >= 2){
//       for (let j = 0; j < coins.length; j++) {
//         if(price.market_name === coins.market_name){
//           emptyArr.push([coins.korean_name, price.trade_price]);
//         }
//       }
//      }
//     }
//     return emptyArr;
//   }

  // const prices = listRoulette();
  // const emptyArr = section2(coins, prices, 7);
  // console.log(coins);