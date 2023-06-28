// 내 위치(script.js) 기준 외부(다른 파일, 다른 API 코드 등)의 다른 것들을 가져올 때 import 키워드 사용
// import { 가져오고 싶은 함수명, 변수명 등 } from '외부 파일의 경로';

import { sum, division, mul ,sub, number  } from './function.js'

console.log(number);

const x = 10;
const y = 5;

document.getElementById('add').textContent = sum(x, y);
document.getElementById('sub').textContent = sub(x, y);
document.getElementById('mul').textContent = mul(x, y);
document.getElementById('division').textContent = division(x, y);

