<template>
    <ul>
        <TodoItem @delete-todo="deleteTodo"
        v-for="item in todos" :key="item.id" 
        class="text-white px-0 my-8" 
        :todo="item"/>
    </ul>
</template>

<script setup>
import { ref } from 'vue';
import  TodoItem  from './TodoItem.vue';

defineProps({
    todos: {
        type: Array,
    }
})

const emit = defineEmits(['delete-todo']);

const deleteTodo = (todo) => emit('delete-todo',todo);

</script>
