import { describe, expect, test } from "vitest";
import { validateStringIsNotEmpty } from "./validation";

// 공백값 검증 함수의 동작 테스트
describe('validateStringIsNotEmpty()', () => {
    test('길이가 1 또는 2 이상인 빈 문자열이 전달될 경우 에러가 발생한다.', () => {
        const input = '';

        const validateFn = () => validateStringIsNotEmpty(input);

        expect(validateFn).toThrow();
    });

    test('에러가 발생된 경우 (공백은 입력할 수 없습니다.) 라는 사유를 출력한다.', () => {
        const input = '';

        expect(() => validateStringIsNotEmpty(input)).toThrow(/공백은 입력할 수 없습니다./);
    });

    test('문자열 외 다른 타입의 값이 전달될 경우 에러가 발생한다.', () => {
        const inputNum = 1;
        const inputBool = false;
        const inputObj = {};

        const validationFnNum = () => validateStringIsNotEmpty(inputNum);
        const validationFnBool = () => validateStringIsNotEmpty(inputBool);
        const validationFnObj = () => validateStringIsNotEmpty(inputObj);

        expect(validationFnNum).toThrow();
        expect(validationFnBool).toThrow();
        expect(validationFnObj).toThrow();
    });

    test('일반 문자열이 전달될 경우 에러가 발생하지 않는다.', () => {
        const input = '유효한 문자열';

        const validationFn = () => validateStringIsNotEmpty(input);

        expect(validationFn).not.toThrow();
    });
});

