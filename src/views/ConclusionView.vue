<script setup>
import NextChapter from '@/components/Button/NextChapter.vue';
import ContentTitle from '@/components/Title/ContentTitle.vue';
import Giscus from '@/components/Giscus.vue';
const link = {
  before: '/vue',
  next: '/reference',
};
</script>

<template>
  <div class="wrapper">
    <ContentTitle title="왜 우리는 Vue를 사용하는가" />
    <ul>
      <li>
        ✅ 처리해야할 데이터 양이 많아질 경우 SPA를 채택하면 렌더링 속도 향상
      </li>
      <li>✅ 컴포넌트 단위의 개발로 코드 유지보수 효율 향상</li>
      <li>✅ 쉽고 편한 데이터 바인딩으로 작성해야할 코드의 양 감소</li>
      <li>
        ✅ 러닝커브가 낮아 급하게 레거시 프로젝트를 전환해야할 때 개발속도 향상
      </li>
    </ul>
    <NextChapter :link="link" />
    <Giscus />
  </div>
</template>

<style scoped>
.wrapper {
  height: 100vh;
}
ul li + li {
  margin-top: 20px;
}
</style>
