// 산술 연산자
// console.log(5 + 5);
// console.log(5 - 10);
// console.log(5/2); // 나눈 몫
// console.log(5*4); // Asterisk
// console.log(10 % 3); //나눈 나머지값
// console.log(2 ** 2);// 제곱 연산

// 증감 연산자
let age = 5;

// 후위 연산: 코드의 실행을 다 하고나서 연산을 수행
// console.log(age++); // age 변수의 값을 1 증가
// console.log(age--); 
// console.log(age);

// 전위 연산: 연산 후 코드 실행


// 관계 연산자
// const result = age > 10;
// a > 5?와 같은 일련의 조건을 물어보는, 대답을 예/아니오라고 할 수 밖에 없는
// 연산들의 결과값은 항상 true 아니면 false
// console.log(typeof result); // true와 false는 boolean 타입

// console.log(age <= 5); // 이상, 이하 등의 관계 표현은 부등호 먼저 작성 후 등호 작성

// 동등 연산자
// 서로 타입이 다를 경우 변환하여 비교
// console.log(1 == '1'); // 코드 수행 과정에서 JS엔진이 암묵적(implicit)으로 '1'을 1로 타입(형, 形) 변환
// console.log(1 === '1'); // strict 비교

// 논리 연산자
console.log(true && true); // &&: And연산, ~이고
console.log(5 > 3 && 2 === 2);
console.log(5 > 3 || 2 !== 2); // !==, 같지 않다는 비교 시

// 삼항 연산자(Ternary operator)
// 표기법: 조건식 ? true일 때 : false일 때
let yourAge = 25;
let beverage = yourAge >= 20 ? '소주' : '사이다';

// 할당 연산자(우선 순위가 가장 낮음), 변수에 값을 대입할 때 사용
yourAge = yourAge + 1; // 올해가 지났다. 한살 추가
yourAge += 1; // 축약표현, yourAge = yourAge + 1;