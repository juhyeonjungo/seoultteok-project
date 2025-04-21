<template>
  <v-app>
    <Header />
    <Gnb />
    <Banner v-if="route.path === '/'" />
    <ProductSilder v-if="route.path === '/'"/>
    <IntroParallax v-if="route.path === '/'" />
    <NuxtPage />
    <Footer />
  </v-app>
</template>

<script setup>
import Header from '~/components/Header.vue'
import Gnb from '~/components/Gnb.vue'
import Footer from '~/components/Footer.vue'
import Banner from '~/components/Banner.vue'
import ProductSilder from '~/components/ProductSilder.vue'
import IntroParallax from '~/components/IntroParallax.vue'

const route = useRoute()
</script>

<style scoped>
/* 필요하면 Vuetify 컴포넌트와 함께 조화롭게 조절 */
</style>
