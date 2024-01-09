<template>
    <header>
        <div class="flex justify-center">
            <RouterLink to="/">
                <h1 class='py-8 text-red-200 max-w-max animate-bounce-slow text-7xl'>todos</h1>
            </RouterLink>
        </div>
        <!-- About 텍스트 클릭 시 localhost:5173/about 경로(AboutView.vue)로 이동 -->
        <nav class="flex justify-end">
            <RouterLink to="/about">
                <span class="text-lg text-white">About</span>
            </RouterLink>
        </nav>
    </header>
</template>

<script setup>
import { RouterLink } from 'vue-router';

</script>