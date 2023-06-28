// Parameter 'a' implicitly has an 'any' type.ts(7006)
// -> 파라미터에 별도의 타입을 지정하지 않으면 any타입으로 지정됨
// https://www.typescriptlang.org/ko/docs/handbook/2/everyday-types.html#any

// 파라미터에 타입 선언
function add(a: number, b: number) {
    return a + b;
}

// 함수 옆에 반환 타입으로 number 지정
function sub(a: number, b: number): number {
    return a - b;
}

// void: 별도의 반환값이 없을 때, 
function divide(a: number, b: number): void {
    console.log(a / b);
}

const multiply = (a: number, b: number): number => a * b;

// 반환타입은 return 키워드 뒤에 명시된 값 혹은 연산으로 추론되기 때문에
// 별도로 작성하지 않아도 됨

type Cookie = {
    name: string;
    amount: number;
}

// Cookie 타입만 받는 배열 cookies
const cookies: Cookie[] = [
    { name: 'OREO', amount: 5 }, // Cookie
    { name: 'HERSHEY', amount: 2 }, // Cookie
    { name: 'LOTTE', amount: 3 }, // Cookie
];

// 함수의 시그니처(선언부) 정의, string 타입의 name인수와 반환타입으로 number를 가지는 함수
let printLengthOfName: (name: string) => number;

function checkStockOfCookie(cookieArray: Cookie[] , cookieCounter: (cookie: Cookie) => void) {
    // cookieArray = cookies;
    cookieArray.map(cookieCounter);
}

function myCookieCounter(cookie: Cookie) {
    console.log(`${cookie.name}'s amount is ${cookie.amount}`);
}

checkStockOfCookie(cookies, myCookieCounter);
