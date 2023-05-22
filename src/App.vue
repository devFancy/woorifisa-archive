<script setup>
import './assets/index.css';
import Navigation from './components/Navigation.vue';
import HedaerBox from './components/Header.vue';
import FooterBox from './components/Footer.vue';
import ThemeButton from './components/Button/ThemeButton.vue';
import DefaultLayout from './layout/DefaultLayout.vue';
import ContentsLayout from './layout/ContentsLayout.vue';
import { useChangeTheme } from './stores/theme.js';
import { useResponsive } from './stores/windowSize.js';
import { useOnMobileNav } from './stores/isMobileNav.js';

const themeStore = useChangeTheme();
const responsive = useResponsive();
const nav = useOnMobileNav();

window.addEventListener('resize', () => {
  if (window.innerWidth <= 1024) {
    responsive.setMobile();
  } else {
    responsive.setPc();
    if (nav.isMobileNav) {
      nav.setNav();
    }
  }
});
window.innerWidth <= 1024 ? responsive.setMobile() : responsive.setPc();
</script>

<template>
  <main :class="themeStore.isDark ? 'dark' : 'light'">
    <section>
      <HedaerBox />
      <DefaultLayout>
        <Navigation />
        <ContentsLayout>
          <RouterView />
        </ContentsLayout>
      </DefaultLayout>
      <ThemeButton />
      <FooterBox />
    </section>
  </main>
</template>

<style scoped>
section {
  @apply bg-white text-black dark:bg-[#2f2f2f] dark:text-white;
}
</style>
