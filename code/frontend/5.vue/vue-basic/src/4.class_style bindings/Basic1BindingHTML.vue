<script setup>
import { ref, reactive, computed } from 'vue';
// 개발자 도구에서 확인
const isActive = ref(false);
const hasError = ref(false); // or true

const classObject = reactive({
  active: true,
  'text-danger': false
});

const error = ref(null);
const computedObject = computed(() => ({
  active: isActive.value && !error.value,
  'text-danger': error.value && error.value.type === 'fatal'
}));
</script>

<template>
<h2>개발자 도구 element 탭에서 각 엘리먼트 별로 attribute 바인딩 결과 확인</h2>

<div class="title">1. 한 개의 클래스 attribute 바인딩</div>
<div :class="{ active: isActive }">active</div>

<!-- 여러 개의 클래스 바인딩 -->
<div class="title">2. 여러 개의 클래스 attribute 바인딩</div>
<div class="static" :class="{ active: isActive, 'text-danger': hasError }">static active</div>

<!-- 객체로 묶어서 바인딩 -->
<div class="title">3. 객체 형태로 바인딩</div>
<div :class="classObject">classObject</div>

<!-- computed() 적용 후 바인딩 -->
<div class="title">4. computed 적용 후 바인딩</div>
<div :class="computedObject">computedObject</div>
</template>

<style scoped>
  h2 {
    font-weight: bold;
    margin-bottom: 2rem;
  }

  div {
    font-size: 1.5rem;
  }

  .title + div {
    margin-bottom: 2rem;
  }

  .active {
    color: red;
  }  
</style>