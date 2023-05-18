<script setup>
const navList = [
  { id: 1, link: '/', title: 'Vanilla Javascript vs Vue.js' },
  { id: 2, link: '/spampa', title: 'MPA & SPA' },
  { id: 3, link: '/aboutVue', title: 'About Vue.js' },
  { id: 4, link: '/conclusion', title: 'Conclusion' },
  { id: 5, link: '/reference', title: 'Reference Link' },
];
</script>
<template>
  <nav>
    <ul>
      <li v-for="nav in navList" :key="nav.id">
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
  border-right: 1px solid #fff;
  /*border-right: 1px solid #2f2f2f;*/
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
  color: #2cd69d;
}
</style>
