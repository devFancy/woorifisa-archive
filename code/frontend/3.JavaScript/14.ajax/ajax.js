// 1. XMLHttpRequest() 인스턴스(객체) 생성
const xhr = new XMLHttpRequest();

// 2. 서버로부터의 응답이 완료되었는지 확인
xhr.onload = () => {
    if (xhr.readyState === xhr.DONE && xhr.status === 200) {
        // responseText: 서버로부터 받은 응답 데이터
        const responseData = xhr.responseText;
        const result = JSON.parse(responseData);
        console.log(result);
    }
}

// 3. 요청 준비하는 코드(open())
const url = 'https://jsonplaceholder.typicode.com/users/1';
xhr.open('GET', url);

// 4. 요청 실제 전송
xhr.send();