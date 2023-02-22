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
        }, 

        calculate() {
            try {
                const exp = this.displayContent;
                const result = Number(Number(eval(this.displayContent)).toPrecision(3));

                if ([undefined, null, NaN, Infinity].includes(result)) {
                    throw new Error(result);
                }

                this.displayContent = result;
                useLogContentStore().addToLog(exp, result);
            
            } catch (error) {
                this.displayContent = "ERROR: please press AC"
                console.warn(error);
            }
        }
    }
})