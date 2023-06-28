let count = 0;

const countValue = document.getElementById('value');
const countButtons = document.querySelectorAll('button');
// Selector

// console.log(countValue);
// console.log(countButtons);

countButtons.forEach((button) => { // Pass the callback fn
    button.addEventListener('click', (event) => {
        const curTarget = event.currentTarget;
        // console.dir(curTarget); // classList 확인

        const styles = curTarget.classList[1];
        // console.log(styles);

        // nested ternary operator
        count = styles !== 'reset' ? (count = styles === 'decrease' ? --count : ++count) : 0;

        // change a countValue color
        let cvColor = '';
        
        cvColor = count !== 0 ? (cvColor = count > 0 ? 'green' : 'red') : 'grey';
        
        countValue.textContent = count;
        countValue.style.color = cvColor;
    })
})