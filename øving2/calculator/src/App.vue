<script setup>
  import Calculator from './components/Calculator.vue';
  import Log from './components/Log.vue';
</script>

<template>
  <div class="appcontent">
    <div class="calc">
      <Calculator />
    </div>
    
    <div class="log">
      <Log />
    </div>
  </div>

</template>

<style scoped>
  .appcontent {
    grid-template:
    "calc log";
    display: grid;
    max-width: 100vw;
    height: 100vh;
    justify-content: center;
    align-items: center;
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
