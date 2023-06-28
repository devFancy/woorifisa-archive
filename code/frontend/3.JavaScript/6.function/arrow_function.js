// 두 수 a, b를 받아서 합을 반환하는 함수 sum
const sum = (a, b) => a + b; // 암묵적인(Implicit) return

// -> 기존 함수는 { }를 사용하고, return 키워드를 썼지만, 화살표 함수는 둘 다 사용하지 않을 수 있음

// body(함수 구현부) 부분이 2줄 이상이면, { }, return 키워드 작성 필수
const sub = (a, b) => {
    console.log('뺄셈입니다.');
    return a - b;
}

// 반환해야 하는 값이 객체일 경우??
const division = (a, b) => { // division은 나눗셈 기능 구현하면 되는데, 객체 반환 설명하다가 딴길로 샘
    return {
        age: 2,
        name: 'toto'
    }
}

// 코드가 한줄인데, 객체({})를 반환하고싶다. 예외적으로 소괄호 추가하여 객체라고 명시
const division2 = (a, b) => ({ age: 2, name: 'toto'})

// 파라미터가 1개밖에 없을 경우에는 파라미터 부분의 ()를 안써도 됨
const square = x => x * x;

console.log(square(5));

// 파라미터가 한개도 없는 경우? () 작성 필수
const greet = () => 5;
greet();

const a = 5;