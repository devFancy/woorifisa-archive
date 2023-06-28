import { createApp } from 'vue'
import App from './App.vue'
import './assets/main.css'

// router 설정 for 9.lifecycle hooks
import router from './router';

// Vue/Essentials/3.Creating a Vue Application - App 인스턴스
// 1. Create Application instance
const app = createApp(App);

app.use(router);

app.mount('#app');