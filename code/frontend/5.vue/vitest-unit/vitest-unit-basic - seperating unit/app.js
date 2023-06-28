import { add } from "./src/calculator.js";
import { validateNumber, validateStringIsNotEmpty } from "./src/validation.js";

const form = document.getElementById('form');
const output = document.getElementById('result');

const formSubmitHandler = (event) => {
    event.preventDefault();

    const formData = new FormData(form);

    const firstNumber = formData.get('firstNumber');    
    const secondNumber = formData.get('secondNumber');
    
    const numbers = [];
    numbers.push(firstNumber);
    numbers.push(secondNumber);

    // 입력값 검증
    // #2. validation 코드 추가
    let result = ''
    try {
        const validatedNumbers = [];

        for (const number of numbers) {
            // 공백값 검증
            validateStringIsNotEmpty(number);
            
            // 유효한 숫자인지 검증
            const validNumber = validateNumber(number);
            validatedNumbers.push(validNumber);
        }
        // 덧셈 로직
        result = add(validatedNumbers);
    } catch (error) {
        result = error.message;
    }


    output.textContent = result;
    
}

form.addEventListener('submit', formSubmitHandler);