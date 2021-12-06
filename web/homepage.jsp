<%-- 
    Document   : homepage
    Created on : Oct 24, 2021, 2:02:14 AM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link rel="stylesheet" type="text/css" href="css/paging.css" />--> 
        <script src="css/buttonScrollToTop.js"></script>
        <link rel="stylesheet" type="text/css" href="css/navcss.css" />
        <link rel="stylesheet" type="text/css" href="css/productViewer.css" />
        <link rel="stylesheet" type="text/css" href="css/scrollButton.css" />
        <style>
            .section h1{
                color: rgba(39, 39, 39, 1);
            }
            .section .more{
                width: 100px;
                display: block;
                text-align: center;
                margin: auto;
                padding: 5px;
                border: 1px solid black;
                text-decoration: none;
                color: black;
                background-color:  rgba(255, 255, 255, 1); 
                border-radius: 10px;
            }
            .content{
                width: 80vw;
                margin: auto;
                margin-top: 10vh;
                background: rgba(255, 255, 255, 0.6) ;
            }
            .content-footer{
                width: 80vw;
                margin: auto;
            }
            h1{
                text-align: center;
                color: blue;
            }
            body {
                margin: 0;
                padding: 0;
                background-image: url("images/page/banner/back.jpg");
                min-height: 100vh;
                width: 100%
            }
            footer{
                margin-top: 20px;
                background-color: rgba(39, 39, 39, 1);
                height: 50vh;
                width: 100%;
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
            <div class="section">
                <h1>Sản phẩm mới nhất</h1>
                <c:forEach items="${requestScope.dataOfLatest}" var="p">
                    <a class="product" href="productview?pid=${p.productID}" >
                        <div class="ava"><img src="${p.path}"/></div>
                        <div class="pname">${p.productName}</div>
                        <hr>
                        <div class="pprice">${p.price}₫</div>
                    </a>
                </c:forEach>
                <a class="more" href="list?odb=1">Xem thêm ></a>
            </div>
            <div class="section">
                <h1>Sản phẩm xu hướng</h1>
                <c:forEach items="${requestScope.dataOfTrending}" var="p">
                    <a class="product" href="productview?pid=${p.productID}">
                        <div class="ava"><img src="${p.path}"/></div>
                        <div class="pname">${p.productName}</div>
                        <hr>
                        <div class="pprice">${p.price}₫</div>
                    </a>
                </c:forEach>
                <a class="more" href="list?odb=1">Xem thêm ></a>
            </div>
            <div class="section">
                <h1>Sản phẩm được yêu thích</h1>
                <c:forEach items="${requestScope.dataOfFavourite}" var="p">
                    <a class="product" href="productview?pid=${p.productID}">
                        <div class="ava"><img src="${p.path}"/></div>
                        <div class="pname">${p.productName}</div>
                        <hr>
                        <div class="pprice">${p.price}₫</div>
                    </a>
                </c:forEach>
                <a class="more" href="list?odb=1">Xem thêm ></a>
            </div>
            <div onclick="topFunction()" id="myBtn" title="lên đỉnh nè">
                <img class="fas fa-arrow-up" src="images/page/arrowUp.jpg"/>
            </div>
        </div>
    </body>
    <footer>
        <div class="content-footer">
            wertyuiop[
        </div>
    </footer>
</html>
