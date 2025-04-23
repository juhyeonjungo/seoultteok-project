<template>
  <div class="sales-dashboard">
    <h1>매출 대시보드</h1>

    <div class="card">🧾 총 매출액: {{ totalRevenue.toLocaleString() }}원</div>

    <!-- ✅ Vuetify 스타일 기간 선택 -->
    <v-select
      v-model="selectedPeriod"
      :items="periodItems"
      label="기간 선택"
      variant="outlined"
      class="w-48 mb-6"
      @update:modelValue="loadSales"
    />

    <!-- ✅ 매출 추이 차트 -->
    <div class="chart">
      <h3>📈 {{ periodTitle }} 매출 추이</h3>
      <LineChart :labels="lineLabels" :data="lineData" style="width: 70%; height: 400px;"/>
    </div>

    <!-- 상품별 매출 순위 -->
    <div class="chart">
      <h3>🛒 상품별 매출 순위</h3>
      <BarChart :labels="productNames" :data="productSales"  style="width: 70%; height: 400px;"/>
    </div>

    <!-- 카테고리별 매출 비중 -->
    <div class="chart">
      <h3>📊 카테고리별 매출 비중</h3>
      <DoughnutChart :labels="categoryNames" :data="categorySales" style="width: 60%; height: 400px;" />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from 'vue'
import { useSalesApi } from '~/api/saleadminapi'
import LineChart from '@/components/charts/LineChart.vue'
import BarChart from '@/components/charts/BarChart.vue'
import DoughnutChart from '@/components/charts/DoughnutChart.vue'

const selectedPeriod = ref('daily')
const periodItems = ['daily', 'monthly', 'yearly']

const totalRevenue = ref(0)
const lineLabels = ref([])
const lineData = ref([])
const productNames = ref([])
const productSales = ref([])
const categoryNames = ref([])
const categorySales = ref([])

const { fetchSalesData } = useSalesApi()

const periodTitle = computed(() => {
  return selectedPeriod.value === 'daily' ? '일별'
    : selectedPeriod.value === 'monthly' ? '월별'
    : '연도별'
})

const loadSales = async () => {
  const data = await fetchSalesData(selectedPeriod.value)
  totalRevenue.value = data.totalRevenue
  lineLabels.value = data.periodLabels
  lineData.value = data.periodValues
  productNames.value = data.productLabels
  productSales.value = data.productValues
  categoryNames.value = data.categoryLabels
  categorySales.value = data.categoryValues
}

onMounted(loadSales)
</script>

<style scoped>
.sales-dashboard {
  max-width: 1000px;
  margin: auto;
  padding: 40px;
}
.card {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 24px;
}
.chart {
  
  
 
  
  justify-content: center;
}
</style>
