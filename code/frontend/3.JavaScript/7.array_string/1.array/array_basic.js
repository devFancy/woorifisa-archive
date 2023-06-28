// 직접 같이 타이핑하며 학습
const array = ['orange', 'cookie', 'orange-cookie'];

console.log(array);
console.log(typeof array);// 기본타입을 제외한 모든 것은 객체

// 정말 Array 타입인지 확인
console.log(Array.isArray(array));

console.log(array.length);

// 요소의 조회, 참조
console.log(array[0], array[2], array[4]);

const strArr = ['orange', 'kiwi', 'apple'];
delete strArr[1];// 희소배열이 생성되어서 비추천

// 희소배열은 요소의 개수가 변하지 않기 때문에 헷갈림
console.log(strArr, strArr.length); 

strArr.push('cookie');
console.log(strArr);

// Array.(prototype).splice(삭제를 시작할 인덱스, 삭제할 요소의 개수) 
// 를 사용하여 요소 제거
const nutArr = ['walnut', 'almond', 'pinenut'];

nutArr.splice(1, 1);
console.log(nutArr);