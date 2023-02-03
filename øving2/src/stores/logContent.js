import { defineStore } from "pinia";

export const useLogContentStore = defineStore("logContent", {
    state: () => {
        return {
            logContent: []
        }
    }, 
    actions: {
        addToLog(exp, result) {
            this.logContent.push({exp: exp, result: result});
        }
    }
})