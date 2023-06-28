// dark mode 토글 버튼
const checkbox = document.getElementById('checkbox');

// dark mode를 적용하기 위해 태그를 가져오고, <html>에 class="dark"를 적용해야함
const html = document.querySelector('html'); 

const toggleDarkmode = () => checkbox.checked 
? html.classList.add('dark') : html.classList.remove('dark');

checkbox.addEventListener('click', toggleDarkmode);