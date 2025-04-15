<template>
    <section class="parallax-section">
      <div class="overlay">
       
        <p class="text">
            서울떡집은 1993년 창립 이래 전통의 맛을 지켜오며,<br />
            정성과 기술로 누구나 안심하고 즐길 수 있는 떡을 만들어왔습니다.<br />
            앞으로도 늘 한결같은 마음으로 최고의 떡을 정성껏 빚겠습니다.
        </p>
      </div>
    </section>
  </template>
  
  <style scoped>
  .parallax-section {
    background-image: url('/images/parallaxtteok.jpg'); /* ← 배경 이미지 경로 */
    background-size: cover;
    background-attachment: fixed;
    background-position: center;
    background-repeat: no-repeat;
    height: 500px;
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .overlay {
    text-align: center;
    color: #fff;
    text-shadow: 0 2px 6px rgba(0, 0, 0, 0.5);
  }
  
  .emblem {
    width: 64px;
    margin-bottom: 16px;
  }
  
  .text {
    font-size: 20px;
    line-height: 1.8;
    font-weight: 500;
    color: #ffffff;
  font-weight: 600;
  font-size: 20px;
  text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.7);
  line-height: 1.8;
  text-align: center;
  }
  </style>
  