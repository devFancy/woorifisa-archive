<script setup>
import ContentTitle from '@/components/Title/ContentTitle.vue';
import ContentBox from '@/components/Container/ContentBox.vue';
import LinkBox from '@/components/Container/LinkBox.vue';
import NextChapter from '@/components/Button/NextChapter.vue';
const link = {
  url: '/webpage-and-frontend',
  title: '프론트개발의 변화',
};
</script>

<template>
  <ContentBox>
    Vanilla Javascript 대 SPA Framework 입니다. Vanilla Javascript로만 개발한
    프로젝트와 SPA Framework로 개발한 프로젝트를 경험했을때 큰 차이가 있을까요?
  </ContentBox>
  <ContentTitle title="Vanilla Javascript란?" />
  <img
    src="../assets/images/icecream.png"
    class="icecream-img"
    alt="icecreamimg"
  />
  <ContentBox>
    우선 Vanilla Javascript라는 단어가 생소한 분들이 있으실 것 같아, 간략하게
    설명해드리겠습니다. 소프트웨어 세계에서 <span>Vanilla는 기본</span>이라는
    뜻을 가지고 있습니다. 그래서 Vanilla Javascript는 순수한 자바스크립트로,
    추가적인 프레임워크나 라이브러리를 사용하지 않은 것을 뜻합니다.
  </ContentBox>

  <ContentTitle mt="mt" title="Vue.js란?" />
  <ContentBox>
    Vue.js는 SPA 페이지로 프론트를 개발하기 위한 Javascript 기반의 프레임워크
    입니다. HTML, CSS 그리고 Javascript 기반으로 구축할 수 있고, 컴포넌트 기반
    프로그래밍 모델을 제공하고 있습니다.
  </ContentBox>

  <ContentTitle mt="mt" title="Vanilla Javascript vs Vue.js" />
  <ContentBox>
    Vanilla Javascript로 만든 프로젝트와 Vue.js로 만든 프로젝트는 어떤 차이가
    있을까요? 먼저 아래 캡처본의 소스코드들을 보면, Vue.js의 코드는 너무
    복잡해보여서 어지러울 지경입니다.
  </ContentBox>
  <img src="../assets/images/vanillavsvue.png" alt="vanillavsvue" />
  <ContentTitle mt="mt" title="직접 만져보며 기능 차이가 있는지 확인해보기!" />

  <section class="link-box">
    <LinkBox
      title="Todolist made in Vanilla Javascript"
      targetLink="https://jiyun-parkk.github.io/mini-projects/2nd_ToDo/"
      gitLink="https://github.com/Jiyun-Parkk/mini-projects/tree/main/2nd_ToDo"
    />
    <LinkBox
      title="Todolist made in Vue.js"
      targetLink="https://jiyun-parkk.github.io/vue-todolist/"
      gitLink="https://github.com/Jiyun-Parkk/vue-todolist"
    />
  </section>
  <ContentTitle mt="mt" title="확인해보셨나요?" />
  <ContentBox>
    한번 체험해보셨나요? 실제로 기능적인 차이는 거의 없습니다. 성능면에서도 큰
    차이를 느낄 수 없습니다. <br />
    <br /><span
      >주의: 프로젝트 규모가 작아서 성능을 비교하기에는 적합한 예제가 아니란
      것은 참고 부탁드리겠습니다 </span
    ><br />
    <br />
    그렇다면 왜 많은 회사에서, 또 세계적으로 Vue.js라는 선택을 하게 된 걸까요?
    그렇게 된 과정에 대해 다음 챕터부터 함께 알아가보려 합니다!
  </ContentBox>
  <NextChapter :link="link" />
</template>

<style scoped>
img {
  margin: 20px auto;
}

.link-box {
  margin: 30px 0;
  display: flex;
  flex-direction: column;
  gap: 50px;
}

.link-box h3 {
  font-size: 25px;
}
</style>
