import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useChangeTheme = defineStore('isDark', () => {
  const isDark = ref(true);
  const handleChangetheme = () => {
    isDark.value = !isDark.value;
  };
  return { isDark, handleChangetheme };
});
