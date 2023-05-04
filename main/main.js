// 팝업창
const coinSlotMachineContent = document.getElementsByClassName(
"coin-slot-machine-innerbox-content" //aaa
);
const coinSlotMachineContainer = document.getElementById("coinSlotMachineButtonContainer");
const coinSlotMachineTop = document.getElementById("top");
const coinSlotMachineBall = document.getElementById("ball");
const coinSlotMachineBottom = document.getElementById("bottom");


const openPopup = () => {
    const url = "../popup/popup.html";
    const name = "popup content";
    const w = 700;
    const h = 700;
    const left = screen.width / 2 - w / 2;
    const top = screen.height / 2 - h / 2;
    const option = `width=${w},height=${h},top=${top},left=${left}`;
    
    window.open(url, name, option);
};

coinSlotMachineContainer.addEventListener("click", () => {
    coinSlotMachineTop.style.transform = 'rotate(40deg)';

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
    setTimeout(()=>{coinSlotMachineTop.style.transform = 'rotate(0deg)';}, "1000")
});



