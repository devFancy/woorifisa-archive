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
  <h3 :class="mt">{{ title }}</h3>
</template>

<style scoped>
h3 {
  width: fit-content;
  padding: 20px 0;
  font-size: 25px;
  position: relative;
  margin-bottom: 20px;
  text-shadow: 3px 0px 1px #1b8c66;
}
h3::before {
  content: '';
  display: block;
  width: 50px;
  position: absolute;
  height: 5px;
  background: #2cd69d6a;
  bottom: 10px;
  left: -10px;
}
h3.mt {
  margin-top: 50px;
}
</style>
