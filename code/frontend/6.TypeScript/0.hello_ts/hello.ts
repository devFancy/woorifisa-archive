function greet(person : String, date : Date) {
    console.log(`Hello ${person} today is ${date.toDateString()}`);
}

greet('Brendan', new Date()); // 잘못된 인자 개수 전달 시, 에러 발생