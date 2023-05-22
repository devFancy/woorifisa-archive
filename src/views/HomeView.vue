<script setup>
import ContentTitle from '@/components/Title/ContentTitle.vue';
import ContentBox from '@/components/Container/ContentBox.vue';
import LinkBox from '@/components/Container/LinkBox.vue';
</script>

<template>
  <ContentTitle title="Vanilla Javascript란?" />
  <ContentBox>
    Vanilla Javascript 대 SPA Framework 입니다. 이 파트에서는 의문점을 한번
    던져보려고 합니다. Vanilla Javascript로만 개발한 프로젝트와 SPA Framework로
    개발한 프로젝트를 경험했을때 큰 차이가 있을까요? 우선 Vanilla Javascript라는
    단어가 생소한 분들이 있으실 것 같아, 간략하게 설명해드리겠습니다. 소프트웨어
    세계에서 Vanilla는 기본이라는 뜻을 가지고 있습니다. 그래서 Vanilla
    Javascript는 순수한 자바스크립트로, 추가적인 프레임워크나 라이브러리를
    사용하지 않은 것을 뜻합니다.
  </ContentBox>

  <ContentTitle mt="mt" title="Vue.js란?" />
  <ContentBox>
    Vue.js에 관해 간략히 말씀드리면, SPA 페이지로 프론트를 개발하기 위한
    Javascript 기반의 프레임워크 입니다. HTML, CSS 그리고 Javascript 기반으로
    구축할 수 있고, 컴포넌트 기반 프로그래밍 모델을 제공하고 있습니다. 이
    Vue.js에 대해 우리의 친구 chatGPT는 어떻게 생각하고 있을지 궁금해서 한번
    물어봤습니다. <span>쉽다, 강력하다, 유연하다 </span>라고 생각한다는데, 정말
    Vue.js가 쉽고 강력하고 유연한지 알아보기 위해 동일한 프로젝트를 각각 Vanilla
    Javascript와 Vue.js로 만들어서 단순 비교를 해봤습니다.
  </ContentBox>

  <ContentTitle mt="mt" title="Vanilla Javascript vs Vue.js" />
  <ContentBox>
    Vanilla Javascript로 만든 프로젝트와 Vue.js로 만든 프로젝트는 어떤 차이가
    있을까요? Vanilla Javascript로 만든 Todolist와 Vue.js로 만든 Todolist를 직접
    체험해보세요.
  </ContentBox>
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
    실제로 기능적인 차이는 거의 없습니다. 성능면에서도 큰 차이를 느낄 수
    없습니다. <br />
    <br /><span
      >주의: 프로젝트 규모가 작아서 성능을 비교하기에는 적합한 예제가 아니란
      것은 참고 부탁드리겠습니다 </span
    ><br />
    <br />
    소스코드를 보더라도 Vue.js의 코드는 너무 복잡해보여서 어지러울 지경입니다.
    그런데 왜 세상은 SPA 방식을 채택하고 열광하게 되는 걸까요? 이제 다음
    챕터에서부터 알아가봅시다!
  </ContentBox>
</template>

<style scoped>
img {
  fill: #fff;
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
