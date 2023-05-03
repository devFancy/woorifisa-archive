const WsTicker = require('../../dist/index').WsTicker;

const ticker = new WsTicker([ 'KRW-BTC', 'KRW-ETH', 'KRW-XRP'], {
    open: (err, value) => {
      console.log('connected');
    },
    close: () => {
      console.log('disconnected');
    },
    message: (value) => {
      const obj = JSON.parse(value);
      if(obj.code === 'KRW-BTC') {
        // using ws message handler
        console.log('BTC');
        console.log(obj);
      }
    }
  },
  {
    simpleFormat: false,
    isOnlyRealtime: true
  }
)

//using registered handler
ticker.register('KRW-ETH', (err, value) => {
  console.log('ETH');
  console.log(value);
});

// using getObject. latest value is updated within object
// this is not recommended though since latest data could not be updated property
setInterval( () => {
  console.log('XRP');
  console.log(ticker.getObject('KRW-XRP'));
}, 1000);
