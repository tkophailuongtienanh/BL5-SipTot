<%-- 
    Document   : viewproduct
    Created on : Oct 27, 2021, 9:40:03 PM
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
        <c:set var="p" value="${requestScope.pinfo}"/>
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
                height: 1000px;
            }
            .gallery {
                display: inline-block;
                width: 45%;
                height: 500px;
                padding: 20px;
            }
            .image-selector{
                width: 90%;
                border: 5px solid white;
                cursor: pointer;
            }
            .allimage {
                width: 20%;
                height: 500px;
                display: inline-block;
                float: left;
                overflow: scroll;
                border-spacing: 10px 0 10px 0;
            }
            #image{
                margin: 0;
                padding: 0;
                float: right;
                width: 100%;
                height: 100%;
                object-fit: contain;
                background-image: url(${p.imageList.get(0).path});
                background-repeat: no-repeat;
                background-size: 100%;
            }
            .image-display{
                margin: 0;
                padding: 0;
                width: 80%;
                height: 100%;
                float: right;
                object-fit: contain;
            }
            /* width */
            .gallery ::-webkit-scrollbar {
                width: 2px;
                height: 0px;
            }
            /* Handle */
            .gallery ::-webkit-scrollbar-thumb {
                background: grey; 
                border-radius: 10px;
            }
            .infomation{
                display: inline-block;
                width: 48%;
                height: 450px;
                float: right;
                padding-top: 30px;
            }
            .right-top{
                height: 40%;
                margin: 0;
                padding: 0;
            }
            .right-bottom{
                height: 50%;
                margin: 0;
                padding: 0;
            }
            .pname{
                font-size: 225%;
                line-height: 1em;
                height: 2em;
                text-overflow: ellipsis;
                word-wrap: break-word;
            }
            .pprice{
                font-size: 150%;
            }.pprice span{
                font-size: 150%;
                color: red;
                text-decoration: underline;
            }
            .pcolor p {
                margin: 0;
                margin-bottom: -1em;
                font-size: 125%;
            }
            .pcolor select{
                display: inline-block;
                height: 5em;
                width: 80%;
                border: 0;
                outline: 0;
                overflow: hidden;
            }
            .pcolor select option{
                display: inline-block;
                font-size: 150%;
                padding: 3px 7px 3px 7px;
                border-radius: 1em; 
                border: 5px solid white;
                background: rgba(255, 101, 195, 0.2);
            }
            .psize p {
                margin: 0;
                margin-bottom: -1em;
                font-size: 125%;
            }
            .psize select{
                display: inline-block;
                height: 5em;
                width: 80%;
                border: 0;
                outline: 0;
                overflow: hidden;
            }
            .psize select option{
                display: inline-block;
                font-size: 150%;
                padding: 3px 7px 3px 7px;
                border-radius: 1em; 
                border: 5px solid white;
                background: rgba(255, 101, 195, 0.2);
            }
            .quantity{
                font-size: 125%;
            }
            .quantity input{
                width: 4em;
            }
            .add-favor,.add-cart{
                margin-top: 10px;
                margin-left: 10px;
                text-decoration: none;
                color: black;
                border: 1px solid black;
                padding: 5px 10px 5px 10px;
                border-radius: 10px;
                background-color: rgba(255, 101, 195, 0.5);
            }
            .add-cart{
                padding-top: 5px;
                background-color: lightgrey;
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
            <div class="gallery">
                <div class="allimage">
                    <c:forEach items="${p.imageList}" var="i">
                        <img class="image-selector" src="${i.path}" onclick="upDate(this)" />
                    </c:forEach></div>
                <div class="image-display">
                    <div id="image"></div>
                </div>
            </div>
            <div class="infomation">
                <div class="right-top">
                    <div class="pname">${p.productName}</div><hr>
                    <div class="pprice">Giá: <span>${p.price}₫</span></div>
                </div>
                <div class="right-bottom">
                    <form action="addcart">
                        <div class="pcolor">
                            <p>Chọn màu:</p><br>
                            <select name="color" size="3" required="">
                                <c:forEach items="${p.cllist}" var="i">
                                    <option class="option-color" value="${i.id}" onclick="select(this)">${i.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="psize">
                            <p>Chọn kích cỡ:</p><br>
                            <select name="size" size="3" required="">
                                <c:forEach items="${p.slist}" var="i">
                                    <option class="option-size" value="${i.id}" onclick="select2(this)">${i.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="quantity">
                            <h4 style="color: red" >${requestScope.error}</h4>
                            Số lượng: <input type="number" name="quantity" value="1" min="1" required="">
                        </div>
                        <input type="hidden" value="${p.productID}" name="pid">
                        <p></p>
                        <p></p>
                        <span>
                            <a class="add-favor" href="addwish?pid=${p.productID}">Thêm vào yêu thích</a></span>
                        <span><button type="submit" style="cursor: pointer" class="add-cart">Thêm vào giỏ hàng</button></span>
<!--                        <span><a  onclick="this.form.submit()">Thêm vào giỏ hàng</a></span>-->
                    </form>
                </div>
            </div>
        </div>
        <script>
            function upDate(previewPic) {
                document.getElementById('image').style.backgroundImage = "url(" + previewPic.src + ")";
                var classOne = document.querySelectorAll('.image-selector');
                for (var i = 0; i < classOne.length; i++) {
                    if (classOne[i] !== previewPic) {
                        classOne[i].style.border = "5px solid white";
                    } else {
                        previewPic.style.border = "5px solid rgba(255, 101, 195, 1)";
                    }
                }
            }
            function select(selector) {
                var classOne = document.querySelectorAll('.option-color');
                for (var i = 0; i < classOne.length; i++) {
                    if (classOne[i] !== selector) {
                        classOne[i].style.border = "5px solid white";
                    } else {
                        selector.style.border = "5px solid rgba(255, 101, 195, 1)";
                    }
                }
            }
            function select2(selector) {
                var classOne = document.querySelectorAll('.option-size');
                for (var i = 0; i < classOne.length; i++) {
                    if (classOne[i] !== selector) {
                        classOne[i].style.border = "5px solid white";
                    } else {
                        selector.style.border = "5px solid rgba(255, 101, 195, 1)";
                    }
                }
            }
        </script>
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
