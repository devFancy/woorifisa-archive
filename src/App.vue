<script setup>
import './assets/common.css';
import Navigation from './components/Navigation.vue';
import FooterBox from './components/FooterBox.vue';
import DefaultLayout from './layout/DefaultLayout.vue';
import ContentsLayout from './layout/ContentsLayout.vue';
</script>

<template>
  <h1>Why we use <span>Vue.js</span></h1>
  <DefaultLayout>
    <Navigation />
    <ContentsLayout>
      <RouterView />
    </ContentsLayout>
  </DefaultLayout>
  <FooterBox />
</template>

<style scoped>
h1 {
  color: #f6ffde;
  padding: 20px;
  border-bottom: 1px solid #fff;
}
h1 span {
  color: #2cd69d;
}
</style>
