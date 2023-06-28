// ~~~.config.js(ts) -> 각 라이브러리별 설정을 구성할 수 있는 파일명

export default {
    content: [
      "./public/index.html",
    ],
    darkMode: 'class',
    theme: {
      extend: {
        fontFamily: {
          nanum: ['Nanum Gothic']
        }
      }
    }
  }