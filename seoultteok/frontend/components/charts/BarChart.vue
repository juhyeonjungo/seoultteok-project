<template>
    <Bar :data="chartData" :options="chartOptions" />
  </template>
  
  <script setup>
  import { computed } from 'vue'
  import { Bar } from 'vue-chartjs'
  import {
    Chart as ChartJS, Title, Tooltip, Legend,
    BarElement, CategoryScale, LinearScale
  } from 'chart.js'
  
  ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)
  
  const props = defineProps({
    labels: { type: Array, default: () => [] },
    data: { type: Array, default: () => [] }
  })
  
  const chartData = computed(() => ({
    labels: props.labels,
    datasets: [
      {
        label: '판매 금액',
        data: props.data,
        backgroundColor: '#66BB6A'
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
  