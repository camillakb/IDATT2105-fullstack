import { defineStore } from "pinia";

export const useFeedbackFormStore = defineStore("feedbackForm", {
    state: () => {
        return {
            name: '',
            email: '',
            feedback: ''
        }
    }
})