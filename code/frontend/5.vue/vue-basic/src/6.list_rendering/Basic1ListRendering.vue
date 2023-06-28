<template>
	<li v-for="(item, i) in itemArray" :key="item.id">
        {{ item }}
        <p>{{ item.message }}</p>
        <!-- <p>{{ i }}</p> -->
        <!-- <p>상위 스코프: {{ parentMessage }} 참조 가능</p> -->
    </li>
</template>

<script setup>
import { ref } from 'vue';

    const parentMessage = ref('Parent');

    // 객체를 요소로 가지고 있는 배열(배열의 길이 2, 요소가 2개)
    const itemArray = [
        { id: 'i1', message: 'Foo' },
        { id: 'i2', message: 'Bar' },
        { id: 'i3', message: 'Koo' },
        { id: 'i4', message: 'Soo' },
    ];
</script>

<style scoped>
li {
    margin: 1rem;
    padding: 0.75rem;
    border: 2px dashed blue;
    list-style: none;
    font-size: 1.5rem;
}
</style>