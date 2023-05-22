<template>
  <footer class="border-t-[1px] border-black dark:border-white">
    <p>우리FISA 프론트엔드 기술 세미나</p>
    <p>Copyright @ 2023 그린라이트 - All rights reserved.</p>
    <a
      href="https://github.com/Jiyun-Parkk/woorifisa-fe-tech-seminar"
      target="_blank"
      class="git"
    ></a>
    <!-- <a href="" download class="download">PDF DOWN ⬇️</a> -->
  </footer>
</template>
<style scoped>
footer {
  padding: 30px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.git {
  padding: 20px 0;
  display: block;
  width: 30px;
  height: 30px;
  background: url('../assets/images/github_black.svg') no-repeat center;
  @apply dark:bg-[url('../assets/images/github_white.svg')] bg-no-repeat bg-center;
}
p {
  text-align: center;
}
</style>
