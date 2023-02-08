import { createRouter, createWebHistory } from "vue-router";
import FeedbackView from "../views/FeedbackView.vue";
import CalculatorView from "../views/CalculatorView.vue";

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
        }
    ]
});

export default router;
