/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: 'class',
  content: ['./src/**/*.{html,js,vue}'],
  theme: {
    extend: {
      colors: {
        vueGreen: '#2cd69d',
      },
    },
  },
  plugins: [],
};
