/**
 * Destructuring, 구조 분해
 * 
 * 1. Object
 * 2. Array
 */

// 1. Object
const book = {
    id: 1,
    title: 'The great Gatsby',
    pubDate: '10/04/1925',
};

// 기존 방식
// const id = book.id;
// const title = book.title;
// const pubDate = book.pubDate;

// const { id: myId, title, pubDate } = book;

// console.log(myId);//이름 바꿔서 사용

const anotherBook = {
    id: 2,
    title: "The old man and the sea",
    pubDate: "08/09/1952",
    author: {
        firstName: "Ernest",
        lastName: "Hemingway",
    },
};

// const { id, title, pubDate, author } = anotherBook;
// console.log(author);

const { id, title, pubDate, author: { firstName, lastName } } = anotherBook;
console.log(author); // 중첩 객체를 바로 추출할 경우, author는 사용 불가

// Array Destructuring : 배열의 요소들을 개별 변수들로 분해.
const date = ['1970', '12', '01'];

// Javascript Array는 순서를 보장받아야 하기 때문에 기존 방식에서는 인덱싱을 하여 분해했음.
// const year = date[0];
// const month = date[1];
// const day = date[2];

// Array Destructuring 방식
const [year, month, day] = date;
console.log(year, month, day);

// 중첩 배열의 destructuring
const nestedArray = [1, 2, [true, 'hoya'], 5];

const [one, two, [isTrue, userName], five] = nestedArray;
console.log(one, two, isTrue, userName, five);

const movie = {
    movieTitle: 'Spiderman no way home',
    movieActor: {
        firstName: 'Tom',
        lastName: 'Holland',
    },
    hashTags: ['honey fun', 'handsome', 'thrill'],
}

const { // destructuring
    movieTitle,
    movieDate = new Date(), // new Date() : default parameter
    movieActor, // 객체만 따로 분해하고 싶을 때
    movieActor: { firstname }, // 내부에서 별도 destructuring
    hashTags: [tag1, tag2],
} = movie;

console.log(movieDate, movieActor, firstName, tag1, tag2);