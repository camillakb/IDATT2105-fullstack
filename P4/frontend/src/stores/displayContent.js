import { defineStore } from "pinia";
import { useLogContentStore } from "./logContent";

export const useDisplayContentStore = defineStore("displayContent", {
    state: () => {
        return {
            displayContent: ""
        }
    }, 
    actions: {
        insert(symbol) {
            this.displayContent = this.displayContent + symbol;
        },

        remove() {
            this.displayContent = this.displayContent.slice(0, -1);
        }, 

        clear() {
            this.displayContent = "";
        }
    }
})