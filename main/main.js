// 팝업창
// 동작: 코인 슬롯 머신의 버튼을 누르면 코인 슬롯 머신의 내용이 2개 이상 같을 경우 팝업창이 뜬다.

// 변수 선언
const coinSlotMachineContent = document.getElementsByClassName(
"coin-slot-machine-innerbox-content" //aaa
); //코인 슬롯 머신의 내용
const coinSlotMachineContainer = document.getElementById("coinSlotMachineButtonContainer"); //코인 슬롯 머신의 버튼 컨테이너
const coinSlotMachineTop = document.getElementById("top");//코인 슬롯 머신의 버튼

// 팝업창을 띄우는 기능을 하는 함수
const openPopup = () => {
    const url = "../popup/popup.html";// 팝업으로 띄울 경로
    const name = "popup content";//팝업 창의 이름
    const w = 700;// 팝업 창의 원하는 너비
    const h = 700;// 팝업 창의 원하는 높이
    const left = screen.width / 2 - w / 2;// 팝업창의 원하는 위치 (왼쪽으로부터 얼만큼 떨어질지)
    const top = screen.height / 2 - h / 2;// 팝업창의 원하는 위치 (위쪽으로부터 얼만큼 떨어질지)
    const option = `width=${w},height=${h},top=${top},left=${left}`; // 옵션 객체 생성

    window.open(url, name, option); // window 함수에 적용
};

// 이벤트 핸들러
// 슬롯 머신 버튼이 클릭되는 경우를 기다리는 중
coinSlotMachineContainer.addEventListener("click", () => {
    // 버튼이 눌리면 스타일 적용 변화 (레버가 기울어짐)
    coinSlotMachineTop.style.transform = 'rotate(40deg)';

    // 슬롯 머신 내용이 2개 이상 같은 경우 팝업창 띄우는 함수 실행
    if (
        coinSlotMachineContent[0].textContent ===
        coinSlotMachineContent[1].textContent
        ||
        coinSlotMachineContent[1].textContent ===
        coinSlotMachineContent[2].textContent
        ||
        coinSlotMachineContent[0].textContent ===
        coinSlotMachineContent[2].textContent

    ) {

        openPopup();
    }
    // 일정 시간 이후 스타일 적용을 원래로 복귀
    setTimeout(()=>{coinSlotMachineTop.style.transform = 'rotate(0deg)';}, "1000")
});
