<template>
    <form>
        <label for="password">비밀번호</label>
        <input v-model="password" placeholder="비밀번호를 입력하세요" id="password"/>
        <p v-if="password.length < 4" class="weak" >Weak Password</p>
        <p v-else-if="password.length < 7" class="fairly-strong" >Fairly Strong Password</p>
        <p v-else class="strong" >Strong Password</p>
        <!-- 
            비밀번호의 자리수가 4글자 미만이면 Weak
            7글자 미만이면 Fairly Strong
            그 이상이면 Strong이 출력되도록
        --> 
    </form>
</template>

<script setup>
import { ref } from 'vue';

const password = ref('');
</script>

<style scoped>
label {
    font-size: 1.25rem;
    display: block;
    margin-bottom: 0.5rem;
}

input {
    margin-bottom: 20px;
    padding: 1rem;
    height: 2rem;
    font-size: 1.25rem;
    border: 2px dashed gray;
    outline: none;
}

p {
    font-size: 1.5rem;
}

.weak {
    color: red;
}

.fairly-strong {
    color: coral;
}

.strong {
    color: rgb(14, 218, 17);
}
</style>
