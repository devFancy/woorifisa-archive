<script setup>
const props = defineProps({
  src: {
    type: String,
  },
});
const getImageUrl = () => {
  return new URL(`../../assets/images/${props.src}`, import.meta.url).href;
};
</script>
<template>
  <img :src="getImageUrl()" />
</template>

<style scoped>
img {
  width: 60%;
  margin: 20px auto;
}
@media (max-width: 1024px) {
  img {
    width: 100%;
  }
}
</style>
