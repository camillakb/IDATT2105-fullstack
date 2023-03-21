import { createRouter, createWebHistory } from "vue-router";
import FeedbackView from "../views/FeedbackView.vue";
import CalculatorView from "../views/CalculatorView.vue";
import LoginView from "../views/LoginView.vue";
import UserView from "../views/UserView.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/",
            name: "calculator",
            component: CalculatorView,
        },
        {
            path: "/feedback",
            name: "feedback",
            component: FeedbackView,
        },
        {
            path: "/login",
            name: "login",
            component: LoginView,
        },
        {
            path: "/user",
            name: "user",
            component: UserView,
        }
    ]
});

export default router;