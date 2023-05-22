<script setup>
import ContentBox from '@/components/Container/ContentBox.vue';
import ContentTitle from '@/components/Title/ContentTitle.vue';
import NextChapter from '@/components/Button/NextChapter.vue';
const link = {
  url: '/vanillaJSVue',
  title: 'Vanilla Javascript vs Vue.js',
};
</script>
<template>
  <div class="wrapper">
    <ContentBox>
      안녕하세요, 팀 GreenLight 입니다.
      <br />
      <br />
      저희는 순수 Javascript만으로도 웹페이지를 개발할 수 있는데 왜 Vue와 같은
      프레임워크를 배우고 사용해야하는지에 대한 궁금증이 생겼습니다. 따라서
      <span>“왜 우리는 Vue를 사용하는가?”</span>라는 주제로 함께 고민해보려고
      합니다.
    </ContentBox>

    <ContentTitle mt="mt" title="Target" />
    <ContentBox> 저희는 이런 분들을 위해 프로젝트를 준비했습니다! </ContentBox>
    <br /><br />
    <ul>
      <li>✅ Vue or React와 같은 개발 툴을 사용하는 이유가 궁금한 개발자</li>
      <li>✅ SPA를 어디서 들어봤지만, 명확한 의미를 모르는 프론트 개발자</li>
      <li>✅ 프론트엔드 프레임워크 원리가 궁금한 백엔드 개발자</li>
    </ul>
    <NextChapter :link="link" />
  </div>
</template>

<style scoped>
.wrapper {
  height: 100vh;
}
ul li {
  font-size: 1.2rem;
}
li + li {
  margin-top: 20px;
}
</style>
