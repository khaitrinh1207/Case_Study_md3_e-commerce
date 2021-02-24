<%--
  Created by IntelliJ IDEA.
  User: khai trinh
  Date: 24/02/2021
  Time: 9:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>NHẤC CHÂN LÊN</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%-- HEAD --%>
<%--Logo--%>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/">
        <img src="https://giayoi.com/wp-content/uploads/2020/08/running-shoe-icon-300x300.png" width="45" height="45"
             class="d-inline-block align-top" alt="">
        Nhấc Chân Lên
    </a>

    <form class="form-inline my-2 my-lg-0" action="?action=search" method="post">
        <input class="form-control mr-sm-2" type="search" name="nameSearch" placeholder="Search"
               aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>
<div class="row" style="height: 100px">
    <div class="col-4">

    </div>
    <div class="col-6" style="text-align: center; font-size: x-large">
        <div class="row">
            <div class="col-2">
                <a href="/">Home</a>
            </div>
            <div class="col-4">
                <a href="#">Tài khoản</a>
            </div>
            <div class="col-2">
                <a href="#">Giỏ hàng</a>
            </div>
        </div>
    </div>
</div>

<%--contents--%>
<div class="row">
    <div class="col">

    </div>
    <div class="col-10">
        <div class="row" style="text-align: center; margin-left: 30px">
            <h3>Chi tiết sản phẩm</h3>
        </div>
        <div class="row">
            <div class="col-4">
                <img src="${shoeDetail.image}" width="250" height="300"/>
            </div>
            <div class="col-8">
                <h4 style="color: red">${shoeDetail.name}</h4>
                <h5>Thương hiệu: <i><b style="color: darkblue">${trademark}</b></i></h5>
                <h5>Mô tả: <i>${shoeDetail.description}</i></h5>
                <h6>Price:  <b>${shoeDetail.price}$</b></h6>
                <h6>đơn vị tính : đôi</h6>
                <h6>Size: <input type="number" name="size" min="38" max="43" value="41"></h6>
                <h6>Số lượng: <input type="number" name="amount" min="1" max="999" value="1"></h6>
                <a href="#" style="font-size: xx-large"><u>Thêm vào giỏ</u></a>
            </div>
        </div>
    </div>
</div>


</body>
</html>
