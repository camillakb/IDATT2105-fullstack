<script>
import { login } from '../utils/loginutils';

export default {
    name: "LoginView",

    methods: {
        userlogin() {
            login(this.username, this.password);
        },
    },

    data() {
        return {
            username: "",
            password: "",
            loginStatus: "",
        };
    },
};

</script>

<template>
    <p class="info">Please log in to view your account details.</p>
    <main class="logincontent">
        <label for="username">
            Username (required):
        </label>
        <input type="text" id="username" aria-required="true" data-ok="false" placeholder="Enter username here..." v-model="username">
        <p></p>
        <label for="pass">
            Password (required):
        </label>
        <input type="password" id="pass" aria-required="true" data-ok="false" placeholder="Enter password here..." v-model="password">
        <p></p>
        <button id="loginbutton" @click="userlogin">
            Log in
        </button>
        <button id="createuserbutton">
            <RouterLink to="/createuser">Create user</RouterLink>
        </button>
        <label id="loginstatusLabel">{{ loginStatus }}</label>
    </main>
</template>

<style scoped>
.logincontent {
    display: grid;
    justify-content: center;
}

.info{
    display: grid;
    justify-content: center;
    font-size: 25px;
    font-weight: bold;
}

#loginbutton {
    border-color: black;
    border-radius: 5px;
}

#createuserbutton {
    border-color: black;
    border-radius: 5px;
}
</style>