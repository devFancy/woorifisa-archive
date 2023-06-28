// #1. 코드 분리
// 공백값 검증 함수
export const validateStringIsNotEmpty = (value) => {
    if(value.trim().length === 0) throw new Error('공백은 입력할 수 없습니다.');
}

// 숫자값 유효성 검증 함수, 전달받은 값이 숫자 값인지 검증
export const validateNumber = (number) => {
    // 전달받은 number가 'a'일 경우 +number가 불가능
    if (typeof number === 'number' || (typeof number === 'string' && !isNaN(number))) {
        return +number;
    }
}