<template>
    <v-container class="py-10">
      <h1 class="text-h5 font-weight-bold mb-6">📦 주문 내역</h1>
  
      <v-expansion-panels>
        <v-expansion-panel
          v-for="order in orders"
          :key="order.orderId"
          elevation="1"
        >
          <!-- 주문 제목 줄 -->
          <v-expansion-panel-title class="bg-brown-50 font-weight-bold">
            <v-row class="w-100">
              <v-col cols="2">#{{ order.orderId }}</v-col>
              <v-col cols="4">{{ order.orderDate }}</v-col>
              <v-col cols="3">{{ order.totalPrice.toLocaleString() }}원</v-col>
              <v-col cols="3">{{ order.status }}</v-col>
            </v-row>
          </v-expansion-panel-title>
  
          <!-- 펼쳐졌을 때 나오는 상세 상품 내역 -->
          <v-expansion-panel-text class="bg-grey-lighten-5">
            <v-row
              v-for="item in order.items"
              :key="item.productId"
              class="mb-4 px-2"
            >
              <v-col cols="2">
                <v-img
                  :src="item.imageUrl"
                  height="80"
                  width="80"
                  cover
                  class="rounded"
                />
              </v-col>
              <v-col cols="6">
                <div class="font-weight-medium">{{ item.name }}</div>
                <div>단가: {{ item.price.toLocaleString() }}원</div>
                <div>수량: {{ item.quantity }}개</div>
              </v-col>
              <v-col cols="4" class="text-right">
                <div class="font-weight-bold">
                  합계: {{ (item.price * item.quantity).toLocaleString() }}원
                </div>
              </v-col>
            </v-row>
          </v-expansion-panel-text>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-container>
  </template>
  
  <script setup>
  import { onMounted } from 'vue'
  import { useUserStore } from '~/stores/user'
  import { useOrderStore } from '~/stores/order'
  import { storeToRefs } from 'pinia'
  
  const userStore = useUserStore()
  const orderStore = useOrderStore()
  const { orders } = storeToRefs(orderStore)
  
  onMounted(() => {
    orderStore.fetchOrders(userStore.userEmail)
  })
  </script>
  