<template>
    <Transition>
        <div v-if="show === true">
            <div
                
                class="fixed top-0 left-0 w-full h-full backdrop-blur-md z-1"
                data-cy="modal-backdrop"
                ></div>
            <div
                class="fixed z-10 w-1/2 p-8 m-0 transform -translate-x-1/2 -translate-y-1/2 border-none rounded shadow-xl top-1/2 left-1/2 bg-slate-600">
                <div class="modal-container"
                        data-cy="modal-container"
                >
                    <div class="modal-header">
                        <slot name="header">default header</slot>
                    </div>

                    <div class="modal-body">
                        <slot name="body">default body</slot>
                    </div>
                    <!-- <div class="modal-footer">
                        <slot name="footer">
                            <button class="modal-default-button" @click="$emit('close')">OK</button>
                        </slot>
                    </div> -->
                </div>
            </div>
        </div>
    </Transition>
</template>

<script setup>

defineProps( {
    show: {
        type: Boolean,
    }
})

const emit = defineEmits(['close-modal']);

</script>

<style lang="scss" scoped>

</style>