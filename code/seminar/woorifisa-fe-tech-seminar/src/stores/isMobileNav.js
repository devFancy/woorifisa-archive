import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useOnMobileNav = defineStore('mobileNav', () => {
  const isMobileNav = ref(false);
  const setNav = () => {
    isMobileNav.value = !isMobileNav.value;
  };

  return { isMobileNav, setNav };
});
