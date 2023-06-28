
// add라는 이름의 덧셈 함수 작성 후 app.js에 export

/**
 * numbers 배열 내 요소의 합을 구하여 반환
 * 
 * @param { Array } numbers - 덧셈 연산에 사용될 값들
 * @returns { number } sum - 덧셈 결과
 */

export const add = (numbers) => {
    let sum = 0;

    for (const number of numbers) {
        sum += +number;
    }

    return sum;
}