<script>
//TO-DO: create userlogout-method to send user back to loginview
</script>

<template>
    <p class="title">Your latest calulations:</p>
    <div class="calchistory">
        <div>
            <!--make log of latest calculations for the user-->
        </div>
        <button id="logoutbutton" type="button" @click="userlogout">
            Log out
        </button>
    </div>
    
    
</template>

<style scoped>
.title{
    display: grid;
    justify-content: center;
    font-size: 25px;
    font-weight: bold;
}
.calchistory{
    display: grid;
    justify-content: center;
}

#logoutbutton{
    border-radius: 5px;
    border-color: black;
}
</style>