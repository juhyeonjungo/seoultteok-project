<template>
    <div>
      <Header />
      <Gnb />
      <Banner v-if="route.path === '/'" />
      <slot />
      <IntroParallax v-if="route.path === '/'" />
      <Footer />
    </div>
  </template>
  
  <script setup>
  import Header from '~/components/Header.vue'
  import Gnb from '~/components/Gnb.vue'
  import Footer from '~/components/Footer.vue'
  import Banner from '~/components/Banner.vue'

  const route = useRoute();
  </script>
  
  <style scoped>
  /* 기본적인 레이아웃 스타일 */
  </style>