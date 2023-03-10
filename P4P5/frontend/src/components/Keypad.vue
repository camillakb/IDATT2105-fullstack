<script setup>
    import Numbers from './Numbers.vue';
    import Operations from './Operations.vue';
</script>

<template>
    <div class="keypad">
        <Numbers />
        <Operations />
    </div>
</template>

<style scoped>
    .keypad {
        margin: 1px;
        display: flex;
    }
</style>
