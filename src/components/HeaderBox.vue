<script setup></script>

<template>
  <header class="border-b-[1px] border-black dark:border-white">
    <h1 class="text-black dark:text-white">
      Why we use <span class="text-green-700 dark:text-vueGreen">Vue.js</span>
    </h1>
    <a
      href="https://github.com/Jiyun-Parkk/woorifisa-fe-tech-seminar/blob/master/why_we_learn_vue.js.pdf?raw=True"
      download="why_we_learn_vue.js.pdf"
    >
      <span> 📁 </span>
      <span>PDF DOWN</span>
    </a>
  </header>
</template>

<style scoped>
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
}
h1 {
  font-size: 25px;
}

a {
  display: flex;
  flex-direction: column;
  gap: 5px;
}
a span {
  width: 100%;
  text-align: center;
  font-size: smaller;
}
</style>
