<script setup>
  import { RouterLink, RouterView } from 'vue-router';

  //only show calculator, feedback and user-link when logged in

</script>

<template>
  <h1 class="title">
    Calculator
  </h1>
  <p class="calculator">
    <RouterLink to="/calculator">Calculator </RouterLink>
  </p>
  <p class="feedback">
    <RouterLink to="/feedback">Give feedback</RouterLink>
  </p>
  <p class="user">
    <RouterLink to="/user">Account</RouterLink>
  </p>
  <RouterView />
</template>

<style scoped>
  .title{
    display: flex;
    justify-content: center;
  }

  .calculator{
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .feedback{
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .user{
    display: flex;
    justify-content: center;
    align-items: center;
  }

</style>
