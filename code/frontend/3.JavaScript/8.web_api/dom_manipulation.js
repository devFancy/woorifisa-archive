// DOM 객체
console.log(document);

// 어떤 객체의 프로퍼티를 조회하고싶을 때,
console.dir(document);

console.log(window.document === document);

// DOM의 조작
const h1 = document.querySelector('h1');
console.log(h1);

// 가독성 측면에서 사용 권장
const h1Tag = document.getElementById('main-title');
console.dir(h1Tag.innerText);

const liList = document.getElementsByClassName('list-item');
console.log([1, 2, 3], typeof [1, 2, 3]);
console.log(liList); // 배열 형태로 가져옴

console.log(document.querySelector('ul li:first-of-type'));
// querySelectAll(); -> 전체 선택해서 가져오기