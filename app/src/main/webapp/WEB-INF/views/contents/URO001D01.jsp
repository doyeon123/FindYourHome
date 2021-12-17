<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
office detail<br>
sales_registerno;${office.sales_registerno}<br>
sales_businesscode;${office.sales_businesscode}<br>
sales_areacode;${office.sales_areacode}<br>
sales_officename;${office.sales_officename}<br>
sales_telnum;${office.sales_telnum}<br>
sales_postalcode;${office.sales_postalcode}<br>
sales_address;${office.sales_address}<br>
sales_officehours;${office.sales_officehours}<br>
sales_holiday;${office.sales_holiday}<br>
sales_transportation;${office.sales_transportation}<br>
sales_reference;${office.sales_reference}<br>
sales_renewalcontract;${office.sales_renewalcontract}<br>
sales_deleteflag;${office.sales_deleteflag}<br>
sales_registerdate;${office.sales_registerdate}<br>
sales_renewaldate;${office.sales_renewaldate}<br>
sales_img;${office.sales_img}<br>

<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="..." class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="..." class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="..." class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</body>
</html>