import { defineStore } from "pinia";
import { useLogContentStore } from "./logContent";
import axios from "axios";

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
                axios.post("http://localhost:3333/", {
                    calcRequest: this.displayContent
                })
                .then((response) => {
                    console.log(response);

                    if(response.data.status != "") {
                        this.displayContent = "Invalid expression. Press AC.";
                    
                    } else {
                        useLogContentStore().addToLog(this.displayContent, response.data.calcResponse);
                        this.displayContent = response.data.calcResponse;
                    }
                })

            } catch(error) {
                console.error(error);
            }
        }
    }
})