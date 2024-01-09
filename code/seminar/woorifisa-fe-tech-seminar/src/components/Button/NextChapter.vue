<script setup>
const props = defineProps({
  link: {
    type: Object,
  },
});
</script>
<template>
  <div class="btn-wrap">
    <button v-if="link.before">
      <router-link :to="link.before">Prev Chapter</router-link>
    </button>
    <button>
      <router-link :to="link.next">Next Chapter</router-link>
    </button>
  </div>
</template>

<style scoped>
button {
  display: block;
}
a {
  display: block;
  width: fit-content;
  font-weight: bold;
  margin: 30px 0;
  padding: 20px 10px;
  border-bottom: 2px dashed;
  cursor: pointer;
  color: rgb(23, 42, 214);
  @apply dark:text-[rgba(188,214,23,1)];
}
.btn-wrap {
  display: flex;
  gap: 10px;
}
</style>
