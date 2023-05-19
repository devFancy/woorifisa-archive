<script setup>
const navList = [
  { id: 1, link: '/', title: 'Vanilla Javascript vs Vue.js' },
  { id: 2, link: '/webpage-and-frontend', title: '웹 페이지 개발과 프론트 개발' },
  { id: 3, link: '/vue', title: 'Vue.js에 대하여' },
  { id: 4, link: '/conclusion', title: '결론' },
  { id: 5, link: '/others', title: '기타사항' },
  { id: 6, link: '/reference', title: '참고문서'},
];
</script>
<template>
  <nav class="border-r-[1px] border-black dark:border-white">
    <ul>
      <li v-for="nav in navList" :key="nav.id" class="{}">
        <router-link :to="nav.link">{{ nav.title }}</router-link>
      </li>
    </ul>
  </nav>
</template>

<style scoped>
nav {
  width: fit-content;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
ul {
  display: flex;
  flex-direction: column;
  padding: 50px 20px;
  gap: 30px;
}
li {
  width: 100%;
}
li a {
  display: inline-block;
  font-size: 20px;
  padding: 20px 0;
  font-weight: 600;
}
.router-link-active {
  @apply text-green-900 dark:text-[#2cd69d];
}
</style>
