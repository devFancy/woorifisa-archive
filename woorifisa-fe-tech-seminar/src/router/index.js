import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/HomeView.vue';
import VanillaJSAndVue from '@/views/VanillaJSAndVue.vue';
import WebDevAndFrontEndView from '@/views/WebDevAndFrontEndView.vue';
import VueView from '@/views/VueView.vue';
import ConclusionView from '@/views/ConclusionView.vue';
import ReferenceView from '@/views/ReferenceView.vue';

const router = createRouter({
  scrollBehavior(to, from, savedPosition) {
    return { top: 0 };
  },
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/vanillaJSVue',
      name: 'vanillaJS&Vue',
      component: VanillaJSAndVue,
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
    // {
    //   path: '/others',
    //   name: 'others',
    // },
    {
      path: '/reference',
      name: 'reference',
      component: ReferenceView,
    },
  ],
});

export default router;
