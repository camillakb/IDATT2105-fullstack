import axios from "axios";

const baseurl = "http://localhost:3333"

export const loginRequest = (user) => {
    const config = {
        headers: {
            "Content-type": "application/json",
        },
    };

    return axios.get(baseurl + "/", config);
}