<script setup>
    import Button from './Button.vue';
    import {useDisplayContentStore} from "../stores/displayContent";

    const displayContent = useDisplayContentStore();
    let buttonnumbers = [];

    for (let i = 1; i < 10; i++) {
        buttonnumbers.push(i.toString());
    }

    buttonnumbers.push("0", ".")
    
</script>

<template>
    <div class="numbers">
        <Button v-for="num in buttonnumbers" :buttontext="num" :style="{gridColumn: num === '0' ? '1/3' :''}" @click="displayContent.insert(num)" />
    </div>
    
</template>

<style scoped>
    .numbers {
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        empty-cells: hide;
    }
</style>
