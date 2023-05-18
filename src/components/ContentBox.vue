<template>
  <p class="contents">
    <slot></slot>
  </p>
</template>
<style>
.contents {
  width: 80%;
  line-height: 1.5;
  font-size: 18px;
  text-align: justify;
  word-break: break-all;
}
.contents span {
  color: #d41564;
}

@media (max-width: 1024px) {
  .contents {
    width: 100%;
  }
}
</style>
