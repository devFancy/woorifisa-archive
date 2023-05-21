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

  <ContentTitle mt="mt" title="SPA의 렌더링 방식 - CSR(Client Side Rendering)" />
  <ContentBox>
    SPA는 Client Side Rendering 방식을 사용합니다. 클라이언트는 서버에게 
    <span>최초 URL 요청 시</span>에 <span>한번만</span> HTML, CSS, JS 정적 파일을 받아오고, 
    브라우저에 렌더링 합니다. 이후 페이지를 전환하거나 데이터 변경이 있을 시에는 서버에 
    추가적인 요청을 보내는 것이 아니라, 최초 url 요청 시에 받아온 
    JS 파일을 이용해서 <span>클라이언트 내</span>에서 <span>자체적</span>으로 페이지를 전환합니다.
    이 방식은 서버에게 추가 URL을 요청하는 것이 아니기 때문에, 
    화면에 리렌더링 하지 않아서, <span>화면 깜빡임 현상이 없습니다</span>.
  </ContentBox>

  <ContentTitle mt="mt" title="SSR vs CSR" />
  <ContentBox>
    SSR은 클라이언트가 새로운 url 접속이나 데이터 변경을 서버에게 요청할 때마다 
    서버는 클라이언트에게 <span>새로운 html, css, js 정적 파일</span>을 보내줍니다. 
    그리고 클라이언트의 브라우저 렌더링 엔진은 서버로부터 받은 html 파일을 사용해서, 
    <span>새롭게 페이지 렌더링</span> 과정을 <span>처음부터</span> 진행합니다. 
    반면에 CSR은 서버에게 최초의 URL 접속을 요구할 때에 <span>모든 정적 파일</span>을 받아오게 되고, 
    이후에는 <span>데이터 변경</span>이 있을 시에 서버에게 요청을 보내고, <span>JSON</span> 형식으로 
    받아옵니다. 그리고 자바스크립트를 이용해서 이 변경된 데이터를 사용하는 요소를 <span>가상 돔</span>을 통해서 변경시킵니다.
  </ContentBox>

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

  <ContentTitle mt="mt" title="SPA의 404 NOT FOUND PAGE 에러 해결 방안 " />
  <ContentBox>
    <ul type="circle">
      <li>∙ 프론트엔드에서 해결하기 : Vue 사용자면 라우팅 방식을 <span>해시 모드</span>로 이용</li>
      <br>
      <li>
        ∙ 백엔드에서 해결하기: 서버 측에서 <span>대체 경로</span> 추가
        <div>
          ex) Node.js: connect-history-api-fallback API 사용<br><br>
          var history = require('connect-history-api-fallback');<br>
          var express = require('express');<br>

          var app = express();<br>
          app.use(history());<br>

          history({<br>
            &ensp; rewrites: [<br>
            &ensp; &ensp;  { from: /\/about/, to: '/index.html'}<br>
            &ensp; ]<br>
          });<br>
        </div>
      </li>
    </ul>
  </ContentBox>

  <ContentTitle mt="mt" title="SPA의 장/단점" />
  <ContentBox>
    <ul>[ 장점 ]
      <li>∙ 컴포넌트 단위로 개발하여 <span>유지보수가 용이</span>합니다.</li>
      <li>∙ 페이지 이동 시, 서버에게 추가 요청을 보내지 않아 <span>화면의 전환 속도가 빠릅니다</span>.</li>
    </ul>
    <br>
    <ul>[ 단점 ]
      <li>∙ 한번에 프로젝트의 모든 소스를 다운받기때문에 <span>초기로딩 속도가 오래</span>걸립니다.</li>
      <li>∙ 처음부터 HTML의 모든 정적 소스가  비어있고, 
        Javascript만으로 되어있습니다. 크롤러 봇은 
        Javascript를 읽어내지 못하기 때문에 <span>SEO 최적화가 힘듭니다</span>.</li>
    </ul>
  </ContentBox>

  <ContentTitle mt="mt" title="라이브러리와 프레임워크" />
  <ContentBox>
    라이브러리와 프레임워크의 차이는 <span>통제권</span>이 어디에 있는가를 기준으로 나뉩니다.<br><br>
    ∙ <strong><span>Library</span></strong>
   <br>
   ➡ 조립식 가구라고 생각하시면 됩니다. 조립식 서랍장을 샀다면, 
    각 부품들을 원하는 방식으로, 원하는 서랍의 개수만큼 조립하면 됩니다.
    따라서 통제권이 <span>개발자</span>(가구 조립자)에게 있습니다.
    대표적으로는 <span>React</span>가 있습니다.
    <br><br>
    ∙ <strong><span>Framework</span></strong>
    <br>
    ➡ 집을 꾸미는 것으로 비유할 수 있습니다. 
    소파나 냉장고의 위치는 자유롭게 배치할 수 있지만,
    기둥이나 방의 개수 등 굵직한 뼈대는 수정할 수 없습니다.
    따라서 통제권이 <span>프레임워크</span>에 있습니다.
    대표적으로 <span>Vue.js</span>, <span>nuxt.js</span>, Angular가 있습니다.
  </ContentBox>

  <ContentTitle mt="mt" title="Vue.js, React 모두 공부해야 하나요?" />
  <ContentBox>
    <span style="font-size: 2rem;">No!</span> <br>
    ✅ 프로젝트의 규모가 작은 경우? ➡️ Vanilla JS  <br>
    ✅ 취업하고자 하는 회사의 스택 or 취향 ➡️ Vue.js / React
  </ContentBox>
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
