<template>
  <button @click="clickHandler">전환</button>
  <button @click="awesome = !awesome">한줄로 전환</button>
  
  <h1 v-if="awesome">Vue is awesome! 😀</h1>
  <h1 v-else>isn't? 😢</h1>
</template>

<script setup>
import { ref } from 'vue';

const awesome = ref(true); // 내부적으로 { value: true }로 래핑됨

const clickHandler = () => awesome.value = !awesome.value;

</script>

<style scoped>
  button {
    letter-spacing: 0.1rem;
    margin: 0.75rem;
    padding: 0.75rem 1.25rem;
    text-transform: uppercase;
    background: transparent;
    color: black;
    display: inline-block;
    border: 2px dashed black;
    font-size: 1rem;
    font-weight: 700;
  }
</style>