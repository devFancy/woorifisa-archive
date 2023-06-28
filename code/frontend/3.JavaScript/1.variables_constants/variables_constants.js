/**
 * 변수의 종류
 * var, let, const
 * 
 * 변수를 선언, 초기화
 * 
 * 선언: JS 엔진한테 ㅇㅇ이라는 이름의 변수를 쓰겠다고 명시
 * ex) var a;
 * 
 * 초기화: a라는 변수에 내가 원하는 값으로 저장, 할당(=)
 * 
 */

// 모든 코드는 위에서 아래로 수행됨
console.log(a); // var 키워드는 쓰지 않는다.
var a;

// 변수(Variable) - let 키워드 사용
let userName = 5; // '(Single Quote), "(Double Quote) 둘 다 사용 가능
// camelCase 준수(), 첫 번째 글자는 소문자, 두 번째 음절부터는 대문자로시작 
// userAdressName
console.log(userName); // Yoo

let comment = "let's go?";

// 변수는 값(Value)을 재할당할 수 있음
// 재할당 시에는 키워드는 생략하고, 변수의 이름만 다시 불러와서 할당하면 됨
userName = 'Kim';

// 상수(Constant)
const allUsers = 5;
allUsers = 10; // caught TypeError: Assignment to constant variable.
// 상수에 재할당 할 수 없다
// 기본적으로 const로 사용하다가, 값의 변경이 필요할 것 같으면 let으로 변경한다.
const PI = 3.141592;