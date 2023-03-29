import { defineStore } from "pinia";

export const useLogContentStore = defineStore("logContent", {
    state: () => {
        return {
            logContent: []
        }
    }, 
    persist: {
        storage: sessionStorage
    },
    actions: {
        addToLog(exp) {
            this.logContent.push({exp: exp});
        }
    }
})