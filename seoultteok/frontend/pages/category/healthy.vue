<template>
  <section class="healthy-page">
    <div class="container">
      <h1 class="title">건강 떡</h1>
      <p class="desc">영양 가득한 건강 떡으로 든든하게 챙기세요.</p>

      <div class="grid">
        <div
          v-for="product in healthyProducts"
          :key="product.productId"
          class="card"
        >
          <img :src="product.imageUrl" :alt="product.name" class="card-img" />
          <div class="card-body">
            <button class="add-btn" @click="addToCart(product)"> 담기</button>
            <h3 class="name">{{ product.name }}</h3>
            <p class="price">{{ product.retailPrice.toLocaleString() }}원</p>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import { useProductStore } from '~/stores/products'
import { useCartStore } from '~/stores/cart'
import { computed, onMounted } from 'vue'

const productStore = useProductStore()
const cartStore = useCartStore()

onMounted(() => {
  productStore.loadProducts()
})

const healthyProducts = computed(() =>
  productStore.products.filter(p => p.category === '건강 떡')
)

function addToCart(product) {
  cartStore.addToCart(product)
}
</script>


<style scoped>
.healthy-page {
  padding: 60px 20px;
  background-color: #fffaf4;
}
.container {
  max-width: 1200px;
  margin: auto;
  text-align: center;
}
.title {
  font-size: 28px;
  font-weight: bold;
  margin-bottom: 16px;
}
.grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 24px;
  max-width: 1000px;
  margin: 0 auto;
}

.card {
  width: 280px;
  background: white;
  border-radius: 14px;
  box-shadow: 0 4px 14px rgba(0, 0, 0, 0.08);
  overflow: hidden;
  transition: transform 0.2s;
}
.card:hover {
  transform: translateY(-4px);
}

.card-img {
  width: 100%;
  height: 180px;
  object-fit: cover;
  border-bottom: 1px solid #eee;
}

.card-body {
  padding: 16px;
}
.name {
  font-weight: 700;
  margin-bottom: 6px;
}
.price {
  color: #333;
}
.add-btn {
  margin-top: auto;
  background-color: #d38852;
  color: white;
  border: none;
  padding: 10px 14px;
  border-radius: 8px;
  font-weight: bold;
  transition: 0.2s;
}
.add-btn:hover {
  background-color: #bb6e3d;
}
</style>
