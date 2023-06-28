// 기본적인 함수 정의, '함수 선언문' 방식
/*
파라미터: 함수에 값을 전달하기 위해 참고하는 부분

    function 함수명(함수 파라미터 or 인수 작성 부분 2개 이상) { -> 함수 선언부, 시그니처
        // 함수 동작시킬 코드 -> 함수 구현부 
    }
*/

/**
 * JSDOC
 * 두 수를 받아서 덧셈 결과를 반환하는 함수
 * 
 * @param {number} a 
 * @param {number} b 
 * @return {number} 덧셈 결과를 반환한다.
 * @author 'yoo'
 */
function add(a, b) {
    const result = a + b;
    return result; // or return a + b;
}

// 함수 호출 시에는 함수의 이름과 함께 () 작성 필수
console.log(add(2,3));

// 함수 역시 객체 타입의 값이기 때문에 생성한 함수를 변수에 할당할 수 있음
// 함수를 생성하는 두 번째 방식: '함수 표현식' 방식
const mtp = function multiply(a, b) {
    return a * b;
}

// 함수를 mtp라는 변수에 담았기 때문에 mtp라는 이름으로 호출할 수 있음
console.log(mtp(2, 3));

// Function 생성자 함수 생성 방식

// ES -> (ECMAScript) 
// ES6 (약 ES2015) 등장한 문법, 화살표 함수
// In JS, => (Fat arrow) / In Java, ->(Thin arrow)
const sub = (a, b) => { return a - b; }
// 코드가 한 줄일 경우에는 { }, return 키워드 생략 가능
const sub2 = (a, b) => a - b;
console.log(sub(10, 15));
console.log(sub2(10, 15));

