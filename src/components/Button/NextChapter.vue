<script setup>
const props = defineProps({
  link: {
    type: Object,
  },
});
</script>
<template>
  <button>
    <router-link :to="link.url">Next Chapter: {{ link.title }}</router-link>
  </button>
</template>

<style scoped>
button {
  display: block;
}
a {
  display: block;
  font-weight: bold;
  margin: 30px 0;
  padding: 20px 10px;
  border-bottom: 2px dashed;
  cursor: pointer;
  color: rgb(23, 42, 214);
  @apply dark:text-[rgba(188,214,23,1)];
}
</style>
