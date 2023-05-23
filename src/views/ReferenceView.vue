<script setup>
const linkList = [
  {
    title: 'Vue.js 공식문서(v3-docs, kr)',
    link: 'https://v3-docs.vuejs-korea.org/',
  },
  {
    title: 'Vue.js란 무엇입니까?',
    link: 'https://appmaster.io/ko/blog/vuejsneun-mueosibnigga',
  },
  {
    title: 'Vue.js 라우터 해시 모드, 히스토리 모드',
    link: 'https://router.vuejs.org/guide/essentials/history-mode.html',
  },
  {
    title: 'vue 반응형 데이터 심화',
    link: 'https://ko.vuejs.org/guide/extras/reactivity-in-depth.html',
  },
  {
    title: 'Node.js connect-history-fallback API',
    link: 'https://www.npmjs.com/package/connect-history-api-fallback',
  },
  {
    title: '라이브러리와 프레임워크 차이점',
    link: 'https://www.youtube.com/watch?v=t9ccIykXTCM&t=17s',
  },
  {
    title: 'Software architecture',
    link: 'https://en.wikipedia.org/wiki/Software_architecture',
  },
  {
    title: 'Software design pattern',
    link: 'https://en.wikipedia.org/wiki/Software_design_pattern',
  },
  {
    title: 'Software Design Patterns',
    link: 'https://www.youtube.com/watch?v=IGl2FaVLMFQ&ab_channel=CloudAcademy-AllinOne',
  },
  {
    title: '프론트엔드에서 MV* 아키텍처란 무엇인가요?',
    link: 'https://velog.io/@teo/프론트엔드에서-MV-아키텍쳐란-무엇인가요',
  },
  {
    title: '프레임워크 없이 만드는 SSR',
    link: 'https://junilhwang.github.io/TIL/Javascript/Design/Vanilla-JS-Server-Side-Rendering/#_3-mvvm-pattern',
  },
];
</script>
<template>
  <div class="wrapper">
    <ul>
      <li v-for="(list, idx) in linkList" :key="idx">
        <font-awesome-icon icon="fa-solid fa-link" />
        <a :href="list.link" target="_black">{{ list.title }}</a>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.wrapper {
  height: 100vh;
}
li + li {
  margin-top: 10px;
}
a {
  margin-left: 10px;
  transition: all 0.5s;
  font-size: 17px;
}
a:hover {
  color: #2cd69d;
}
</style>
