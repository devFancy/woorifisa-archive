<script setup></script>

<template>
  <header class="border-b-[1px] border-black dark:border-white">
    <router-link to="/">
      <img src="../assets/images/greenlight-low-resolution-logo-color-on-transparent-background.png" alt="logo" class="img-logo">
    </router-link>
    <h1 class="text-black dark:text-white">
      Why we use <span class="text-green-700 dark:text-vueGreen">Vue.js</span>
    </h1>
    <a
      href="https://github.com/Jiyun-Parkk/woorifisa-fe-tech-seminar/blob/master/why_we_use_vue.pdf?raw=True"
      download="why_we_learn_vue.js.pdf"
    >
      <span> 📁 </span>
      <span id="pdf-id">PDF download</span>
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

.img-logo {
  width: 6rem;
  height: 6rem;
}

h1 {
  font-weight: 700;
  font-size: 40px;
  text-shadow: rgba(0, 0, 0, 0.25) 5px 5px 10px;
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

#pdf-id {
  font-weight: 500;
  font-size: 15px;
}

</style>
