/**
 * JS에서 원시 값(Primitive value)을 제외한 모든 것은 객체.
 *
 * 기본적인 차이는 원시 값은 하나의 값만을 나타내지만, 객체는 다양한 타입의 값을 하나의 단위로
 * 구성한 복합 자료 구조.
 *
 * 원시 값은 변경 불가한 값(immutable value),
 * 객체는 변경 가능한 값(mutable value.)
 *
 * 객체는 프로퍼티(property, 속성)로 구성된 집합, 프로퍼티는 키(key)와 값(value)으로 구성됨.
 *
 * JS에서 사용할 수 있는 모든 값은 프로퍼티 값이 될 수 있음.
 * 함수는 일급 객체이기 때문에 값이 될 수 있고, 따라서 객체의 프로퍼티가 될 수 있음.
 * 프로퍼티 값이 함수일 경우 함수와 구분하기 위해 메서드라고 부름.
 *
 * * 일급 객체란? : https://hanamon.kr/javascript-%EA%B3%A0%EC%B0%A8%ED%95%A8%EC%88%98%EC%99%80-%EC%BD%9C%EB%B0%B1-%EC%9D%BC%EA%B8%89%EA%B0%9D%EC%B2%B4%EB%9E%80/#:~:text=%ED%95%A8%EC%88%98%EA%B0%80%20%EC%9D%BC%EA%B8%89%20%EA%B0%9D%EC%B2%B4%EB%9D%BC%EB%8A%94,%EC%97%90%EC%84%9C%20%EB%B0%98%ED%99%98%EB%90%A0%20%EC%88%98%EB%8F%84%20%EC%9E%88%EB%8B%A4.
 */

// 객체 리터럴 방식({})을 활용한 객체 생성
const dog = { // key: value형식으로 작성
    age: 2, 
    name:'toto'
}; 

const dog2 = {
    age: 2,
    name: 'toto',
    walk: function walk() {
        console.log('강아지가 걷는다');
    }
}

// console.log(dog === dog2);
console.log(dog2.walk());

// 프로퍼티 조회(접근)
console.log(dog.age);

// 프로퍼티 동적 추가, (존재하지 않는 프로퍼티에 값을 할당하면 추가됨.)
dog.color = 'brown';

console.log(dog);
// 프로퍼티 삭제(delete 연산자, 잘 사용하지 않음, 왜?)

delete dog.age;
console.log(dog);