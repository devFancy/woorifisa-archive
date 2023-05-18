import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import { createPinia } from 'pinia';
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { faLink, faRotateRight, faThumbsDown, faThumbsUp } from '@fortawesome/free-solid-svg-icons';

const app = createApp(App);
app.component('font-awesome-icon', FontAwesomeIcon);
app.use(createPinia());
app.use(router);

app.mount('#app');
library.add(faRotateRight, faThumbsUp, faThumbsDown, faLink);
