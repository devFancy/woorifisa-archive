import path from 'path';
import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@/': `${path.resolve(__dirname, 'src')}/`,
      '@/components/': `${path.resolve(__dirname, 'src/components')}/`,
    },
    extensions: ['.js', '.vue'],
  },
  base: '/woorifisa-fe-tech-seminar/',
});
