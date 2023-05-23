<script setup>
import { useChangeTheme } from '@/stores/theme';
import { useResponsive } from '@/stores/windowSize';
import { onMounted, ref } from 'vue';
const theme = useChangeTheme();
const responsive = useResponsive();

const mounted = ref(false);
onMounted(() => {
  mounted.value = true;
  import('giscus');
});
</script>

<template>
  <div class="giscus-wrap" v-if="!responsive.isMobile">
    <giscus-widget
      v-if="mounted"
      id="comments"
      repo="Jiyun-Parkk/woorifisa-fe-tech-seminar"
      repoid="R_kgDOJkcZtQ"
      category="General"
      categoryid="DIC_kwDOJkcZtc4CWrIX"
      mapping="pathname"
      strict="0"
      reactionsenabled="1"
      emitmetadata="0"
      inputposition="top"
      :theme="theme.isDark ? 'dark' : 'light'"
      lang="ko"
    />
  </div>
</template>

<style scoped>
.giscus-wrap {
  padding: 30px 0;
}
</style>
