<script setup>
import QuestionBox from '@/components/Container/QuestionBox.vue';
import ContentTitle from '@/components/Title/ContentTitle.vue';
import ContentBox from '@/components/Container/ContentBox.vue';
import CounterSample from '@/components/CounterSample.vue';
const answerList = [
  'MPA: Multiple Page Application',
  'SPA: Single Page Application',
];

const handleClickReload = () => {
  window.location.reload();
};
</script>
<template>
  <!--<ContentTitle title="QUIZ ANSWER" />
  <QuestionBox title="MPA와 SPA는 무엇의 줄임말일까요?" :answers="answerList" />-->

  <ContentTitle mt="mt" title="SPA의 에러 - 404 NOT FOUND PAGE" />
  <ContentBox>
    SPA 페이지는 별다른 조치가 없을시, 페이지 전환(라우팅)이후 새로고침을
    시도하거나 해당 URL로 직접 진입시 <span>404 NOT FOUND PAGE</span>가
    노출됩니다. 그 이유는 SPA의 렌더링 방식에서 찾을 수 있습니다. 우선 서버에
    페이지를 요청하게 되면 요청한 주소에 맞는 정적 소스들을 서버에서 보내주어야
    합니다. SPA의 정적 소스는 단 하나인데, SPA 프로젝트를 배포하게 되면 이 단
    하나의 정적소스는 페이지의 <span>루트경로(/)만</span> 가르키게 됩니다.
    따라서 페이지 전환시 새롭게 서버에 요청해서 정적 소스를 따로 다운받는게
    아니라, <span>가상돔</span>을 활용해 URL 주소 조건과 알맞는 컴포넌트를
    렌더링하게 됩니다. 즉, SPA에서 전환된 페이지의 URL로 서버에 요청하게 되면,
    페이지를 구현해줄 소스를 응답으로 보내줄 수 없어서
    <span>404 NOT FOUND PAGE</span>(없는 페이지)가 노출되는 것입니다.
  </ContentBox>

  <ContentTitle mt="mt" title="지금 이 페이지를 새로고침 해보세요!" />
  <button class="reload" @click="handleClickReload">
    <font-awesome-icon icon="fa-solid fa-rotate-right" />
  </button>
  <p class="info">
    새로고침 후엔 뒤로가기, 그리고 다시 새로고침으로 돌아와주세요 :)
  </p>

  <ContentTitle mt="mt" title="SPA는 변경된 부분만 리렌더링" />
  <ContentBox>
    실제로 데이터가 변경된 부분만 리렌더링 된 다는 것을 알기 위해서는 아래의
    간단한 좋아요 예제로 확인해볼 수 있습니다. 좋아요 버튼을 누르면서 Chrome
    확장 프로그램인 Vue-dev-tool을 확인해보면 실제로 데이터가 변경되고 있는
    카운터 박스만 리렌더링 되는 것을 볼 수 있습니다.
  </ContentBox>
  <br />
  <p>
    ✅ 만약 Chrome Vue-dev-tool이 없다면? ➡️
    <a
      class="down-link"
      target="_blank"
      href="https://chrome.google.com/webstore/detail/vuejs-devtools/nhdogjmejiglipccpnnnanhbledajbpd"
      >Chrome Vue-dev-tool install</a
    >
  </p>
  <CounterSample />
</template>

<style scoped>
.reload {
  display: block;
  margin: 0 auto;
  background: none;
  border: none;
  color: inherit;
  cursor: pointer;
  background: rgba(0, 0, 0, 0.5);
  border-radius: 50%;
  padding: 20px;
}
.fa-rotate-right {
  text-align: center;
  font-size: 50px;
}
.info {
  padding: 10px 0;
  text-align: center;
}
.down-link {
  color: #2cd69d;
  transition: all 0.5s;
}
.down-link:hover {
  transform: scale(1.1);
}
</style>
