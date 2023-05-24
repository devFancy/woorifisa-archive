<script setup>
const props = defineProps({
  mt: Boolean,
  mb: Boolean,
});
</script>

<template>
  <p :class="{ mt, mb }" class="text-content">
    <slot></slot>
  </p>
</template>
<style>
.text-content {
  width: 80%;
  line-height: 1.5;
  font-size: 18px;
  text-align: justify;
  word-break: break-all;
}
.text-content.mt {
  margin-top: 20px;
}
.text-content.mb {
  margin-bottom: 20px;
}
.text-content span {
  color: #d41564;
}

@media (max-width: 1024px) {
  .text-content {
    width: 100%;
  }
}
</style>
