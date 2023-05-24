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
    가장 근본적인 목적은 바로 <span>재사용성</span> 입니다. 따라서 하나의
    컴포넌트로 여기저기서 조립식으로 개발이 가능합니다. 아래 그림에서 보시다시피
    컴포넌트들이 조직적으로 모여서 하나의 어플리케이션으로 조립될 수 있습니다.
  </ContentBox>

  <ImageBox src="component.png" />
  <ContentBox mt>
    아래의 투두리스트의 예제에서 보면 리스트 하나하나가 바로 컴포넌트가 됩니다.
    기존의 프론트 개발 방식은 이러한 리스트를 하나의 html안에서 모두
    하드코딩하여 작성했기 때문에, 코드의 유지보수가 힘들었습니다. 하지만 이렇게
    컴포넌트 기반의 개발을 하게 되면서, 이러한 리스트를 백개 천개를 만들어도 단
    하나의 컴포넌트만 수정하면 되기 때문에 유지보수 측면에서 생산성이 훨씬 향상
    되었습니다.
  </ContentBox>
  <ImageBox src="component2.png" />
  <ContentTitle mt="mt" title="Vue.js의 컴포넌트는 SFC" />
  <ContentBox mt>
    이런 Vue.js의 컴포넌트는 SFC, Single File Component 형태로 되어 있습니다.
    Vue.js의 컴포넌트는 template, script, style 세가지 영역으로 구성되어 있어서
    한번에 정적소스와 Javscript, 스타일 코드를 작성하여 코드의 유지보수면에서
    강력한 장점을 가지고 있습니다.
  </ContentBox>
  <ImageBox src="sfc.png" />
  <ContentTitle mt="mt" title="Vue.js의 렌터 파이프 라인 과정" />
  <ContentBox mt>
    위와 같은 컴포넌트는 렌더 파이프라인 과정을 통해 렌더링됩니다. 컴파일 된
    렌더 함수의 코드는 해당 컴포넌트에서 사용하는 <span>반응형 상태값</span> 의
    변화에 따라, 변경 사항이 가상 DOM 트리에 적용되고, 이 가상 DOM과 실제 DOM을
    비교하여 변경된 부분만 교체하여 <span>리렌더링을</span> 하게 됩니다.
  </ContentBox>
  <ImageBox src="renderpipe.png" />

  <ContentTitle mt="mt" title="Vue.js와 MVVM 패턴" />
  <ContentBox mt>
    MVVM 패턴이란, 소프트트웨어 아키텍처의 종류 중 하나인데요.<span>
      Model, View Model, View,
    </span>
    이렇게 세가지로 구성된 아키텍처를 의미합니다. 이 소프트웨어 아키텍처는
    소프트웨어 시스템의 기본 구조와 시스템을 만드는 프로그램의 설계도 같은
    것입니다.
  </ContentBox>

  <ContentBox mt>
    👉 소프트웨어 아키텍처 : 소프트웨어 시스템의 기본 구조와 시스템을 만드는
    설계도
  </ContentBox>

  <ContentBox mt>
    MVVM 패턴에서 View는 저희가 보는 화면을 뜻합니다. 그리고 Model은 Javascript
    코드를 의미합니다. ViewModel은 vue 인스턴스 입니다. 이 ViewModel,그러니까
    Vue.js는 우리가 보는 이 화면과 우리가 작성하는 Javascript 코드의 중간 매개체
    역할을 해주고 있습니다.
  </ContentBox>

  <br />
  <br />
  <ul>
    <li>✅ view: 우리가 보는 화면</li>
    <li>✅ model: Javascript 코드</li>
    <li>✅ viewModel: vue 인스턴스</li>
  </ul>
  <ImageBox src="mvvm.png" />

  <ContentBox mb>
    MVVM 모델에서 어떤 작용이 일어나는지 간략히 예시로 설명드리겠습니다. 만약에
    우리가 화면에서 버튼을 클릭해서 어떤 함수를 실행시켰을 때, 아마 어떠한
    data가 변경되었을 것입니다. 이 때 <span>ViewModel은</span> 사용자의 이벤트를
    감지하고 Javascript에게 이벤트가 실행되었음을 알려주게 됩니다. Javascript는
    이벤트 실행에 따라 <span>변경된 데이터를 Javascript에 적용</span>하고, 다시
    이 ViewModel은 Javascript에서 변경된 데이터를 우리가 보는 화면에
    적용시켜줍니다.
  </ContentBox>
  <ul>
    <li>✅ view: 버튼을 클릭</li>
    <li>✅ model: 이벤트 실행에 따라 변경된 데이터를 Javascript에 적용</li>
    <li>
      ✅ viewModel: Javascript에서 변경된 데이터를 우리가 보는 화면에 적용
    </li>
  </ul>

  <ContentTitle mt="mt" title="View와 Model이 정확히 뭘까요?" />
  <ContentBox mb>
    아래의 영상에서 실제로 저희가 보는 브라우저 화면이 바로 View이고
    <span>console.log</span>에 찍히는 값들이 바로 자바스크립트, Model 입니다.
    아래 영상의 예시 코드는 간단한 카운터 예제 입니다. 버튼을 클릭하면
    javascript의 count.value 값이 변경됩니다. 그런데 클릭이벤트 아래에
    count.value를 p태그에 삽입하는 코드가 있음에도 View에서의 데이터는 변경되지
    않습니다.
  </ContentBox>

  <ContentBox mt mb>
    만약 View에도 변경된 데이터를 함께 적용하고 싶다면, 클릭이벤트 함수 내부에서
    추가적으로 변경된 데이터를 바로 View에 적용시켜주는 코드를 넣어줘야 합니다.
  </ContentBox>

  <video src="../assets/video/countsample5.mp4" controls />

  <ContentBox mt>
    Vue에서는 이런 추가적인 작업을 해주지 않아도 Javascript의 데이터를
    ViewModel에서 변경을 감지하여 View에 직접 바로 적용해줍니다. 관련해서 이후
    부터 더 상세히 설명드리겠습니다.
  </ContentBox>

  <ContentTitle mt="mt" title="Vue.js 핵심 기능 2 가지 - 선언적 렌더링" />
  <ContentBox>
    앞서 말씀드렸다시피 Vue에서는 변경된 데이터를 직접 view에 적용시켜주는
    추가적인 조치를 취하지 않아도 된다고 했습니다. 먼저 Vue에서는 선언적
    렌더링이 가능합니다. 선언적 렌더링이란, html 요소와 javascript를 함께 편리한
    방법으로 사용할 수 있는 작성 방식 입니다. 일반적으로 html 문서 내에서
    javascript의 데이터를 직접적으로 바인딩 할 수 없지만, vue.js에서는 이렇게
    쌍중괄호를 사용하여 쉽게 데이터 바인딩이 가능합니다. <span>{ { } }</span>
    이 구문을 템플릿 리터럴 방식이라고 합니다.
  </ContentBox>

  <ImageBox src="vueRendering.png" />

  <ContentTitle mt="mt" title="Vue.js 핵심 기능 2 가지 - 반응성 데이터" />
  <ContentBox mb>
    Vue.js의 두번째 핵심기능은 반응성 데이터 입니다. 이 반응성 데이터는
    javascript의 Proxy 객체를 활용한 기능인데요, 반응성으로 동작할 수 있는
    원리에 대해서 간략히 말씀드리면, 반응형 데이터들은 할당과 동시에
    <span>Observe 기능이 활성화</span>
    됩니다. 그리고 데이터가 변경되었을 때 내부의 Observe 기능으로 감지한 변화에
    따라, 해당 데이터를 사용하는 요소를 찾아서 반영시키게 됩니다.
  </ContentBox>

  <ul>
    <li>
      💡 1. ref 혹은 reactive함수를 사용하면 데이터가 Proxy 객체로 감싸진다
    </li>
    <li>
      💡 2. 만약 데이터를 변경하는 함수가 호출되면, 해당 함수는 Proxy객체의
      setter함수로 등록된다
    </li>
    <li>💡 3. setter 함수가 동작하면 triger()함수가 실행된다</li>
    <li>💡 4. triger()함수가 발동되면 Vue는 데이터가 변경되었음을 감지하고</li>
    <li>
      💡 5. 변경된 데이터를 실제로 사용하고 있는 View를 찾아가서 변경한다.
    </li>
  </ul>
  <ImageBox src="reactiveex.png" />

  <ContentBox>
    Vue.js에서 반응형 데이터는 <span>ref</span>,<span>reactive</span>를 사용하여
    적용할 수 있습니다. ref와 reactive를 활용해 데이터를 할당하면, Vue 자체의
    기능으로 Proxy객체로 감싸지면서 변화에 따른 감지가 가능해집니다. ref는
    원시자료형, 객체, 배열을 모두 사용할 수 있고, reactive는 객체나 배열에
    한해서만 사용할 수 있습니다.
  </ContentBox>
  <ImageBox src="refusage.png" />
  <ContentBox>
    여기까지 Vue.js의 특징과 장점에 대해 간략히 살펴 보았습니다. 다음 챕터에서
    <span>왜 우리는 Vue를 사용하는가?</span>에 대한 답을 함께 정리해봅시다!
  </ContentBox>
  <NextChapter :link="link" />
  <Giscus />
</template>

<style scoped>
img {
  margin: 30px auto;
}
</style>
