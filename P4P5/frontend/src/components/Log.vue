<script setup>
    import { useLogContentStore } from '../stores/logContent';
    const log = useLogContentStore();
</script>

<template>
    <div class="calculatorLog">
        <div v-for="entry in log.logContent.reverse()">
            {{ entry.exp }}
        </div>
    </div>
</template>

<style scoped>
    .calculatorLog {
        border: 1px solid black;
        min-width: 100px;
        height: 150px;
        overflow-y: scroll;
    }
</style>
