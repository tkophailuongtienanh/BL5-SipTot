<%-- 
    Document   : wishlist
    Created on : Nov 1, 2021, 3:14:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                background: rgba(255, 255, 255, 0.6) ;
            }
            h1{
                text-align: center;
            }
            .thead{
                line-height: 50px;
                text-align: center;
                height: 50px;
                font-size: 20px;
                width: 90%;
                margin: auto;
                background: rgba(255, 101, 195, 0.8);
                border-radius: 25px;
            }
            .no{
                display: inline-block;
                width: 9%;
                margin: auto;
            }
            .pimage{
                height: 100%;
                display: inline-block;
                width: 19%;
                margin: auto;
            }
            .pimage img{
                width: 100%;
                height: 100%;
                object-fit: contain;
                vertical-align: middle;
            }
            .pname{
                height: 100%;
                display: inline-block;
                width: 29%;
                margin: auto;
            }
            .pprice{
                height: 100%;
                display: inline-block;
                width: 19%;
                margin: auto;
            }
            .elements{
                width: 90%;
                margin: auto;
            }
            .items{
                margin-top: 20px;
                height: 100px;
                line-height: 100px;
                text-align: center;
                font-size: 20px;
                background-color: white;
                border-radius: 75px;
                overflow: hidden;
            } .items a{
                height: 100%;
                text-decoration: none;
                color: black;
            }
            .items .pname{
                padding-left: 10px;
                padding-right: 10px;
                text-overflow: ellipsis;
                word-wrap: break-word;
                overflow: hidden;
                height: 2em;
                line-height: 1em;
                text-align: left;
            }
            .action{
                display: inline-block;
                width: 19%;
                margin: auto;
            }
            .action .remove{
                border: 1px solid black;
                padding: 5px 10px 5px 10px;
                border-radius: 10px;
                background-color: lightgrey;
            }
            .empty{
                text-align: center;
    font-style: italic;
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
            <h1>Danh sách sản phẩm đã thích</h1>
            <div class="thead">
                <div class="no" >STT</div>
                <div class="pimage" >Ảnh</div>
                <div class="pname" >Tên Sản Phẩm</div>
                <div class="pprice" >Giá</div>
                <div class="action" >Hoạt activity</div>
            </div>
            <div class="elements">
                <c:if test="${sessionScope.csize <=0}">
                    <p></p>
                    <div class="empty" >Chưa có sản phẩm</div>
                </c:if>
                <c:set var="t" value="0"/>
                <c:forEach items="${data}" var="i">
                    <c:set var="t" value="${t+1}"/>
                    <div class="items">
                        <a href="productview?pid=${i.productID}">
                            <div class="no">${t}</div>
                            <div class="pimage" ><img src="${i.path}"/></div>
                            <div class="pname" >${i.productName}</div>
                            <div class="pprice" >${i.price}₫</div>
                        </a>
                        <div class="action">
                            <a href="removewish?pid=${i.productID}" class="remove">Xóa</a>
                        </div>
                    </div>
                </c:forEach>
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
