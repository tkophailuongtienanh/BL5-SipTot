<%-- 
    Document   : profile
    Created on : Oct 30, 2021, 2:36:30 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="css/buttonScrollToTop.js"></script>
        <link rel="stylesheet" type="text/css" href="css/navcss.css" />
        <link rel="stylesheet" type="text/css" href="css/scrollButton.css" />
        <style>
            footer{
                margin-top: 20px;
                background-color: rgba(39, 39, 39, 1);
                height: 50vh;
                width: 100%;
            }
            .content-footer{
                width: 80vw;
                margin: auto;
            }
            body {
                margin: 0;
                padding: 0;
                background-image: url("images/page/banner/back.jpg");
                min-height: 100vh;
                width: 100%
            }.content{
                min-height: 50vh;
                width: 80vw;
                margin: auto;
                margin-top: 10vh;
                background: rgba(255, 255, 255, 1) ;
            }
            .content h1{
                text-align: center;
            }
            .tab{
                margin-top: 50px;
                display: inline-block;
                width: 25%;
                float: left;
                border: 3px;
                border-color: grey; 
            }
            .tab a{
                display: block;
                color: black;
                font-size: 22px;
                padding: 8px 16px;
                text-decoration: none;
                background-color: white;
            }
            .tab a:hover:not(.active) {
                background-color: rgba(255, 101, 195, 0.6);
            }.tab a.active {
                background-color: rgb(255, 101, 195);
                color: white;
            }
            table.infomation{
                border-left: 1px;
                border-left-color: black;
                padding-left: 250px;
                font-size: 200%;
            }
            table.infomation th{
                text-align: left;
                padding-right: 100px;
            }
            a.edit{
                margin-right: 20px;
                float: right;
                text-decoration: none;
                color: black;
                border: 1px solid black;
                padding: 5px 10px 5px 10px;
                border-radius: 10px;
                background-color: lightgrey;
            }
            table.product-buyed{
                width: 99%;
                border-collapse: collapse;
                margin-bottom: 50px;
            }
             tr.head-table th{ 
                background-color: rgba(255, 101, 195, 1);
                height: 30px;
                padding: 0;
            }
            table.product-buyed tr{
  margin-bottom: 20px;
            }
            table.product-buyed tr.head-table :first-child{
                border-radius: 15px 0 0 15px; 
                overflow: hidden;
            }table.product-buyed tr.head-table :last-child{
                border-radius:  0 15px 15px 0; 
                overflow: hidden;
            }
            table.product-buyed tr td{ 
                border: 1px solid black ;
            }
            div.scroll{
                height: 80vh;
                overflow: scroll;
            }
        </style>
    </head>

    <nav id="navbar">
        <div class="content-header">
            <div class="nav-left">
                <div class="logo">
                    <a href="homepage"><img id="homelogo" src="images\page\icons\homelogo.png"/></a>
                </div>
                <ul>
                    <li><a href="list?cid=AL">Áo lót</a>
                        <ul>
                            <c:forEach items="${sessionScope.subal}" var="i">
                                <li><a href="list?cid=${i.catID}&scid=${i.subCatID}">${i.subCatName}</a></li>
                                </c:forEach>
                        </ul>
                    </li>
                    <li><a href="list?cid=QL">Quần lót</a>
                        <ul>
                            <c:forEach items="${sessionScope.subql}" var="i">
                                <li><a href="list?cid=${i.catID}&scid=${i.subCatID}">${i.subCatName}</a></li>
                                </c:forEach>
                        </ul>
                    </li>
                    <li><a href="list?cid=1S">Theo bộ</a>
                        <ul>
                            <c:forEach items="${sessionScope.sub1s}" var="i">
                                <li><a href="list?cid=${i.catID}&scid=${i.subCatID}">${i.subCatName}</a></li>
                                </c:forEach>
                        </ul>
                    </li>
                    <li><a href="list?cid=DN">Đồ ngủ</a>
                        <ul>
                            <c:forEach items="${sessionScope.subdn}" var="i">
                                <li><a href="list?cid=${i.catID}&scid=${i.subCatID}">${i.subCatName}</a></li>
                                </c:forEach>
                        </ul>
                    </li>
                    <li><a href="list?cid=BB">Đồ bầu</a>
                        <ul>
                            <c:forEach items="${sessionScope.subbb}" var="i">
                                <li><a href="list?cid=${i.catID}&scid=${i.subCatID}">${i.subCatName}</a></li>
                                </c:forEach>
                        </ul>
                    </li>
                </ul>
                <span>
                    <form action="list"  accept-charset="utf-8">
                        <input type="text" placeholder="Tìm sản phẩm" name="name" onsubmit="this.form.submit()">
                        <button onclick="this.form.submit()"><img src="images\page\icons\search.png" ></button>
                    </form>
                </span>
            </div>
            <div class="nav-right">
                <div class="logo" id="wishlistlogo">
                    <a href="wishes"><img src="images\page\icons\wish.png"><c:if test="${sessionScope.wsize >0}"><span class="wsize">${sessionScope.wsize}</span></c:if></a>
                </div>
                <div class="logo" id="cartlogo">
                    <a href="cart"><img src="images\page\icons\cart.png"><c:if test="${sessionScope.csize >0}"><span class="csize">${sessionScope.csize}</span></c:if></a>
                </div>
                <div class="logo" id="accountlogo">
                    <a href="profile"><img src="images\page\icons\account.png"></a>
                </div>
            </div>
        </div>
    </nav>
    <body>
        <div class="content">
            <div class="tab">
                <a href="profile?option=1" class="${option==1?('active'):('')}">Thông tin cá nhân</a>
                <a href="profile?option=2" class="${opt==2?('active'):('')}" >Lịch sử mua hàng </a> 
                <a href="logout">Đăng xuất</a>
            </div>
            <div class="info">
                <c:if test="${requestScope.info=='info'}">
                    <h1>Thông tin của bạn</h1>
                    <c:set var="info" value="${requestScope.profile}"/>
                    <table class="infomation">
                        <tr>
                            <th>Họ và Tên:</th>
                            <td>${info.name}</td>
                        </tr>
                        <tr>
                            <th>Ngày sinh:</th>
                            <td>${info.dob}</td>
                        </tr>
                        <tr>
                            <th>Số điện thoại:</th>
                            <td>${info.phoneNumber}</td>
                        </tr>
                        <tr>
                            <th>Địa chỉ:</th>
                            <td>${info.address}</td>
                        </tr>
                    </table>
                    <a class="edit" href="fixprofile?username=${info.username}" >Chỉnh sửa</a>
                </c:if>
                <c:if test="${requestScope.info=='buyed'}">
                    <div class="scroll">
                        <h1>Các sản phẩm đã mua</h1>
                        <table class="product-buyed">
                            <tr class="head-table">
                                <th>Ảnh</th>
                                <th>Tên sản phẩm</th>
                                <th>Giá</th>
                                <th>Đã mua</th>
                            </tr>
                            <c:forEach items="${requestScope.plist}" var="p">
                                <tr onclick="">
                                    <td><img src="${p.path}" width="80px"  height="80px"/></td>
                                    <td>${p.productName}</td>
                                    <td>${p.price}₫</td>
                                    <td>${p.quantity}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
            </div>
        </div>
    </body>
    <div onclick="topFunction()" id="myBtn" title="lên đỉnh nè">
        <img class="fas fa-arrow-up" src="images/page/arrowUp.jpg"/>
    </div>
    <footer>
        <div class="content-footer">
            wertyuiop[
        </div>
    </footer>
</html>
