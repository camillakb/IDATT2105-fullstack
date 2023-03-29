import { defineStore } from "pinia";
import { useLogContentStore } from "./logContent";
import { useTokenStore } from "./token";
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

        calculate() { //calculations is executed and added to user history in backend
            try {
                axios.post("http://localhost:3333/calculator", {
                    calcRequest: this.displayContent
                },
                {
                    headers: {
                        Authorization: `Bearer ${useTokenStore().token}`
                    }
                })
                .then((response) => {
                    console.log(response);

                    if(response.data.status != "") {
                        this.displayContent = "Invalid expression. Press AC.";
                    
                    } else {
                        //add the equation and result to the log next to the calculator
                        useLogContentStore().addToLog(response.data.calcResponse);

                        this.displayContent = response.data.calcResponse.split("=")[1].trim();
                    }
                })

            } catch(error) {
                console.error(error);
            }
        }
    }
})