<script setup>
import ContentTitle from '../components/ContentTitle.vue';
import ContentBox from '../components/ContentBox.vue';
</script>
<template>
  <ContentBox>
    Vue.js의 가장 큰 특징이자 장점은 데이터바인딩이 쉽다는 점입니다. 특히 Vue.js의 반응형 데이터와
    양방향 데이터 바인딩은 개발자가 추가적으로 데이터를 처리하는 코드를 작성하지 않게 해주기 때문에,
    개발 속도를 향상시킵니다.
  </ContentBox>
  <ContentTitle title="Vue의 반응형 데이터" />
  <ContentBox>
    Vue.js에서 반응형 데이터는 <span>ref</span>,<span>reactive</span>를 사용하여 적용할 수 있습니다.
    ref와 reactive를 활용해 데이터를 할당하면, Vue 자체의 기능으로 Proxy객체로 감싸지면서 변화에
    따른 감지가 가능해집니다.
  </ContentBox>
  <br />
  <ContentBox>
    해당 데이터들은 할당과 동시에 Oserve 기능이 활성화 되는데, 이는 실제 내부적으로는 Proxy 객체의
    getter/setter를 통해 데이터의 변조 및 접근시 작동되는 별도의 로직이 구현되어 있기 때문입니다.
  </ContentBox>
</template>

<style scoped></style>
