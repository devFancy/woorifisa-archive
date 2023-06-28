// 2. 이벤트 핸들러 프로퍼티 방식
const evPropButton = document.getElementById('btn-ev-prop');
console.dir(evPropButton);

// 클릭 이벤트 발생 시 동작시킬 함수
const eventHandler = () => console.log('button clicked!!!');

// onclick 프로퍼티에 eventHandler 함수를 값으로 할당
evPropButton.onclick = eventHandler;

// 3. addEventListener 방식
const addEvLsnrButton = document.getElementById('btn-add-ev-lsnr');

// addEventListener(이벤트 타입, 콜백함수);
addEvLsnrButton.addEventListener('click', buttonHandler);

function buttonHandler() { // 화살표 함수로 변경
    console.log('button clicked~~~');
}

// 이벤트 제거하는 방법(직접 공부해보기), 이벤트 전파, 버블링