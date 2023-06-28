/*
 * 코드를 여러 파일로 쪼개서 모듈화시키는 방식
 * 관계있는 기능 , 파일끼리 서로 module의 형태로 불러와서 필요한 코드만 사용
 * 그래도 과거에는 모듈화된 변수나 함수들은 전역 객체에서 관리되었음.
 * 
 * 이후, SPA F/W가 나오면서 공통적인 기능의 구현을 위해 외부의 다른 코드(third-party)들을
 * 불러와서 사용해야 하면서 전역 네임스페이스는 덜 오염시키고 코드는 최대한 분할해야하는 요구사항에 직면함
 * 
 * ES6(2015)에서 모듈화를 할 수 있는 import 및 export라는 statement(문)을 소개함
 * 
 */

export function sum(x, y) {
  return x + y;
}

export function sub(x, y) {
  return x - y;
}

export function mul(x, y) {
  return x * y;
}

export function division(x, y) {
  return x / y;
}

// Primitive values
// Primitive values
export const number = 100
const string = 'string'
const undef = undefined
const empty = null
const obj = { name: 'Homer' }
const array = ['Bart', 'Lisa', 'Maggie']

// Class
class Book {
  constructor(name, author) {
    this.name = name
    this.author = author
  }
}
