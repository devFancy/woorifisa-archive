const WebSocket = require('ws');
const uuidv4 = require('uuid/v4');

const ws = new WebSocket('wss://api.upbit.com/websocket/v1', {
  origin: 'https://api.upbit.com/websocket/v1'
});


ws.on('open', function open() {
  console.log('connected');

  const msg = [
    { ticket: uuidv4() },
    { type: 'ticker',
      codes: ['KRW-BTC', 'KRW-ETH', 'KRW-XRP'] }
  ]

  ws.send(JSON.stringify(msg));

  function ping() {
    ws.send('ping');
    setTimeout(ping, 1000);
  }

  setTimeout(ping, 1000);
});

ws.on('close', function close() {
  console.log('disconnected');
});

ws.on('message', function incoming(data) {
  console.log(`${data}`);
  const obj = JSON.parse(data);
  switch(obj.code) {
    case 'KRW-BTC':
      console.log(obj.trade_price);
      break;
    case 'KRW-ETH':
      console.log(obj.trade_price);
      break;
    case 'KRW-XRP':
      console.log(obj.trade_price);
      break;
  }
 });
