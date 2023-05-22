<script setup>
import { useOnMobileNav } from '@/stores/isMobileNav.js';
import { useResponsive } from '@/stores/windowSize';

const nav = useOnMobileNav();
const responsive = useResponsive();
const navList = [
  { id: 0, link: '/', title: 'Home' },
  { id: 1, link: '/vanillaJSVue', title: 'Vanilla Javascript vs Vue.js' },
  { id: 2, link: '/webpage-and-frontend', title: '프론트개발의 변화' },
  { id: 3, link: '/vue', title: 'Vue.js에 대하여' },
  { id: 4, link: '/conclusion', title: '결론' },
  // { id: 5, link: '/others', title: '기타사항' },
  { id: 6, link: '/reference', title: '참고문서' },
];
const handleSetNav = () => {
  responsive.isMobile && nav.setNav();
};
</script>
// class="border-r-[1px] border-black dark:border-white"

<template>
  <nav :class="{ active: nav.isMobileNav }">
    <ul>
      <li @click="handleSetNav" v-for="nav in navList" :key="nav.id">
        <router-link :to="nav.link">{{ nav.title }}</router-link>
      </li>
    </ul>
  </nav>
</template>

<style scoped>
nav {
  position: fixed;
  width: fit-content;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  border-radius: 0 20px 20px 0;
}
ul {
  display: flex;
  flex-direction: column;
  padding: 20px;
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
  @apply text-[rgb(213,21,100)] dark:text-[#2cd69d];
}

@media (max-width: 1024px) {
  nav {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border: none;
    background: rgba(255, 255, 255, 0.8);
    z-index: 20;
    justify-content: center;
    align-items: center;
    @apply dark:bg-[rgba(0,0,0,0.8)];
  }
  nav.active {
    display: flex;
  }
  ul {
    padding: 0;
    gap: 5px;
    display: block;
  }
}
</style>
