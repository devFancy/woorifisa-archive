import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useResponsive = defineStore('responsive', () => {
  const isMobile = ref(false);
 
  const setMobile = () => {
    isMobile.value = true;
  };
  const setPc = () => {
    isMobile.value = false;
  };
  return { isMobile, setMobile,setPc };
});
