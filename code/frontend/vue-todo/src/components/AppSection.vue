<template>
    <div>
        <TodoHeader @add-todo="addTodo"/>
        <TodoList @delete-todo="deleteTodo" :todos="todos"/>
    </div>
</template>

<script setup>
import TodoList from './todos/TodoList.vue';
import TodoHeader from './todos/TodoHeader.vue';

defineProps({
    todos: {
        type: Array,
    }
})

const emit = defineEmits(['add-todo']);

const addTodo = (todo) => {
    emit('add-todo', todo);
}

const deleteTodo = (todo) => emit('delete-todo',todo);

</script>