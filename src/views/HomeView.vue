<template>
  <DefaultLayout>
    <AppHeader />
    <AppSection @delete-todo="deleteTodo" @add-todo="addTodo" :todos="dummyTodos"/>
  </DefaultLayout>
</template>

<script setup>
import AppHeader from '../components/AppHeader.vue';
import AppSection from '../components/AppSection.vue';
import DefaultLayout from '../layouts/DefaultLayout.vue';
import { ref } from 'vue';

const dummyTodos = ref([
{
    id: 1,
    title: "물 마시기",
    summary: '물을 마신다',
    category: 'todo',
},
{
    id: 2,
    title: "콜라 마시기",
    summary: '콜라를 마신다',
    category: 'progress',
    },
{
    id: 3,
    title: "우유 마시기",
    summary: '우유를 마신다',
    category: 'done',
}
]);

const addTodo = (todo) => dummyTodos.value.push(todo);
// const deleteTodo= (todo) => {
//   dummyTodos.value = dummyTodos.value.filter((t) => t.id != todo);
// }

const deleteTodo = (todo) => {
  const idx = dummyTodos.value.findIndex((item) => item.id === todo.id);
  dummyTodos.value.splice(idx, 1);
  console.log(dummyTodos.value);
}

</script>

