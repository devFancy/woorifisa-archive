import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/HomeView.vue';
import WebDevAndFrontEndView from '@/views/WebDevAndFrontEndView.vue';
import VueView from '@/views/VueView.vue';
import ConclusionView from '@/views/ConclusionView.vue';
import ReferenceView from '@/views/ReferenceView.vue';
import NotFound from '@/views/NotFound.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/webpage-and-frontend',
      name: 'webpage-and-frontend',
      component: WebDevAndFrontEndView,
    },
    {
      path: '/vue',
      name: 'vue',
      component: VueView,
    },
    {
      path: '/conclusion',
      name: 'conclusion',
      component: ConclusionView,
    },
    {
      path: '/others',
      name: 'others',
    },
    {
      path: '/reference',
      name: 'reference',
      component: ReferenceView,
    },
    {
      path: '/*',
      redirect: '/404',
      component: NotFound,
    },
  ],
});

export default router;
