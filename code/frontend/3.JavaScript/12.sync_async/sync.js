// 1. 함수가 호출된 순서대로 순차적으로 실행됨. - 동기(Sync) 방식
const firstFunc = () => {
    console.log('첫 번째 함수 호출됨.');
};

const someLongWork = () => {
    console.log('-------------');
    console.log('특정 작업 처리 중.. 시간이 오래 걸림.');
    console.log('-------------');
}

const secondFunc = () => {
    console.log('두 번째 함수 호출됨.');
};

firstFunc();
someLongWork();
secondFunc();

/**
 * 동기 방식
 * 한 번에 하나의 작업만 처리하기 때문에 특정 작업 (someLongWork())이 길어질 경우,
 * 그 뒤의 작업(secondFun())은 blocking됨(작업 수행 불가)
 * 
   장점: 코드를 읽기가 쉽다.
 */
