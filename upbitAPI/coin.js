const options = {method: 'GET', headers: {accept: 'application/json'}};
const [s1, s2, s3] = document.getElementsByClassName('coin_slot_machine_innerbox_content');

const ballButton = document.getElementById('ball');

ballButton.addEventListener('click', () => {
  fetchCoin();
});

// const ccxt = require("ccxt");
const fetchCoin = async () => {
  const coins = await coinRoulette();
  const [coinName1, coinName2, coinName3] = section1(coins);
  s1.textContent = coinName1;
  s2.textContent = coinName2;
  s3.textContent = coinName3;

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
}

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

const section1 = (coins) => {
  let tmpArr = [];
  for (let i = 0; i < 3; i++) {
    let namePick = Math.floor(Math.random() * coins.length);
    tmpArr.push(coins[namePick].korean_name)
  }
  return tmpArr;
}

// setInterval (1초마다), 
// setInterval 코드 내부에서 node서버에 요청