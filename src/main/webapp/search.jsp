<%--
  Created by IntelliJ IDEA.
  User: khai trinh
  Date: 22/02/2021
  Time: 12:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>NHẤC CHÂN LÊN</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
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
    <div class="col-sm-3">
        <div class="card bg-light mb-3">
            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i>CATEGORIES</div>
            <ul class="list-group category_block">
                <c:forEach items="${categoryList}" var="cate">
                    <li class="list-group-item text-white"><a href="/category?cate_id=${cate.cate_id}">${cate.cate_name}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="col-sm-9">
        <div class="row">
            <c:forEach items="${listFindByName}" var="p">
                <div class="col">
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="${p.image}" alt="Card image cap" width="300" height="300">
                        <div class="card-body">
                            <h5 class="card-title">${p.name}</h5>
                            <p class="card-text">${p.price}$</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Mô tả: ${p.description}</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Chi tiết</a>
                            <a href="#" class="card-link">Thêm vào giỏ</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>
