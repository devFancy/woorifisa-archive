<template>
    <h1>{{ message.msg }}</h1>
    <p>Count is: {{ counter.count }}</p>
</template>

<script setup>
import { reactive } from 'vue';

    // counter - Vue의 이 컴포넌트에서 관리할 상태값
    const counter = reactive({ count: 5 });
    console.log(counter);
    const message = reactive({ msg: 'Hello World!'}); // Hello World!가 상태값으로 출력되도록
</script>

<style></style>