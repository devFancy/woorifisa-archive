
// test(테스트 이름, 실제 테스트 코드를 작성할 콜백함수)
// 별칭(alias)으로 it 사용 가능
// https://vitest.dev/api/#test

import { describe, expect, test } from "vitest";
import { add } from "./calculator";

test('add()에 인수가 전달되지 않을 경우, 예외(에러)를 던진다.', () => {
    const resultFn = () => {
        add();
    }
    // exepect(add()).toThrow(); // 진짜 예외가 발생해버려서 테스트 실패
    expect(resultFn).toThrow(); // 실제로 예외를 던지는지 테스트
    
    // expect(add).toThrow();
});