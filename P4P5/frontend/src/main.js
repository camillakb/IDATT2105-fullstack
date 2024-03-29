import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import PersistedState  from "pinia-plugin-persistedstate";

import './assets/main.css'

const app = createApp(App);

const pinia = createPinia();
pinia.use(PersistedState)

app.use(pinia)
app.use(router)

app.mount('#app')
