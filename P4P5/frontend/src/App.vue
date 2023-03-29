<script>
  import { mapStores } from 'pinia';
import { RouterLink, RouterView } from 'vue-router';
  import { useTokenStore } from './stores/token';

  export default {
    computed: {
      ...mapStores(useTokenStore)
    }
  }

</script>

<template>
  <h1 class="title">
    Calculator
  </h1>
  <div v-if="this.tokenStore.isLoggedIn()">
    <p class="calculator">
      <RouterLink to="/calculator">Calculator </RouterLink>
    </p>
    <p class="feedback">
      <RouterLink to="/feedback">Give feedback</RouterLink>
    </p>
    <p class="user">
      <RouterLink to="/user">Account</RouterLink>
    </p>
    
  </div>
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
