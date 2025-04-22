<template>
  <v-container>
    <h2 class="text-h5 font-weight-bold mb-4">📦 주문 전체 관리</h2>

    <v-data-table :items="orders" :headers="headers" class="elevation-1">
      <!-- 상태 변경 -->
      <template #item.status="{ item }">
        <v-select
          :items="['주문완료', '배송중', '배송완료']"
          v-model="item.status"
          density="compact"
           @update:modelValue="changeStatus(item.orderId, item.status)"
        />
      </template>

      <!-- 상품 목록 -->
      <template #item.orderItems="{ item }">
        <div v-for="(prod, idx) in item.orderItems" :key="idx">
          • {{ prod.name }} ({{ prod.quantity }}개)
        </div>
      </template>
    </v-data-table>
  </v-container>
</template>

<script setup>
import { onMounted, computed } from 'vue'
import { useOrderAdminStore } from '@/stores/orderadmin'

const store = useOrderAdminStore()
const orders = computed(() => store.orders)

onMounted(async () => {
  console.log("📦 관리자 주문 데이터 로딩")
  await store.loadOrders()
})

async function changeStatus(orderId, status) {
  await store.changeStatus(orderId, status)
}

// ✅ headers 정의 추가
const headers = [
  { title: '주문번호', key: 'orderId' },
  { title: '주문자', key: 'email' },
  { title: '수령인', key: 'receiverName' },
  { title: '연락처', key: 'receiverPhone' },
  { title: '주소', key: 'receiverAddress' },
  { title: '상품 목록', key: 'orderItems' },  // ✅ 이 key와 template도 맞춰야 함
  { title: '상태 변경', key: 'status' },
]
</script>
