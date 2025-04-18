<template>
  <div class="container">
    <h1>🛒 장바구니</h1>

    <div v-if="cartItems.length === 0">
      <p>장바구니가 비어있습니다.</p>
    </div>

    <div v-else class="cart-list">
      <div v-for="item in cartItems" :key="item.cartItemId" class="cart-item">
        <img :src="item.image" class="thumb" />
        <div class="info">
          <h3>{{ item.name }}</h3>
          <p>{{ item.price.toLocaleString() }}원</p>
          <input
            type="number"
            v-model.number="item.quantity"
            min="1"
            @change="changeQuantity(item.cartItemId, item.quantity)"
          />
          <button @click="remove(item.cartItemId)">삭제</button>
        </div>
      </div>

      <hr />
      <div class="summary">
        <p>총 상품 수: {{ totalCount }}개</p>
        <p>총 금액: {{ totalPrice.toLocaleString() }}원</p>
        <button @click="checkout">주문하기</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useCartStore } from '~/stores/cart'
import { computed } from 'vue'
import { onMounted } from 'vue'
import { useUserStore } from '~/stores/user'

const userStore = useUserStore()
const cartStore = useCartStore()

const cartItems = computed(() => cartStore.items)
const totalPrice = computed(() => cartStore.totalPrice)
const totalCount = computed(() => cartStore.totalCount)


onMounted(async () => {
  console.log("✅ 현재 로그인 이메일:", userStore.userEmail)
  if (userStore.userEmail) {
    await cartStore.fetchCart(userStore.userEmail)
  }
})

function changeQuantity(cartItemId, quantity) {
  cartStore.updateQuantity(cartItemId, quantity)
}

function remove(cartItemId) {
  cartStore.removeFromCart(cartItemId)
}

function checkout() {
  alert('🚨 결제기능은 아직 미구현입니다!')
}
</script>

  
  <style scoped>
  .container {
    max-width: 700px;
    margin: auto;
    padding: 20px;
  }
  .cart-item {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
  }
  .thumb {
    width: 100px;
    height: 100px;
    object-fit: cover;
    margin-right: 16px;
  }
  .info {
    flex: 1;
  }
  .summary {
    text-align: right;
    margin-top: 20px;
  }
  </style>
  