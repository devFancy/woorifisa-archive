<script setup>
import { ref } from 'vue';

const likedCount = ref(0);
const increaseLiked = () => {
  likedCount.value += 1;
};
const decreaseLiked = () => {
  if (likedCount.value === 0) {
    likedCount.value = 0;
  } else {
    likedCount.value -= 1;
  }
};
</script>

<template>
  <section class="counter-box">
    <button @click="decreaseLiked" class="count-btn bad-btn">
      <font-awesome-icon icon="fa-solid fa-thumbs-down" />
      <span>bad</span>
    </button>
    <span class="count-num">{{ likedCount }}</span>
    <button @click="increaseLiked" class="count-btn like-btn">
      <font-awesome-icon icon="fa-solid fa-thumbs-up" />
      <span>good</span>
    </button>
  </section>
</template>

<style scoped>
.counter-box {
  margin: 20px 0;
  background: rgba(0, 0, 0, 0.2);
  padding: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
}
.count-btn {
  padding: 10px;
  background: none;
  border: none;
  color: #fff;
  transition: all 0.5s;
  cursor: pointer;
  font-size: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.count-btn span {
  font-size: 0.8rem;
}
.count-btn.like-btn:active {
  color: #2cd69d;
}
.count-btn.bad-btn:active {
  color: red;
}
.count-num {
  font-size: 30px;
}
</style>
