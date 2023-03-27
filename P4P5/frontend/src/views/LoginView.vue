<script>
import axios from 'axios';
import { toHandlers } from 'vue';
import router from '../router';
import { isLoginSuccessful } from '../utils/loginutils';

export default {
    name: "LoginView",

    methods: {
        async userlogin(event) {
            try {
                axios.post("http://localhost:3333/", {
                    //loginReq: brukernavn + passord???
                })
                .then((response) => {
                    if (isLoginSuccessful(response)) {
                        router.push("/calculator");
                        //Skal være .../brukernavn/calculator/ - hvordan fikser jeg det??
                    
                    } else {
                        this.loginStatus = "Your password or username is invalid."
                    }
                })
            
            } catch(error) {
                console.log(error);
            }
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
        <button id="loginbutton" type="submit" @click="userlogin">
            Log in
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
</style>