<script setup>
import './assets/index.css';
import Navigation from './components/Navigation.vue';
import HedaerBox from './components/HeaderBox.vue';
import FooterBox from './components/FooterBox.vue';
import ThemeButton from './components/ThemeButton.vue';
import DefaultLayout from './layout/DefaultLayout.vue';
import ContentsLayout from './layout/ContentsLayout.vue';
import { useChangeTheme } from './stores/theme.js';
const themeStore = useChangeTheme();
</script>

<template>
  <div :class="themeStore.isDark ? 'dark' : 'light'">
    <main class="bg-white text-black dark:bg-[#2f2f2f] dark:text-white">
      <HedaerBox />
      <DefaultLayout>
        <Navigation />
        <ContentsLayout>
          <RouterView />
        </ContentsLayout>
      </DefaultLayout>
      <ThemeButton />
      <FooterBox />
    </main>
  </div>
</template>

<style scoped></style>
