<template>
  <section class="content-wrapper">
    <slot></slot>
  </section>
</template>

<style scoped>
section {
  width: 100%;
  padding: 30px 50px;
  margin-left: 300px;
  border-left: 1px solid #000;
  @apply dark:border-l-[1px] border-white;
}
@media (max-width: 1024px) {
  section {
    margin: 0;
    border: none;
    padding: 120px 30px;
  }
}
</style>
