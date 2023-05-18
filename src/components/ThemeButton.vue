<script setup>
import { useChangeTheme } from '../stores/theme.js';
const themeStore = useChangeTheme();
const handleChnageTheme = () => {
  themeStore.handleChangetheme();
};
</script>

<template>
  <button class="bg-[#212A3E] dark:bg-[#394867]" @click="handleChnageTheme">
    {{ themeStore.isDark ? '☀️' : '🌙' }}
  </button>
</template>

<style scoped>
button {
  position: fixed;
  bottom: 30px;
  right: 20px;
  width: 50px;
  border: none;
  aspect-ratio: 1 / 1;
  border-radius: 50%;
  font-size: 20px;
  cursor: pointer;
}
</style>
