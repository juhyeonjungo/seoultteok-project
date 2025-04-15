<template>
    <footer class="footer">
      <div class="container">
        <div class="info-grid">
          <div>
            <h3>고객센터</h3>
            <p>문의: 010-4841-4470</p>
            <p>운영시간: 09:00~19:00 (매주)</p>
          </div>
          <div>
            <h3>입금계좌</h3>
            <p>농협 351-0000-0000-00</p>
            <p>예금주: 서울떡집</p>
          </div>
          <div>
            <h3>공지사항</h3>
            <p>※ 모든 떡은 수제로 당일 제작됩니다.</p>
            <p>※ 배송은 지역에 따라 조율됩니다.</p>
          </div>
        </div>
        <div class="copyright">
          &copy; 2025 서울떡집. All rights reserved.
        </div>
      </div>
    </footer>
  </template>
  
  <style scoped>
  .footer {
    background-color: #f2e9dc;
    padding: 40px 20px 20px;
    border-top: 1px solid #d6cfc1;
    color: #4d4033;
    font-size: 14px;
  }
  
  .container {
    max-width: 1200px;
    margin: auto;
  }
  
  .info-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
    gap: 32px;
    margin-bottom: 24px;
  }
  
  .info-grid h3 {
    font-size: 16px;
    font-weight: bold;
    margin-bottom: 8px;
    color: #3a2d2d;
  }
  
  .info-grid p {
    margin: 4px 0;
  }
  
  copyright {
    text-align: center;
    font-size: 12px;
    color: #8b7b65;
  }
  </style>
  