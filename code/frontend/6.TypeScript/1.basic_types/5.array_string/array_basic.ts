const elements = [true, null, undefined, 42]; // 기존 JS에서는 모든 타입의 값들을 배열의 요소로 저장 가능
// 타입 시스템이 요소로 담긴 값들의 타입을 가지고 해당 배열의 타입을 추론 (number | boolean | null | undefined)[]

// 초기 배열에 string타입만 받을 수 있도록 제한
const foods: string[] = ['orange', 'cookie', 'orange-cookie'];

// foods.push(5); 

// 유니언 타입을 활용한 숫자와 문자열을 받을 수 있는 배열 생성
const stringOrNumbers: (string | number)[] = [1, 2, '문자열'];