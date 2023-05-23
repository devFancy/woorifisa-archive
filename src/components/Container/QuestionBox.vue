<script setup>
const props = defineProps({
  title: {
    type: String,
    default: '',
  },
  answers: {
    type: Array,
  },
});
</script>
<template>
  <details>
    <summary>Q1. {{ title }}</summary>
    <ul>
      <li v-for="(answer, idx) in answers" :key="idx">{{ answer }}</li>
    </ul>
  </details>
</template>

<style scoped>
details summary {
  font-size: 20px;
  transition: all 0.5s;
}

details[open] summary {
  color: #2cd69d;
}

ul {
  padding-left: 20px;
  padding-top: 20px;
  display: flex;
  flex-direction: column;
  gap: 10px;
}
</style>
