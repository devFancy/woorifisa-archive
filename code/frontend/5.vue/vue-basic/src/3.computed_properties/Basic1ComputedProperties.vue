<template>
  <p>출판된 도서가 최소 1권 이상 있는지?</p>
  <span>{{ publishedBooks }}</span>

  <p>{{ fullName }}</p>
</template>

<script setup>
import { computed, reactive, ref } from 'vue'

const author = reactive({
    name: 'John Doe',
    books: [
        'Vue 2 - Advanced Guide',
        'Vue 3 - Basic Guide',
        'Vue 4 - The Mystery',
        'Vue 4 - The Mystery'
    ]
});

const publishedBooks = computed(() => {
  return author.books.length > 0 ? 'Yes' : 'No';
});

const firstName = ref('John');
const lastName = ref('Doe');
console.log(firstName);

const fullName = computed(() => firstName.value + lastName.value);

</script>