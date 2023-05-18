<script setup></script>

<template>
  <header>
    <h1>Why we use <span>Vue.js</span></h1>
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
  border-bottom: 1px solid #fff;
  padding: 20px;
}
h1 {
  color: #f6ffde;
}
h1 span {
  color: #2cd69d;
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
