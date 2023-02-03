<script setup>
    import Keypad from './Keypad.vue';
    import Display from './Display.vue';
</script>

<template>
    <main>
        <div class="display">
            <Display />
        </div>

        <div class="keypad">
            <Keypad />
        </div>
    </main>
</template>

<style scoped>
    main {
        display: grid;
        grid-template: 
        "display"
        "keypad";
    }

</style>
