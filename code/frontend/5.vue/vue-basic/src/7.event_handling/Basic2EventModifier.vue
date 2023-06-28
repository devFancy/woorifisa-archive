<script setup>
import { ref } from 'vue'

// 1. without Event modifier(Plain JS way)
const clickHandler = (event) => {// event -> e
    event.preventDefault(); // 해당 이벤트 객체가 가진 기본 동작 비활성화
}

// 2. Vue Event modifier 활용

const submitHandler = () => {
    console.log('called');
}
</script>

<template>
    <form @submit.prevent="submitHandler">
        <label for="fname">First name:</label>
        <input type="text" id="fname" name="fname">
        <label for="lname">Last name:</label>
        <input type="text" id="lname" name="lname">
        <input type="submit" value="Submit"><br/>
        <input type="submit" value="Submit" @click="clickHandler">
    </form>
</template>

<style scoped>
label {
    font-size: 1.25rem;
    margin-bottom: 0.5rem;
    display: block;
}

input[type='text'] {
    display: block;
    padding: 1rem;
    margin-bottom: 0.5rem;
    height: 2rem;
    font-size: 1.25rem;
    border: 2px dashed gray;
    outline: none;
}

input[type='submit'] {
    background-color: #007bff;
    border: none;
    color: #fff;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 20px;
    cursor: pointer;
    transition: background-color 0.3s ease-in-out;
}

input[type="submit"]:hover {
  background-color: #0062cc;
}
</style>