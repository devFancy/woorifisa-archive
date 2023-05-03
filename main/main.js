const coinSlotMachineContent = document.getElementsByClassName(
    "coin_slot_machine_innerbox_content"
);
const coinSlotMachineButtonContent = document.getElementById(
"coin_slot_machine_button_content"
);

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

coinSlotMachineButtonContent.addEventListener("click", () => {
if (
    coinSlotMachineContent[0].textContent ===
    coinSlotMachineContent[1].textContent &&
    coinSlotMachineContent[1].textContent ===
    coinSlotMachineContent[2].textContent
) {
    openPopup();
}
});
  