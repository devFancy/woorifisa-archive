// 1. 선택박스(Select box)와, "결과:" 부분에 해당하는 HTML Tag들을 JS코드로 불러온다.
const selectButton = document.querySelector('select');
console.log(selectButton);
const paragraph = document.querySelector('p');
console.log(paragraph);


// 2. 선택박스에게 "너가 가지고 있는 선택지 중에 하나가 선택되면, 나한테 말좀 해줘"
selectButton.addEventListener('change', setResult);

// 3. 선택박스가 말해주면, 그때 조건에 따라 수행을 할 수 있도록 선택박스에게 미션을 전달
function setResult() {
    const choice = selectButton.value; // 선택박스에서 사용자가 선택한 값
    console.log(choice);
    if (choice === 'one') {
        // 쿠키를 하나만 먹었을 때
        paragraph.textContent = '하늘에서 천사가 내려와 쿠키를 한 박스 주고 갔다.';
    } else if (choice === 'two') {
        // 쿠키를 두개 다 먹어버렸을 때
        paragraph.textContent = '이 과자쪼가리가 뭐라고.. 엄마한테 혼났다..';
    } else { // 그 외 나머지
        // 마법의 소라고동에게 물어봤을 때
        paragraph.textContent = '안 돼';
    }
}

// 미션: 결과: 부분에 원하는 텍스트 출력하도록
