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
      console.log(section2(coins, "7"));
    })();
  }


  const section2 = (coins, num) => {
    let tmpArr = [];
  
    for (let i = 0; i < coins.length; i++) {
      if(tmpArr.length === 5){
        return tmpArr;
      }
  
      let cnt = 0;
      let tmpString = String(coins[i].cost);
      for(let j = 0; j < tmpString.length; j++){
        if(num === tmpString[j]){
          cnt++;
        }
        if(cnt >= 2){
          let isNew = true;
          for (let k = 0; k < tmpArr.length; k++) {
            //배열 내에 존재하는 이름일 경우 추가하지 않음
            if(coins[i].korean_name === tmpArr[k][0]){
              isNew = false;
              break;
            }
          }
          if(isNew){
            tmpArr.push([coins[i].korean_name, coins[i].cost]);
            break;
          }
        }
      }
    }
  
    // 배열이 5개 미만인 경우 반환값이 없으므로 추가
    return tmpArr;
  }