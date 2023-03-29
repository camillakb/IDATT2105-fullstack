<script>
import { mapStores } from 'pinia';
import router from '../router';
import { useTokenStore } from '../stores/token';
import { useLogContentStore } from '../stores/logContent';

export default {
    methods: {
        logout() {
            this.tokenStore.token = "";
            router.push("/")
        }
    },

    computed: {
        ...mapStores(useTokenStore, useLogContentStore)
    }
}
</script>

<template>
    <p class="title">Your latest calulations:</p>

    <div class="calchistory">
        <div v-for="entry in this.logContentStore.logContent.reverse()">
            {{ entry.exp }}
        </div>
    </div>

    <button class="logout" type="submit" @click="logout">
        Log out
    </button>
</template>

<style scoped>
.title {
    display: grid;
    justify-content: center;
    font-size: 25px;
    font-weight: bold;
}

.calchistory {
    display: grid;
    justify-content: center;
}

#logoutbutton {
    border-radius: 5px;
    border-color: black;
}
</style>