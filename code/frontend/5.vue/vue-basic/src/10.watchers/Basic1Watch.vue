<template>
    <button @click="x += 1">x값 1 증가</button>
    <div>x: {{ x }}</div>
    <button>y값 1 증가</button>
    <div>y: {{ y }}</div>
</template>

<script setup>
import { ref, watch } from 'vue';

const x = ref(0);
const y = ref(0);

// watch 시그니처: watch(감시할 반응형 소스, 반응형 소스의 값이 변경될 경우 동작할 콜백함수);
// watch(x, (newX) => {
//     console.log(`x 값: ${newX}`);
// });

// watch(x, (newX, oldX) => {
//     console.log(`newX: ${newX}, oldX: ${oldX}`);
// });

watch(() => x.value, (newX) => console.log(`x: ${newX}`));
watch(() => x.value + y.value, (sum) => console.log(`x + y: ${sum}`));

watch([x, y], (newValues, oldValues) => {
    console.log(`newValues: ${newValues}, oldValues: ${oldValues}`);

    console.log(`newValues of X: ${newValues[0]}`);
    console.log(`newValues of Y: ${newValues[1]}`);

    console.log(`oldValues of X: ${oldValues[0]}`);
    console.log(`oldValues of Y: ${oldValues[1]}`);
});

// 반응형 객체의 속성을 감시할 수는 없음
watch(x.value, (x) => console.log(`x: ${x}`)); // 값 자체로 사용하기 위해서는 getter 사용
</script>