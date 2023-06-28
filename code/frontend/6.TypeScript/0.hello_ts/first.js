// const message = 'Hello World!';

// const lower = message.toLowerCase();
// console.log(lower);

// message(); // 에러 발생

/*
    컴파일 시점 : 코드를 실행하기 전에 미리 -> TypeScript

    런타임 시점 : 코드 실행과정에서 -> 비행기 뜨고나서 확인하는 꼴

    
    * TypeScript
    -> 새로운 프로그래밍 언어는 아니고,
       JS의 슈퍼셋(=SuperSet)
       JS에 Type을 씌웠다.
*/

const message = () => console.log('Hello World!');
console.log(typeof message);
if(typeof message === 'function') {
    message();
}

const printLength = value => {
    console.log(`이 문자열의 길이는 ${value.length}`);
}

printLength('안녕하세요');
printLength(5); // undefined , 함수를 호출할 때부터 정확한 타입을 전달하는 방법 ? => TypeScript

