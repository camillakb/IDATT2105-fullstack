<script>
</script>

<template>
    <p class="title">Your latest calulations:</p>

    <div class="calchistory">
        <div>
            <!--make log of latest calculations for the user-->
        </div>
    </div>

    <button class="logout">
        <RouterLink to="/">Log out</RouterLink>
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