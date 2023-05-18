<script setup>
const props = defineProps({
  title: {
    type: String,
    default: '',
  },
  targetLink: {
    type: String,
    default: '',
  },
  gitLink: {
    type: String,
    default: '',
  },
});
</script>
<template>
  <div>
    <h3>{{ title }}</h3>
    <div class="btn-box">
      <a class="link-btn targetlink" :href="targetLink" alt="targetLink" target="_blank">Link</a>
      <a class="link-btn gitlink" :href="gitLink" alt="gitLink" target="_blank">Git Source</a>
    </div>
  </div>
</template>
<style scoped>
h3 {
  width: fit-content;
  font-size: 25px;
  margin-bottom: 20px;
  padding: 10px 0;
}
.btn-box {
  display: flex;
  gap: 20px;
}
.link-btn {
  padding: 10px;
  display: inline-block;
  border: 1px solid #fff;
  border-radius: 10px;
  transition: all 0.5s;
}

.link-btn:hover {
  background: #2cd69d;
  border: 1px solid #2cd69d;
}
</style>
