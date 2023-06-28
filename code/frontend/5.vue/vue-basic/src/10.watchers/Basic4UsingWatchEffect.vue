<template>
  <h1>Latest Vue Core Commits</h1>
  <template v-for="branch in branches">
    <input type="radio"
      :id="branch"
      :value="branch"
      name="branch"
      v-model="currentBranch">
    <label :for="branch">{{ branch }}</label>
  </template>
  <p>vuejs/vue@{{ currentBranch }}</p>
  <ul>
    <li v-for="{ html_url, sha, author, commit } in commits">
      <a :href="html_url" target="_blank" class="commit">{{ sha.slice(0, 7) }}</a>
      - <span class="message">{{ truncate(commit.message) }}</span><br>
      by <span class="author">
        <a :href="author.html_url" target="_blank">{{ commit.author.name }}</a>
      </span>
      at <span class="date">{{ formatDate(commit.author.date) }}</span>
    </li>
  </ul>
</template>

<script setup>
import { ref, watchEffect } from 'vue';

const API_URL = `https://api.github.com/repos/vuejs/core/commits?per_page=3&sha=`;
const branches = ['main', 'v2-compat'];

const currentBranch = ref(branches[0]);
const commits = ref(null);

watchEffect(async () => {
  // 이 코드는 즉시 호출(동작)되고, API_URL, currentBranch의 값이 변경될 때마다 동작
  // -> watch()와 다르게 감시할 소스를 명시적으로 지정하지 않고, 코드 내부에 작성
  const url = `${API_URL}${currentBranch.value}`;
  const response = await fetch(url);
  const data = await response.json();
  commits.value = data;
  // commits.value = await (await fetch(url)).json() -> 한줄 표현
})

function truncate(v) {
  const newline = v.indexOf('\n');
  return newline > 0 ? v.slice(0, newline) : v;
}

function formatDate(v) {
  return v.replace(/T|Z/g, ' ');
}
</script>

<style scoped>
a {
  text-decoration: none;
  color: #42b883;
}
li {
  line-height: 1.5em;
  margin-bottom: 20px;
}
.author,
.date {
  font-weight: bold;
}
</style>