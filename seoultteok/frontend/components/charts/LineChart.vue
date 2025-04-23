<template>
  <Line :data="chartData" :options="chartOptions" />
</template>

<script setup>
import { computed } from 'vue'
import { Line } from 'vue-chartjs'
import {
  Chart as ChartJS,
  Title, Tooltip, Legend,
  LineElement, CategoryScale,
  LinearScale, PointElement
} from 'chart.js'

// Chart.js 설정
ChartJS.register(Title, Tooltip, Legend, LineElement, CategoryScale, LinearScale, PointElement)

// props 정의
const props = defineProps({
  labels: {
    type: Array,
    default: () => []
  },
  data: {
    type: Array,
    default: () => []
  }
})

// ✅ 반응형으로 처리해야 동작함
const chartData = computed(() => ({
  labels: props.labels,
  datasets: [
    {
      label: '매출액',
      data: props.data,
      fill: false,
      borderColor: '#42A5F5',
      tension: 0.4
    }
  ]
}))

const chartOptions = {
  responsive: true,
  plugins: {
    legend: {
      display: true
    }
  }
}
</script>
