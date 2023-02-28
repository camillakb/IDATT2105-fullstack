<script setup>
    import Button from './Button.vue';
    import {useDisplayContentStore} from "../stores/displayContent";

    const displayContent = useDisplayContentStore();
</script>

<template>
    <div class="operators">
        <Button buttontext="*" @click="displayContent.insert('*')" />
        <Button buttontext="/" @click="displayContent.insert('/')" />
        <Button buttontext="+" @click="displayContent.insert('+')" />
        <Button buttontext="-" @click="displayContent.insert('-')" />
        <Button buttontext="DEL" @click="displayContent.remove()" />
        <Button buttontext="AC" @click="displayContent.clear()" />
        <Button buttontext="=" @click="displayContent.calculate()" />
    </div>
    
</template>

<style scoped>
    .operators {
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-template-rows: 1fr 1fr 1fr;
        empty-cells: hide;
    }
</style>
