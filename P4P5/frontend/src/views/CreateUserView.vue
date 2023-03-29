<script>
import {createuser} from "../utils/loginutils"

export default {
    name: "CreateUserView",

    data() {
        return {
            username: "",
            password: ""
        }
    },

    methods: {
        create() {
            createuser(this.username, this.password);
        },
    },
};
</script>

<template>
    <p class="info">Create an account</p>
    <main class="createusercontent">
        <label for="username">
            Choose a username (required):
        </label>
        <input type="text" id="username" aria-required="true" data-ok="false" placeholder="Enter username here..."
            v-model="username">
        <p></p>
        <label for="pass">
            Choose a password (required):
        </label>
        <input type="password" id="pass" aria-required="true" data-ok="false" placeholder="Enter password here..."
            v-model="password">
        <p></p>
        <button id="createuserbutton" type="submit" @click="create">
            Create user
        </button>
    </main>
</template>

<style>
.createusercontent {
    display: grid;
    justify-content: center;
}

.info {
    display: grid;
    justify-content: center;
    font-size: 25px;
    font-weight: bold;
}

#createuserbutton {
    border-color: black;
    border-radius: 5px;
}
</style>