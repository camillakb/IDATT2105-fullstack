<script setup>
    const props = defineProps({
        buttontext: {
            type: String,
            required: true
        }
    })
</script>

<template>
    <button>{{buttontext}}</button>
</template>

<style scoped>
    button {
        background-color:rgb(235, 162, 198);
        border-color: black;
        min-width: 3em;
        height: 2em;
        margin: 1px;
    }
</style>
