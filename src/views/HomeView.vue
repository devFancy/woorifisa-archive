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

import { useTodoStore } from '../stores/todo';
import { storeToRefs } from 'pinia';

// pinia의 stroe를 사용하려면 해당 store를 import
const todoStore = useTodoStore();
// 디스트럭처링할 경우, 반응성이 깨짐
// const { todos } = todoStroe;
// console.log(todos);
const { filteredTodosByCategory } = storeToRefs(todoStore);

const dummyTodos = filteredTodosByCategory;
const newTodoId = dummyTodos.value.length;

const addTodo = (todo) => {
  dummyTodos.value.push({ id: newTodoId + 1, title: newTodo.title, summary: newTodo.summary, category: newTodo.category });
  // dummyTodos.value.push({id: newTodoId + 1, title: newTodo.title.value, summary: newTodo.summary.value, category: newTodo.category.value}); // console.log(dummyTodos.value);
}

const deleteTodo = (todo) => {
  const idx = dummyTodos.value.findIndex((item) => item.id === todo.id);
  dummyTodos.value.splice(idx, 1);
  console.log(dummyTodos.value);
}

</script>

