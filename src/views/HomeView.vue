<script setup>
import ContentTitle from '@/components/Title/ContentTitle.vue';
import ContentBox from '@/components/Container/ContentBox.vue';
import LinkBox from '@/components/Container/LinkBox.vue';
</script>

<template>
  <ContentTitle title="Vanilla Javascript? Vue.js?" />
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
