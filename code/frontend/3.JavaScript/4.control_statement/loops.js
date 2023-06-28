// 기본(Java에서 동일)
for (let index = 1; index < 5; index++) {
    console.log(`${index} 번 반복`);
}

const rainbow = 'rainbow';
for (let i = 0; i < 7; i++) {
    console.log(rainbow[i]);
}

// 중급
const foods = ['apple', 'orange-cookie', 'avocado', 'plum'];
let favorite = '내가 좋아하는 음식은..'
// index < 4; -> 4부분, foods.length === 4
for (let index = 0; index < 4; index++) {
    // index가 3일 때, plum을 가리킴
    if (index === foods.length -1) {
        favorite += '그리고 ' + foods[index];
    } else {
        favorite += foods[index] + ', ';
    }
}
console.log(favorite);
// 1. 내가 좋아하는 음식은.. apple, orange-cookie, avocado, plum
// 2. 내가 좋아하는 음식은.. apple, orange-cookie, avocado 
// 그리고 plum

// Array -> foods와 같은 배열 객체를 의미함
// Array.prototype.forEach(callback)

const fruits = ['apple', 'banana', 'coconut'];
// Array
   fruits.forEach((fruit) => console.log(fruit));

// for-in, for-of