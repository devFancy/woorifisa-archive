/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{vue, js}",
  ],
  theme: {
    extend: {
      animation: {
        'bounce-slow': 'bounce 1.8s infinite'
      }
    },
  },
  plugins: [],
}