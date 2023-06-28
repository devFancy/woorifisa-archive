<template>
    <div>{{ state.count }}</div>
    <button @click="increment">Click</button>
</template>

<script>
import { reactive } from 'vue';

export default {
    setup() {
        const state = reactive({ count: 0 });
        
        const increment = () => state.count++;

        return { state, increment }
    }
}

</script>

<style scoped></style>