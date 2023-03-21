<script>
//create method for user to log in and be sent to userview
</script>

<template>
    <p class="info">Please log in to view your account details.</p>
    <main class="logincontent">
        <label for="username">
            Username (required):
        </label>
        <input type="text" id="username" placeholder="Enter username here..." v-model="username">
        <p></p>
        <label for="pass">
            Password (required):
        </label>
        <input type="password" id="pass" placeholder="Enter password here..." v-model="password">
        <p></p>
        <button id="loginbutton" type="button" v-bind:disabled="!enableButton" @click="userlogin">
            Log in
        </button>
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