<template>
    <!-- v-html을 사용하지 않았기 때문에 해당 문자열 값이 그자체로 표시됨 -->
    <p>Using text interpolation: {{ rawHTML }}</p>

    <!-- v-html 디렉티브를 활용하여 HTML 엘리먼트를 화면에 렌더링 -->
    <p>Using v-html directive: <span v-html="rawHTML"></span></p>
</template>

<script setup>
import { ref } from 'vue';
//'<span style="color: red">This should be red.</span>'

const rawHTML = ref('<span style="color: red">This should be red.</span>');
</script>