const button = document.getElementById('btn');
const color = document.getElementById('color');

button.addEventListener('click', () => {
    // 배열 디스트럭쳐링(Destructuring) - 구조 분해 할당(Assigment)
    const [r, g, b] = getRandomNumber(0, 255);
    
    const rgbColor = `rgb(${r}, ${g}, ${b})`;
    document.body.style.backgroundColor = rgbColor;
    color.style.color = rgbColor;
    color.textContent = rgbColor;
});


// 랜덤값 추출
function getRandomNumber(min, max) {
    const randomRGBArray = [];

    for (let i = 0; i < 3; i++) {
        const randomNumber = Math.floor(Math.random() * ( max - min + 1)) + min;
        randomRGBArray.push(randomNumber);
    }

    return randomRGBArray;
}