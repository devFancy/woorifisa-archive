<template>
    <div class="flex items-center justify-between mb-2" id="task-control">
        <button
            @click="openModal"
            class="px-6 py-2 font-semibold text-gray-100 bg-gray-800 border-none rounded cursor-pointer"
            data-cy="add-todo-button">Add Todo
        </button>
        
        <Teleport to="body">
            <DefaultModal :show="isModalOpen" @close-modal="closeModal">
                <template #header>
                    <h3>New Todo</h3>
                </template>
                <template #body>
                    <NewTodo @add-todo="addTodo" @close-modal="closeModal"/>
                </template>
            </DefaultModal>
        </Teleport>

        <TodoFilter />
    </div>
</template>

<script setup>
import DefaultModal from '../DefaultModal.vue';
import TodoFilter from './TodoFilter.vue'
import NewTodo from './NewTodo.vue';
import { ref } from 'vue';

const isModalOpen = ref(false); 

const openModal = () => isModalOpen.value = true;
const closeModal = () => isModalOpen.value = false;

const emit = defineEmits(['add-todo']);

const addTodo = (todo) => {
    emit('add-todo', todo);
}

</script>

<style lang="scss" scoped>

</style>