// 코인 슬롯 머신 데이터, 코인 리스트 데이터 (API)
// 변수 선언
const options = {method: 'GET', headers: {accept: 'application/json',}};// API 연결시 필요한 옵션
const [slotBox1, slotBox2, slotBox3] = document.getElementsByClassName('coin-slot-machine-innerbox-content');// 슬롯 머신 화면에 연결하기 위해 필요한 배열
const ballButton = document.getElementById('ball');// 슬롯 머신의 버튼

// 이벤트 핸들러
// 슬롯 머신 버튼이 클릭되는 경우를 기다리는 중
ballButton.addEventListener('click', () => {
   // 버튼이 클릭되면 함수 호출
  slotMachine();
});

// 화면에 연결할 데이터(시세 종목)를 불러와서 화면에 연결
const slotMachine = async () => {
  // 페이지에 연결할 데이터를 받아오는 함수
  const coinMarketData = await coinMarketApi();

  // 받아온 데이터를 배열에 넣고, 화면에 연결
  const [coinName1, coinName2, coinName3] = randomCoin(coinMarketData);
  slotBox1.textContent = coinName1;
  slotBox2.textContent = coinName2;
  slotBox3.textContent = coinName3;
}

//시세 종목 api 데이터 받아오는 부분
const coinMarketApi = async () => {
  // API 연결
  const response = await fetch('https://api.upbit.com/v1/market/all?isDetails=false', options);
  const coinMarketData = await response.json();

   // 받아온 데이터를 필요한 부분만 배열로 반환
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
  //총 3개의
  for (let i = 0; i < 3; i++) {
    //랜덤 뽑아서
    let namePick = Math.floor(Math.random() * coinMarketData.length);
    //배열에 push
    randomNameArr.push(coinMarketData[namePick].korean_name)
  }
  return randomNameArr;
}

//시세 api 데이터 받아오는 부분
const coinPriceApi = async (coinMarketCode) => {
  // API 연결
  const response = await fetch('https://evening-basin-41678.herokuapp.com/https://api.upbit.com/v1/ticker?markets=' + coinMarketCode, options);
  const coinPriceData = await response.json();

  // 받아온 데이터를 필요한 부분만 배열로 반환
  return coinPriceData.map(coin => {
    return {
      market_name: coin.market,
      trade_price: coin.trade_price
    };
  });
}
// 시세 종목 api에서 받아온 데이터와 시세 api에서 받아온 데이터 비교하여 numString 이 2개 이상인 경우 배열 반환 (아닌 경우는 undefined 반환)
const coinMatching = (coinMarketData, coinPriceData, numString) => {
  let namePriceArr = [] // 반환할 배열
  let priceString = String(coinPriceData[0].trade_price);// 문자열로 비교를 위해 비교할 값을 문자열로 변경
  let cntNumString = 0;// numString과 몇 번 같은지 세는 변수

  // numString과 몇 번 같은지 세는 반복문
    for (let k = 0; k < priceString.length; k++) {
      if (numString === priceString[k]) {
        cntNumString++;
      }
    }

    // numString과 2번 이상 같은 경우 시세 종목의 한국명과 시세를 배열로 반환
    if(cntNumString >= 2){
      for (let j = 0; j < coinMarketData.length; j++) {
        if (coinPriceData[0].market_name === coinMarketData[j].market_name) {
          namePriceArr.push([coinMarketData[j].korean_name, coinPriceData[0].trade_price])
        }
      }
      return namePriceArr
    }
}


// 코인 리스트에 저장할 데이터를 불러온다
const coinList = async ( coinMarketData, numString ) => {
  let namePriceArr = [];
  let listNum = 0;

  for (let i = 0; i < coinMarketData.length; i++) {
    // 시세 종목 API에서 받아온 종목 코드를 통해 모든 종목에 대한 시세 데이터를 가져온다
    const coinPriceData = await coinPriceApi(coinMarketData[i].market_name);
    // 가져온 데이터에서 numString과 같은 경우에만 [시세 종목 한국명, 시세] 를 반환 받는다
    namePriceArr = coinMatching(coinMarketData, coinPriceData, numString);

    // 받아온 데이터가 존재할 경우, 테이블의 행이 다 채워지지 않은 경우에만 화면에 보이는 테이블에 데이터를 적용한다
    if (namePriceArr !== undefined && listNum < 5) {
      renderTable(numString, listNum+1, namePriceArr);
      listNum++;
    }

    // 테이블의 행이 5개여서 다 채워지면 더 이상 데이터를 받아오지 않는다 (API 요청도 더 이상 보내지 않음)
    if(listNum === 5){
      break;
    }
  }
}


// 테이블 생성
function renderTable(numString, listNum, namePriceArr){
  // 테이블 생성
  let trName = '#table' + numString + '-'+ listNum + 'Name';
  let trPrice = '#table' + numString + '-' + listNum + 'Price';

  // 화면에 보이는 테이블에 데이터 보여주기 및 스타일 조정
  const tr = document.querySelector(trName)
  tr.textContent = namePriceArr[0][0];
  tr.style.height = '19%';
  tr.style.width = "50%";
  document.querySelector(trPrice).textContent = namePriceArr[0][1];
}

// 페이지가 켜지자마자 동작되는 함수
window.onload = async function () {
  // 시세 종목 API 데이터를 불러온다.
  const coinMarketData = await coinMarketApi();

  // 시세 API 데이터를 받아 화면에 테이블에 적용한다.
  coinList(coinMarketData, '4');
  coinList(coinMarketData, '7');
  coinList(coinMarketData, '2');
};