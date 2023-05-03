import { default as Upbit } from '../upbit';

describe('Upbit API exchange', () => {
  // To test exchange APIs, you should set proper Access Key and Secret Key
  // which can be able to generate at Upbit site
  const accessKey = process.env.TEST_ACCESS_KEY;
  const secretKey = process.env.TEST_SECRET_KEY;
  const upbit = new Upbit(accessKey, secretKey);
  beforeEach( (async () => {
  }));

  xit('postOrders', (async () => {
    const res = await upbit.postOrders('KRW-XRP', 'ask', '2', '340', 'limit');
    console.log(res);
  }));

  xit('delOrder', (async () => {
    const res = await upbit.delOrder('d99e51ba-d7a3-4b46-8e0f-1fb55db8cbc1');
    console.log(res);
  }));

});
