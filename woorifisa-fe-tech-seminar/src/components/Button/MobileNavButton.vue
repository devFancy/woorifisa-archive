<script setup>
import { useOnMobileNav } from '@/stores/isMobileNav.js';
const nav = useOnMobileNav();

const handleSetNav = () => {
  nav.setNav();
};
</script>
<template>
  <div class="btn-wrapper" @click="handleSetNav">
    <div class="ham" :class="nav.isMobileNav ? 'active' : ''">
      <span class="bar"></span>
    </div>
  </div>
</template>
<style scoped>
.btn-wrapper {
  display: none;
  width: 25px;
  height: 25px;
  position: relative;
}
.ham {
  position: absolute;
  width: 25px;
  height: 25px;
  cursor: pointer;
  top: 0;
  left: 0;
  border-radius: 3px;
}

.ham .bar {
  display: block;
  width: 0px;
  height: 3px;
  border-radius: 3px;
  background-color: #000;
  margin-top: 11px;
  position: relative;
  @apply dark:bg-white;
}
.ham .bar:before {
  content: '';
  width: 25px;
  height: 3px;
  border-radius: 3px;
  background-color: #000;
  position: absolute;
  left: 2px;
  bottom: 0;
  transition: transform 0.3s;
  @apply dark:bg-white;
}
.ham .bar:after {
  content: '';
  width: 25px;
  height: 3px;
  border-radius: 3px;
  background-color: #000;
  position: absolute;
  left: 2px;
  bottom: 0;
  transition: transform 0.3s;
  @apply dark:bg-white;
}

.ham.active span:before {
  transform: rotate(45deg);
  transition: transform 0.3s 0.5s;
}

.ham.active span:after {
  transform: rotate(-45deg);
  transition: transform 0.3s 0.5s;
}

.ham:before {
  content: '';
  width: 25px;
  height: 3px;
  background-color: #000;
  border-radius: 3px;
  position: absolute;
  right: -2px;
  top: 0px;
  transition: width 0.3s;
  @apply dark:bg-white;
}
.ham:after {
  content: '';
  width: 25px;
  height: 3px;
  background-color: #000;
  border-radius: 3px;
  position: absolute;
  bottom: 0px;
  left: 2px;
  transition: width 0.3s;
  @apply dark:bg-white;
}

.ham.active:before {
  width: 0;
  right: -2px;
  top: 0px;
}
.ham.active:after {
  width: 0;
  left: 0px;
  bottom: 0px;
}
@media (max-width: 1024px) {
  .btn-wrapper {
    display: block;
  }
  .ham.active {
    position: fixed;
    z-index: 50;
    left: auto;
    right: 20px;
    top: 35px;
  }
}
</style>
