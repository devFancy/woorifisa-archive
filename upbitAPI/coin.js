const options = {method: 'GET', headers: {accept: 'application/json'}};
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
  const response = await fetch('https://api.upbit.com/v1/ticker?markets=' + varString, options)
  const preList = await response.json();

  return preList.map(coin => {
    return {
      market_name: coin.market,
      trade_price: coin.trade_price
    };
  });
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

//market 코드 비교 후 배열 생성
const section2 = (coins, price, numString) => {
  let emptyArr = [];
  for (let i = 0; i < price.length; i++) {
    let priceString = String(price.trade_price);
    let cnt = 0;
    for (let k = 0; k < priceString.length; k++) {
      if(numString === priceString[i]){
        cnt++;
      }
    }
    if(cnt >= 2){
      for (let j = 0; j < coins.length; j++) {
        if(price.market_name === coins.market_name){
          emptyArr.push([coins.korean_name, price.trade_price]);
        }  
      }
    } 
    }
  }