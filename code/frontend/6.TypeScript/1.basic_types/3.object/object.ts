const dog = {
    age: 2,
    name: 'toto',
    walk: function walk() {
        console.log('강아지가 걷는다');
    }
};

console.log(dog.age);

dog.color = 'brown';
// 프로퍼티 동적 추가 불가능 - 타입스크립트는 일반적으로 정적 타입 시스템 기반이기 때문에 
// 사전에 정의된 타입만 사용 가능, 동적으로 추가되는 프로퍼티 인식 불가

// -> 추가 방법: 인덱싱 가능 타입 사용(indexable type)
// https://velog.io/@dongdong98/index-Signature-%EB%8F%99%EC%A0%81%EC%9C%BC%EB%A1%9C-Object%EC%97%90-property-%EC%B6%94%EA%B0%80%ED%95%98%EA%B8%B0
let cat: { [key: string]: any } = {};
cat.name = '냐옹';
cat.age = 2;
console.log(cat);

// 특정 객체의 타입을 선언
// 사자는 항상 age와 name을 가지고 있다.
let lion: { age: number, name: string };

// lion = {};
// Type '{}' is missing the following properties from type '{ age: number; name: string; }': age, namets(2739)
lion = { age: 2, name: '라이언' };

// 옵셔널(optional) 프로퍼티(? 기호 사용)
let tiger: { age: number, name?: string };

tiger = { age: 3 }; // name프로퍼티는 선택이기 때문에 작성하지 않아도 됨

// 타입 별칭(type alias)를 활용하여 객체 타입 선언

// Cookie라는 커스텀 타입
type Cookie = {// type 키워드 사용, 대문자로 시작
    name: string; // 쿠키 이름
    pubDate: number; // 출시일자
    company: string; // 회사
}; 

let firstCookie: Cookie;

firstCookie = {
    name: 'OREO',
    pubDate: 1913,
    company: 'Nabisco'
};

let secondCookie: Cookie;
secondCookie = {
    name: 'HERSHEY',
    pubDate: 1894,
    company: 'HERSHEY',
}


//==== 추가 주제.
// 위에서 사용한 dog는 타입이 object가 아니라 { age: number, name: string, walk: () => void } 타입임

const mouse: object = {
    age: 2,
    name: 'jerry'
};

console.log(mouse.age); // mouse의 타입이 { age: number, name: string }이 아닌, object로 추론하고 있기 때문에 접근 불가.

// Object vs object vs {} ? - 직접 검색 후 학습
// https://www.typescriptlang.org/ko/docs/handbook/2/functions.html#object


