<script setup>
  import Calculator from './components/Calculator.vue';
  import Log from './components/Log.vue';
  import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <h1 class="title">
    Calculator
  </h1>
  <p class="home">
    <RouterLink to="/">Home </RouterLink>
  </p>
  <p class="feedback">
    <RouterLink to="/feedback">Give feedback</RouterLink>
  </p>
  <RouterView />
</template>

<style scoped>
  .title{
    display: flex;
    justify-content: center;
  }

  .home{
    display: flex;
    justify-content: center;
    align-items: center;
    color: darkblue;
  }

  .feedback{
    display: flex;
    justify-content: center;
    align-items: center;
    color: blueviolet;
  }
</style>
