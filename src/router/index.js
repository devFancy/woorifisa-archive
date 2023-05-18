import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import MpaSpaView from '../views/MpaSpaView.vue';
import AboutVueView from '../views/AboutVueView.vue';
import ConclusionView from '../views/ConclusionView.vue';
import ReferenceView from '../views/ReferenceView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/spampa',
      name: 'spaMpa',
      component: MpaSpaView,
    },
    {
      path: '/aboutVue',
      name: 'aboutVue',
      component: AboutVueView,
    },
    {
      path: '/conclusion',
      name: 'conclusion',
      component: ConclusionView,
    },
    {
      path: '/reference',
      name: 'reference',
      component: ReferenceView,
    },
  ],
});

export default router;
