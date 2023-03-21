<script setup>
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
  <p class="login">
    <RouterLink to="/login">Account</RouterLink>
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
  }

  .feedback{
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .login{
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
