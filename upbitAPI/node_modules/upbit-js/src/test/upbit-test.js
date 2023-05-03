const Upbit = require('../../dist/index').Upbit;

const upbit = new Upbit();

upbit.marketAll().then( value => {
  console.log(value);
});
