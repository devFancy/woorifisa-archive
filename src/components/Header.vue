<script setup>
import MobileNavButton from './Button/MobileNavButton.vue';
import whiteLogo from '@/assets/images/logo-white.png';
import blackLogo from '@/assets/images/logo-black.png';
import { useChangeTheme } from '@/stores/theme';

const theme = useChangeTheme();
</script>

<template>
  <header class="border-b-[1px] border-black dark:border-white">
    <router-link to="/">
      <img
        :src="theme.isDark ? whiteLogo : blackLogo"
        alt="logo"
        class="img-logo"
      />
    </router-link>
    <h1 class="text-black dark:text-white">
      Why we use <span class="text-green-700 dark:text-vueGreen">Vue.js</span>
    </h1>
    <MobileNavButton />
  </header>
</template>

<style scoped>
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
  width: 100%;
}

.img-logo {
  width: 4rem;
  height: 4rem;
}

h1 {
  flex: 1;
  text-align: center;
  font-weight: 700;
  font-size: 40px;
  text-shadow: rgba(0, 0, 0, 0.25) 5px 5px 10px;
  justify-self: center;
}

a {
  display: flex;
  flex-direction: column;
  gap: 5px;
}
a span {
  width: 100%;
  text-align: center;
  font-size: smaller;
}

#pdf-id {
  font-weight: 500;
  font-size: 15px;
}

@media (max-width: 1024px) {
  h1 {
    display: none;
  }
}
</style>
