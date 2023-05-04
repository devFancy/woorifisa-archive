const options = {method: 'GET', headers: {accept: 'application/json',}};

const [slotBox1, slotBox2, slotBox3] = document.getElementsByClassName('coin-slot-machine-innerbox-content');

const ballButton = document.getElementById('ball');

ballButton.addEventListener('click', () => {
  slotMachine();
});

//페이지의 텍스트에 연결하는 부분
const slotMachine = async () => {
  const coinMarketData = await coinMarketApi();
  const [coinName1, coinName2, coinName3] = randomCoin(coinMarketData);
  slotBox1.textContent = coinName1;
  slotBox2.textContent = coinName2;
  slotBox3.textContent = coinName3;
}

//시세 종목 api 데이터 받아오는 부분
const coinMarketApi = async () => {
  const response = await fetch('https://api.upbit.com/v1/market/all?isDetails=false', options);
  const coinMarketData = await response.json();
  
  return coinMarketData.map(coin => {
    return {
      market_name: coin.market,
      korean_name: coin.korean_name,
      english_name: coin.english_name
    };
  });
}
//랜덤 함수 출력
const randomCoin = (coinMarketData) => {
  let randomNameArr = [];
  for (let i = 0; i < 3; i++) {
    let namePick = Math.floor(Math.random() * coinMarketData.length);
    randomNameArr.push(coinMarketData[namePick].korean_name)
  }
  return randomNameArr;
}


const coinPriceApi = async (coinMarketCode) => {
  const response = await fetch('https://evening-basin-41678.herokuapp.com/https://api.upbit.com/v1/ticker?markets=' + coinMarketCode, options);
  const coinPriceData = await response.json();

  return coinPriceData.map(coin => {
    return {
      market_name: coin.market,
      trade_price: coin.trade_price
    };
  });
}

const coinMatching = (coinMarketData, coinPriceData, numString) => {
  let namePriceArr = []
  //지워도 되는 부분?
  console.log(coinMarketData)
  console.log(coinPriceData, coinPriceData[0].trade_price, coinPriceData.trade_price)
  let priceString = String(coinPriceData[0].trade_price);
  let cntNumString = 0;

    for (let k = 0; k < priceString.length; k++) {
      if (numString === priceString[k]) {
        cntNumString++;
      }
    }
    if(cntNumString >= 2){
      for (let j = 0; j < coinMarketData.length; j++) {
        if (coinPriceData[0].market_name === coinMarketData[j].market_name) {
          namePriceArr.push([coinMarketData[j].korean_name, coinPriceData[0].trade_price])
        }
      }

      return namePriceArr
    }
}


const coinList = async ( coinMarketData, numString ) => {
  let namePriceArr = [];
  let listNum = 0;

  for (let i = 0; i < coinMarketData.length; i++) {
    const coinPriceData = await coinPriceApi(coinMarketData[i].market_name);
    namePriceArr = coinMatching(coinMarketData, coinPriceData, numString);

    if (namePriceArr !== undefined && listNum < 5) {
      console.log(namePriceArr);
      renderTable(numString, listNum+1, namePriceArr);
      listNum++;
    }
    if(listNum === 5){
      break;
    }

  }

}


// 테이블 생성
function renderTable(numString, listNum, namePriceArr){
  //지워도 되는 부분?
  console.log(listNum);
  let trName = '#table' + numString + '-'+ listNum + 'Name';
  let trPrice = '#table' + numString + '-' + listNum + 'Price';
  console.log(namePriceArr[0][0])
  const tr = document.querySelector(trName)
  tr.textContent = namePriceArr[0][0];
  tr.style.height = '19%';
  tr.style.width = "50%";
  document.querySelector(trPrice).textContent = namePriceArr[0][1];
}

//오버라이딩
window.onload = async function () {
  const coinMarketData = await coinMarketApi();
  coinList(coinMarketData, '4');
  coinList(coinMarketData, '7');
  coinList(coinMarketData, '2');
};