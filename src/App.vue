<script setup>
import './assets/common.css';
import Navigation from './components/Navigation.vue';
import HedaerBox from './components/HeaderBox.vue';
import FooterBox from './components/FooterBox.vue';
import DefaultLayout from './layout/DefaultLayout.vue';
import ContentsLayout from './layout/ContentsLayout.vue';
</script>

<template>
  <HedaerBox />
  <DefaultLayout>
    <Navigation />
    <ContentsLayout>
      <RouterView />
    </ContentsLayout>
  </DefaultLayout>
  <FooterBox />
</template>
