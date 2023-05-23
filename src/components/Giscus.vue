<script setup>
import { useChangeTheme } from '@/stores/theme';
import Giscus from '@giscus/vue';
const theme = useChangeTheme();
</script>

<template>
  <div class="giscus-wrap">
    <Giscus
      id="comments"
      repo="Jiyun-Parkk/woorifisa-fe-tech-seminar"
      repo-id="R_kgDOJkcZtQ"
      category="General"
      category-id="DIC_kwDOJkcZtc4CWrIX"
      mapping="title"
      strict="0"
      reactions-enabled="1"
      emit-metadata="0"
      input-position="bottom"
      :theme="theme.isDark ? 'dark' : 'light'"
      lang="ko"
      loading="lazy"
    />
  </div>
</template>

<style scoped>
.giscus-wrap {
  padding: 30px 0;
}
</style>
