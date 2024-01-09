<script setup>
const props = defineProps({
  title: {
    type: String,
  },
  mt: {
    type: String,
  },
});
</script>

<template>
  <h3 :class="mt" class="before:bg-slate-600 dark:before:bg-[#2cd69d6a]">
    {{ title }}
  </h3>
</template>

<style scoped>
h3 {
  width: fit-content;
  padding: 20px 0;
  font-size: 25px;
  position: relative;
  margin-bottom: 20px;
}
h3::before {
  content: '';
  display: block;
  width: 50px;
  position: absolute;
  height: 5px;
  bottom: 10px;
  left: -10px;
}
h3.mt {
  margin-top: 50px;
}
</style>
