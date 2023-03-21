<script>
    import { mapWritableState } from 'pinia';
    import { useFeedbackFormStore } from '../stores/feedbackForm';
    import axios from "axios";

    export default {
        data: () => {
            return {
                statusInfo: ''
            }
        },
        computed: {
            ...mapWritableState(useFeedbackFormStore, ['name', 'email', 'feedback']),
            //enable button when all fields are filled
            enableButton() {
                if (this.name != '' && this.email != '' && this.feedback != '') {
                    return true;
                }

                return false;
            }
        },
        methods: {
            submit(event) {
                event.preventDefault();
                //sends feedback to ../data/api.json
                axios.post("http://localhost:3000/feedback", {
                    name: this.name,
                    email: this.email,
                    feedback: this.feedback
                }).then(response => {
                    //clear fields when feedback is submitted
                    if (response.status >= 200 && response.status < 300) {
                        this.statusInfo = "Feedback submitted!";
                        this.name = '';
                        this.email = '';
                        this.feedback = '';
                    }
                }).catch(() => {
                    this.statusInfo = "Something went wrong, please try again."
                })
            }
        }
    }
</script>

<template>
    <main class="formcontent">
        <form action="">
            <label for="name">
                Name (required):
            </label>
            <input type="text" id="name" placeholder="Enter name here..." v-model="name">
            <p></p>
            <label for="email">
                Email address (required):
            </label>
            <input type="text" id="email" placeholder="Enter email here..." v-model="email">
            <p></p>
            <label>
                Feedback (required):
            </label>
            <p></p>
            <textarea type="text" id="feedback" rows="4" cols="50" v-model="feedback">
            </textarea>
            <p></p>
            <button id="submitbutton" type="submit" v-bind:disabled="!enableButton" @click="submit">
                Submit
            </button>
            <p>
                {{ statusInfo }}
            </p>
        </form>
    </main>
</template>

<style scoped>
.formcontent {
    display: grid;
    justify-content: center;
}
</style>