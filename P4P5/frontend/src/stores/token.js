import { defineStore } from "pinia";

export const useTokenStore = defineStore("token", {
    state: () => {
        return {
            token: "",
        };
    },
    persist: {
        storage: sessionStorage
    },

    actions: {
        isLoggedIn() {
            return this.token.length > 0;
        }
    }
});