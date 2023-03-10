<script setup>
import Calculator from "../components/Calculator.vue"
import Log from "../components/Log.vue";
</script>

<template>
    <main>
        <div class="appcontent">
            <div class="calc">
                <Calculator />
            </div>

            <div class="log">
                <Log />
            </div>
        </div>
    </main>
</template>

<style>
.appcontent {
    grid-template:
        "calc log";
    display: grid;
    max-width: 100vw;
    height: 100vh;
    justify-content: center;
    align-items: flex-start
}

@media (max-width: 481px) {
    body {
      display: grid;
      grid-template: 
      "calc"
      "log";
    }
  }
</style>