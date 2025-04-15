<template>
  <section class="best-section">
    <div class="container">
      <h2 class="title"><span class="brand">서울떡집</span> <span class="highlight">베스트</span></h2>
      <div class="grid">
        <div
          v-for="product in bestProducts"
          :key="product.id"
          class="card"
        >
          <img :src="product.image" :alt="product.name" class="card-img" />
          <div class="card-body">
            <h4 class="desc">{{ product.commentTitle }}</h4>
            <p class="desc-sub">{{ product.commentText }}</p>
            <h3 class="name">{{ product.name }}</h3>
            <p class="price">{{ product.price.toLocaleString() }}원</p>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import { useProductStore } from '@/stores/products'

const productStore = useProductStore()

// 🔥 베스트 3개만 지정
const bestProducts = [
  {
    ...productStore.products.find(p => p.name === '꿀떡'),
    commentTitle: '단 게 땡긴다면?',
    commentText: '달콤한 꿀과 촉촉한 식감의 꿀떡 추천!',
  },
  {
    ...productStore.products.find(p => p.name === '쑥땅콩모찌'),
    commentTitle: '고소한 간식이 필요하다면?',
    commentText: '쑥의 향과 땅콩의 고소함이 가득한 쑥모찌!',
  },
  {
    ...productStore.products.find(p => p.name === '영양모듬떡'),
    commentTitle: '든든한 한 끼로도 좋아요!',
    commentText: '영양 가득한 모듬떡으로 한 끼 해결!',
  },
]
</script>

<style scoped>
.best-section {
  background-color: #fffaf4;
  padding: 60px 20px;
}
.container {
  max-width: 1200px;
  margin: auto;
  text-align: center;
}
.title {
  font-size: 24px;
  margin-bottom: 32px;
  color: #3b2f2f;
}
.title .brand {
  color: #b08968;
}
.title .highlight {
  color: #6f4e37;
  font-weight: 800;
}
.grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
  gap: 32px;
}
.card {
  background: #fff;
  border-radius: 14px;
  box-shadow: 0 6px 20px rgba(0, 0, 0, 0.06);
  overflow: hidden;
  transition: transform 0.3s;
}
.card:hover {
  transform: translateY(-5px);
}
.card-img {
  width: 100%;
  height: 240px;
  object-fit: cover;
}
.card-body {
  padding: 20px;
}
.desc {
  font-weight: 700;
  font-size: 16px;
  color: #9a5a3c;
  margin-bottom: 6px;
}
.desc-sub {
  font-size: 14px;
  color: #6e6e6e;
  margin-bottom: 16px;
}
.name {
  font-size: 18px;
  font-weight: 800;
  margin-bottom: 6px;
}
.price {
  font-size: 16px;
  color: #3a3a3a;
}
</style>
