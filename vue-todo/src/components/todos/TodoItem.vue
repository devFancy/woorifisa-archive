<template>
    <li class="flex gap-4 justify-between my-4 py-4 px-4 border-[1px] bg-gray-700 rounded-md shadow-xl">
        <div>
            <span class="text-lg font-medium text-gray-300">{{ category_icons[todo.category] }}</span>
            <div>
                <h2 data-test="title" class="mb-0 text-lg font-bold text-gray-100 uppercase">{{ todo.title }}</h2>
                <p class="mt-2 text-base text-gray-200">{{ todo.summary }}</p>
            </div>
        </div>
        <div class="flex items-center gap-2">
            <button class="w-8 text-xl font-semibold cursor-pointer"
            @click="openModal"
            >✏️</button>
            <button class="w-8 text-xl font-semibold text-red-300 cursor-pointer" @click="todoStore.deleteTodo(todo.title, todo.summary)">X</button>

            <Teleport to="body">

                <DefaultModal :show="isModalOpen" @close-modal="closeModal"> <!-- 흐린 배경과 모달창 -->
                    <!-- Template # 뒤에 DefaultModal.vue 안의 slot name과 맞춰 적어서, 해당 부분을 대체한다. -->
                    <template #header> 
                        <h3>New Todo</h3>
                    </template>
                    <template #body>
                        <EditTodo :todo="todo" @add-todo="addTodo" @close-modal="closeModal"/>
                    </template>
                </DefaultModal>

            </Teleport>
        </div>
    </li>
</template>

<script setup>

import { useTodoStore } from '../../stores/todo';
import { ref } from 'vue';
import DefaultModal from '../DefaultModal.vue';
import EditTodo from './EditTodo.vue'; 

defineProps({
    todo: {
        type: Object,
        default() {
            return {
                id: '',
                title: '',
                summary: '',
                category: '',
            }
        }
    }
})

const category_icons = {
    todo: '📑',
    progress: '👀',
    done: '😀',
}

const todoStore = useTodoStore();

const isModalOpen = ref(false);

const openModal = () => isModalOpen.value = true;
const cloaseModal = () => isModalOpen.value = false;

const emit = defineEmits(['add-todo']);

const addTodo = (todo) => emit('add-todo',todo);

</script>
