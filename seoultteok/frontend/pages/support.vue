<template>
    <div class="about-page">
      <h1>서울떡집 소개</h1>
  
      <p class="intro">
        서울떡집은 정성과 손맛으로 매일 떡을 빚는 <strong>전통 떡 전문점</strong>입니다.<br>
        따뜻한 손길이 담긴 떡 한 조각으로, 고객 한 분 한 분과 마음을 나누고 싶습니다.
      </p>
  
      <div class="gallery">
        <img src="/images/ext.png" alt="서울떡집 외관" />
        <img src="/images/mom.png" alt="떡집 주인" />
        <img src="/images/dd.png" alt="진열된 떡" />
        <img src="/images/anok.png" alt="앙금 만드는 과정" />
      </div>
  
      <p class="desc">
        📌 행사/답례용 <strong>백설기, 수수팥떡, 모둠떡</strong>부터,<br>
        🥄 정성껏 만든 <strong>앙금떡, 모찌, 인절미</strong>까지!<br><br>
        서울떡집은 오늘도 아침부터 팥을 볶고, 떡을 찝니다.  
      </p>
    </div>
  </template>
  
  <style scoped>
  .about-page {
    max-width: 1000px;
    margin: auto;
    padding: 40px 20px;
    text-align: center;
  }
  .intro {
    font-size: 20px;
    margin-bottom: 32px;
    color: #5a4634;
  }
  .gallery {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 16px;
  }
  .gallery img {
    width: 45%;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  }
  .desc {
    margin-top: 40px;
    font-size: 18px;
    line-height: 1.6;
    color: #6e5c4e;
  }
  </style>
  