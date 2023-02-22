<script setup>
    import Button from './Button.vue';
    import {useDisplayContentStore} from "../stores/displayContent";

    const displayContent = useDisplayContentStore();

    function sendToBackend() {
        //https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses - bruk HTTP respons??
    }
</script>

<template>
    <div class="operators">
        <Button buttontext="*" @click="displayContent.insert('*')" />
        <Button buttontext="/" @click="displayContent.insert('/')" />
        <Button buttontext="+" @click="displayContent.insert('+')" />
        <Button buttontext="-" @click="displayContent.insert('-')" />
        <Button buttontext="DEL" @click="displayContent.remove()" />
        <Button buttontext="AC" @click="displayContent.clear()" />
        <Button buttontext="=" @click="displayContent.sendToBackend()" />
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
