// test(테스트 이름, 실제 테스트 코드를 작성할 콜백함수)
// 별칭(alias)으로 it 사용 가능

import { describe, expect, test } from "vitest";
import {add} from "./calculator.js"

// 테스트 케이스
test.skip('배열 내 모든 숫자 요소들의 합을 구해야 한다.', () => {
    const result = add([1, 2, 3]);
    expect(result).toBe(6); // 결과가 6이어야됨

    expect(result).not.toBe(4); // 결과가 4면 안됨
});

// AAA패턴 적용
test.skip('AAA 패턴, 배열 내 모든 숫자 요소들의 합을 구해야 한다.', () => {
    // Arrange - 테스트를 수행하기 위한 의존성 준비하는 부분(Given)
    const numbers = [1, 2, 3]; // add()에 전달할 dummy 값
    // Act - 테스트 할 동작을 수행하는 부분(When)
    const result = add(numbers);
    const sum = numbers.reduce((acc, curr) => acc + curr);
    // Assert - 실제 테스트 단정문을 작성하는 부분(Then)
    expect(result).toBe(sum);
});

// 테스트 스위트, 비슷한 테스트 관심사끼리 묶어두기
describe.skip('유효하지 않은 입력값', () => {
    test('1. 하나라도 공백 값이 전달 될 경우, NaN을 반환한다', () => {
        const numbers = [1, ''];
        const result = add(numbers);

        expect(result).toBeNaN();
    });
    
    test('2. 문자열로 작성된 숫자값이 전달되어도 연산 결과를 반환한다.', () => {
        const numbers = ['1', '2'];
        const result = add(numbers);
        const sum = numbers.reduce((acc, curr) => Number(acc) + Number(curr));
        // Assert - 실제 테스트 단정문을 작성하는 부분(Then)
        expect(result).toBe(sum);
    });

    test('3. 하나라도 숫자가 아닌 값이 전달될 경우, NaN을 반환한다.', () => {
        const numbers = ['invalid', 1];
        const result = add(numbers);

        expect(result).toBeNaN();
    });

    test('4.  빈 배열이 전달될 경우 0을 반환한다.', () => {
        const numbers = [];
        const result = add(numbers);
        // Assert - 실제 테스트 단정문을 작성하는 부분(Then)
        expect(result).toBe(0);
    });
});

// todo(), 나중에 테스트할 케이스
test.todo('두 수로 0이 전달되면 0을 출력한다.');

test('add()에 인수가 전달되지 않을 경우, 예외(에러)를 던진다.', () => {
    const resultFn = () => {add();}
    // expect(add()).toThrow(); // 진짜 예외가 발생해버림 -> 테스트 실패
    expect(resultFn).toThrow(); // 실제로 예외를 던지는지 테스트
});