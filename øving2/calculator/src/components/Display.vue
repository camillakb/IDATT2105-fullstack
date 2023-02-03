<script setup>
    import {useDisplayContentStore} from "../stores/displayContent";
    const displayContent = useDisplayContentStore();
</script>

<template>
    <div class="displaywindow">
        <input :value="displayContent.displayContent" readonly /> <!--Read only, so that it is not possible to use keyboard to type equations-->
    </div>
</template>

<style scoped>
    .displaywindow {
        border-color: black;
    }
</style>