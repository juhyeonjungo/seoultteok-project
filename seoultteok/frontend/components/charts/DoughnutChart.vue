<template>
    <Doughnut :data="chartData" :options="chartOptions" />
  </template>
  
  <script setup>
  import { computed } from 'vue'
  import { Doughnut } from 'vue-chartjs'
  import {
    Chart as ChartJS, Title, Tooltip, Legend, ArcElement
  } from 'chart.js'
  
  ChartJS.register(Title, Tooltip, Legend, ArcElement)
  
  const props = defineProps({
    labels: { type: Array, default: () => [] },
    data: { type: Array, default: () => [] }
  })
  
  const chartData = computed(() => ({
    labels: props.labels,
    datasets: [
      {
        label: '카테고리 매출 비율',
        data: props.data,
        backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56', '#8E44AD', '#2ECC71']
      }
    ]
  }))
  
  const chartOptions = {
    responsive: true,
    plugins: {
      legend: {
        position: 'bottom'
      }
    }
  }
  </script>
  