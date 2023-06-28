/**
 * 
 * JSON : JavaScript Object Notation
 * 클라이언트와 서버 간의 HTTP 통신을 위한 텍스트 데이터 포맷
 * JS에 종속되지 않는 언어 독립형 데이터 포맷
 * 대부분의 프로그래밍 언어에서 사용 가능
 */

// JSON 작성 방식은 JavaScript의 객체 작성 방식과 유사함

// JSON 작성 방식 : key값 및 문자열은 ""(쌍따옴표, double quote)로 작성해야함.(single quote 불가)
// {
//     "title": "The Old Man And Sea",
//     "author": "Ernest Hemingway",
//     "isSold": false,
//     "genere": ["novel", "essay"],
// }

// JS 객체
const book = {
    title: "The Old Man And Sea",
    author: "Ernest Hemingway",
    isSold: false,
    genere: ["novel", "essay"],
}
// JSON.stringify(변환할 객체);

// 직렬화
console.log(book);
const jsonData = JSON.stringify(book); 
console.log(jsonData);

/**
 * 반대로 서버가 클라이언트 쪽으로 응답한 JSON 데이터는 문자열
 * 이 문자열을 JS에서 다시 사용하기 위해서는 문자열 포맷을 다시 JS 전용 객체 리터럴로 변환해야함.
 * 문자열 포맷을 객체로 변환, 즉 객체화하는 것을 역직렬화(deserialization)라고함.
 */

// 역직렬화
const parsedData = JSON.parse(jsonData);
console.log(parsedData);

// 배열
const books = [
    { id: 1, title: "하농", author: "하농", isSold: false },
    { id: 2, title: "체르니", author: "체르니", isSold: true },
    { id: 3, title: "부르크뮐러", author: "부르크뮐러", isSold: true },
]

