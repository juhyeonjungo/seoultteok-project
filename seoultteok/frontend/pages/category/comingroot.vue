<!-- pages/category/comingroot.vue -->
<template>
    <section class="map-section">
      <div class="container">
        <h1 class="title">오시는 길</h1>
        <p class="desc">경남 통영시 북신시장1길 37 (수협통영지점 근처)</p>
  
        <div class="map-frame">
          <iframe
            src="https://map.kakao.com/link/map/경남 통영시 북신시장1길 34.855636, 128.427848" 
            width="100%"
            height="400"
            frameborder="0"
            style="border:0"
            allowfullscreen
          ></iframe>
        </div>
      </div>
    </section>
  </template>
  
  <style scoped>
  .map-section {
    background-color: #fffaf4;
    padding: 60px 20px;
    text-align: center;
  }
  .container {
    max-width: 800px;
    margin: auto;
  }
  .title {
    font-size: 28px;
    font-weight: bold;
    margin-bottom: 12px;
    color: #333;
  }
  .desc {
    font-size: 16px;
    color: #666;
    margin-bottom: 30px;
  }
  .map-frame {
    border-radius: 12px;
    overflow: hidden;
    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
  }
  </style>
  