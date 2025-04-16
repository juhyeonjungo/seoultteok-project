<template>
  <div class="product-grid">
    <div v-for="product in filteredProducts" :key="product.productId" class="card">
      <img :src="product.imageUrl" class="card-img" />
      <div class="card-body">
        <h3>{{ product.name }}</h3>
        <p>{{ product.retailPrice.toLocaleString() }}원</p>
        <button @click="addToCart(product)">장바구니</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useProductStore } from '~/stores/products'
import { useCartStore } from '~/stores/cart'
import { computed, onMounted } from 'vue'

const props = defineProps({
  filterCategory: [String, Array]
})

const productStore = useProductStore()
const cartStore = useCartStore()

onMounted(async () => {
  if (productStore.products.length === 0) {
    await productStore.loadProducts()
  }
})

const filteredProducts = computed(() => {
  if (!props.filterCategory) return productStore.products

  if (Array.isArray(props.filterCategory)) {
    return productStore.products.filter(p =>
      props.filterCategory.includes(p.category)
    )
  }

  return productStore.products.filter(p => p.category === props.filterCategory)
})

function addToCart(product) {
  
  cartStore.addToCart(product)
  
}
</script>

<style scoped>
.product-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 24px;
  padding: 20px;
}
.card {
  background: white;
  border-radius: 14px;
  box-shadow: 0 4px 14px rgba(0, 0, 0, 0.08);
  overflow: hidden;
}
.card-img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}
.card-body {
  padding: 16px;
}
</style>
