<%-- 
    Document   : fixprofile
    Created on : Oct 30, 2021, 3:39:30 PM
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
            h1{
                text-align: center;
                padding-bottom: 50px;
            }
            table{
                width: 100%;
                margin: auto;
                border-spacing: 10px;
            }
            form .button{
                display: inline-block;
                margin-left: 50%; 
            }
            form.update{
                width: 50%;
                margin: auto;
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
            <form class="update" action="fixprofile" method="post">
                <c:set var="info" value="${requestScope.info}"/>
                <h1>Cập nhật thông tin của bạn</h1>
                <table><tr>
                        <th>Username:</th>
                        <td> <input type="text" readonly name="username" value="${info.username}"/></td>
                    </tr>
                    <tr>
                        <th>Họ và Tên:</th>
                        <td> <input type="text" name="name" value="${info.name}"/></td>
                    </tr>
                    <tr>
                        <th>Ngày sinh:</th>
                        <td><input type="text" name="dob" value="${info.dob}"/></td>
                    </tr>
                    <tr>
                        <th>Số điện thoại:</th>
                        <td><input type="text" name="phone" value="${info.phoneNumber}"/></td>
                    </tr>
                    <tr>
                        <th>Địa chỉ:</th>
                        <td><input type="text" name="address" value="${info.address}"/></td>
                    </tr>
                </table>
                    <input class="button" type="submit" value="Xong"/>
            </form>
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
