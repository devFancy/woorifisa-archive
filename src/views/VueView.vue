<script setup>
import ContentTitle from '@/components/Title/ContentTitle.vue';
import ContentBox from '@/components/Container/ContentBox.vue';
import ImageBox from '@/components/Container/ImageBox.vue';
import NextChapter from '@/components/Button/NextChapter.vue';
import Giscus from '@/components/Giscus.vue';
const link = {
  before: '/webpage-and-frontend',
  next: '/conclusion',
};
</script>
<template>
  <ContentTitle title="Vue.js는 컴포넌트 기반의 아키텍처" />
  <ContentBox>
    Vue.js는 <span>컴포넌트 기반의 아키텍처</span>를 가지고 있습니다. 컴포넌트의
    가장 근본적인 목적은 바로 재사용성 입니다.
  </ContentBox>
  <ContentBox>
    아래 그림에서 보시다시피 컴포넌트들이 조직적으로 모여서 하나의 어플 이 다음
    화면에서리케이션으로 조립될 수 있습니다.
  </ContentBox>
  <ImageBox src="component.png" />

  <ContentBox>
    그리고 아래의 투두리스트의 예제에서 보면 리스트 하나하나가 바로 컴포넌트가
    됩니다. 기존의 프론트 개발 방식은 이러한 리스트를 하나의 html안에서 모두
    하드코딩하여 작성했기 때문에, 코드의 유지보수가 힘들었습니다. 하지만 이렇게
    컴포넌트 기반의 개발을 하게 되면서, 이러한 리스트를 백개 천개를 만들어도 단
    하나의 컴포넌트만 수정하면 되기 때문에 유지보수 측면에서 생산성이 훨씬 향상
    되었습니다.
  </ContentBox>
  <ImageBox src="component2.png" />
  <ContentTitle mt="mt" title="Vue.js의 컴포넌트는 SFC" />
  <ContentBox>
    이런 Vue.js의 컴포넌트는 SFC, Single File Component 형태인데요, Vue.js의
    컴포넌트는 template, script, style 세가지 영역으로 구성되어 있어서 한번에
    정적소스와 Javscript, 스타일 코드를 작성하여 코드의 유지보수면에서 강력한
    장점을 가지고 있습니다.
  </ContentBox>
  <ImageBox src="sfc.png" />
  <ContentTitle mt="mt" title="Vue.js의 렌터 파이프 라인 과정" />
  <ContentBox>
    마지막 특징으로 렌더 파이프라인 과정을 통해 렌더링 된다는 것입니다. Vue의
    템플릿은 렌더 함수를 통해 컴파일됩니다. 컴파일 된 렌더 함수의 코드는 해당
    컴포넌트에서 사용하는 반응형 상태값의 변화에 따라, 변경 사항이 가상 DOM
    트리에 적용되고, 이 가상 DOM과 실제 DOM을 비교하여 변경된 부분만 교체하여
    리렌더링을 하게 됩니다.
  </ContentBox>
  <ImageBox src="renderpipe.png" />

  <ContentTitle mt="mt" title="Vue.js와 MVVM 패턴" />
  <ContentBox>
    MVVM 패턴이란, 소프트트웨어 아키텍처의 종류 중 하나인데요. Model, View
    Model, View 이렇게 세가지고 구성된 아키텍처를 의미합니다. 이 소프트웨어
    아키텍처는 소프트웨어 시스템의 기본 구조와 시스템을 만드는 프로그램의 설계도
    같은 것입니다.
  </ContentBox>
  <br />
  <br />
  <ContentBox>
    잠깐 말씀드렸다시피, MVVM 패턴은 ViewModel과 View, 그리고 Model로
    구성되어있습니다. View는 저희가 보는 화면을 뜻합니다. 그리고 Model은
    Javascript 코드를 의미합니다. ViewModel은 vue 인스턴스 입니다. 이 ViewModel
    그러니까 Vue.js는 우리가 보는 이 화면과, 우리가 작성하는 Javascript 코드의
    중간 매개체 역할을 해주고 있습니다.
  </ContentBox>

  <ul>
    <li>✅ view: 우리가 보는 화면</li>
    <li>✅ model: Javascript 코드</li>
    <li>✅ viewModel: vue 인스턴스</li>
  </ul>
  <ImageBox src="mvvm.png" />

  <ContentBox>
    MVVM 모델에서 어떤 작용이 일어나는지 간략히 예시로 설명드리겠습니다. 만약에
    우리가 화면에서 버튼을 클릭해서 어떤 함수를 실행시켰을 때, 아마 어떠한
    data가 변경되었을 것입니다. 이 때 <span>ViewModel은</span> 사용자의 이벤트를
    감지하고 Javascript에게 이벤트가 실행되었음을 알려주게 됩니다. Javascript는
    이벤트 실행에 따라 <span>변경된 데이터를 Javascript에 적용</span>하고, 다시
    이 ViewModel은 Javascript에서 변경된 데이터를 우리가 보는 화면에
    적용시켜줍니다.
  </ContentBox>
  <br /><br />
  <ul>
    <li>✅ view: 버튼을 클릭</li>
    <li>✅ model: 이벤트 실행에 따라 변경된 데이터를 Javascript에 적용</li>
    <li>
      ✅ viewModel: Javascript에서 변경된 데이터를 우리가 보는 화면에 적용
    </li>
  </ul>
  <ContentTitle mt="mt" title="Vue.js 핵심 기능 2 가지 - 선언적 렌더링" />
  <ContentBox>
    마지막으로 Vue.js의 핵심 기능 2가지를 소개해드리겠습니다. 먼저 선언적 렌더링
    입니다. 선언적 렌더링은 html 요소와 javascript를 함께 편리한 방법으로 사용할
    수 있는 작성 방식 입니다. 일반적으로 html 문서 내에서 javascript의 데이터를
    직접적으로 바인딩 할 수 없지만, vue.js에서는 이렇게 쌍중괄호를 사용하여 쉽게
    데이터 바인딩이 가능합니다.
  </ContentBox>
  <br /><br />
  <ImageBox src="vueRendering.png" />

  <ContentTitle mt="mt" title="Vue.js 핵심 기능 2 가지 - 반응성 데이터" />
  <ContentBox>
    두번째로 반응성 데이터 입니다. 이 반응성 데이터는 javascript의 Proxy 객체를
    활용한 기능인데요, 반응성으로 동작할 수 있는 원리에 대해서 간략히
    말씀드리면, 반응형 데이터들은 할당과 동시에
    <span>Observe 기능이 활성화</span>
    됩니다. 그리고 데이터가 변경되었을 때 내부의 Observe 기능으로 감지한 변화에
    따라, 해당 데이터를 사용하는 요소를 찾아서 반영시키게 됩니다.
  </ContentBox>
  <ImageBox src="reactiveex.png" />

  <br /><br />

  <ContentBox>
    Vue.js에서 반응형 데이터는 <span>ref</span>,<span>reactive</span>를 사용하여
    적용할 수 있습니다. ref와 reactive를 활용해 데이터를 할당하면, Vue 자체의
    기능으로 Proxy객체로 감싸지면서 변화에 따른 감지가 가능해집니다. ref는
    원시자료형, 객체, 배열을 모두 사용할 수 있고, reactive는 객체나 배열에
    한해서만 사용할 수 있습니다.
  </ContentBox>
  <ImageBox src="refusage.png" />
  <NextChapter :link="link" />
  <Giscus />
</template>

<style scoped>
img {
  margin: 30px auto;
}
</style>
