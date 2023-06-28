// In JS
// let userName;

let userName : string; // userName은 string 타입만 받을 수 있도록 제한
// console.log(userName);
// Variable 'userName' is used before being assigned.ts(2454)

userName = "Yoo";
console.log(userName);

userName = 5;
// Type 'number' is not assignable to type 'string'.ts(2322)

const allUsers = 5; // 5는 number이기 때문에 number 타입으로 추론 됨

let userAddress = 5;

// 리터럴 타입 : 5;, '문자열'과 같은 값 그 자체가 타입
// 1,2,3,4,5 -> number

allUsers = 10; // Cannot assign to 'allUsers' because it is a constant.ts(2588)