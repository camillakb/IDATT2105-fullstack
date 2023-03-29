import axios from "axios";
import { useTokenStore } from "../stores/token";
import { useLogContentStore } from "../stores/logContent";
import router from "../router"

export function login(username, password) {
    const tokenStore = useTokenStore();
    const logContentStore = useLogContentStore();

    axios.post("http://localhost:3333/token", {
        username: username, 
        password: password
    }).then((response)=> {
        tokenStore.token = response.data;
        axios.get("http://localhost:3333/history", {
            headers: {
                Authorization: `Bearer ${tokenStore.token}`
            }
        }).then((response) => {
            for (const logEntry of response.data.content) {
                console.log(logEntry);
                logContentStore.addToLog(logEntry.calculation);
            }

            router.push("/calculator");
        })
    })
}

export function createuser(username, password) {
    axios.post("http://localhost:3333/user", {
        username: username,
        password: password
    }).then((response)=> {
        router.push("/")
    })
}