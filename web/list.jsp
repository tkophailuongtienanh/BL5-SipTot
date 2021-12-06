<%-- 
    Document   : list
    Created on : Oct 29, 2021, 3:13:30 AM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="css/buttonScrollToTop.js"></script>
        <link rel="stylesheet" type="text/css" href="css/navcss.css" />
        <link rel="stylesheet" type="text/css" href="css/productViewer.css" />
        <link rel="stylesheet" type="text/css" href="css/searchBar.css" />
        <link rel="stylesheet" type="text/css" href="css/scrollButton.css" />
        <style>
            .pagination {
                display: block;
                width: 50%;
                margin: auto;
            }
            .pagination a {
                display: inline-block;
                color: black;
                font-size: 22px;
                padding: 8px 16px;
                text-decoration: none;
                background-color: white;
            }
            .pagination a.active {
                background-color: rgb(255, 101, 195);
                color: white;
            }
            .pagination a:hover:not(.active) {
                background-color: rgba(255, 101, 195, 0.6);
            }
            a.disabled {
                pointer-events: none;
                cursor: default;
                color: lightgray;
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
            .selector{
                background: rgb(255, 101, 195);
            }
            body .container{
                min-height: 50vh;
            }
            body {
                display: block;
                margin: 0;
                padding: 0;
                background-image: url("images/page/banner/back.jpg");
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
        <div class="container">
            <div class="content">
                <div class="selector">
                <form action="list" accept-charset="utf-8" >
                <c:set var="curcid" value="${requestScope.curcid}"/>
                <input type="text" name="name" placeholder="Tìm theo tên ..."/>
                    <select name="cid" onchange="this.form.submit()">
                        <option value="">Chọn Thể Loại</option>
                        <c:forEach items="${requestScope.clist}" var="i">
                            <option value="${i.catID}" <c:if test="${curcid==i.catID}">selected="selected"</c:if>  >${i.catname}</option>
                        </c:forEach>
                    </select>
                    <select name="scid" >
                        <option value="" selected="selected">Tất cả thuộc tính</option>
                        <c:forEach items="${requestScope.sclist}" var="i">
                            <option value="${i.subCatID}">${i.subCatName}</option>
                        </c:forEach>
                    </select>
                    <select name="color">
                        <option value="" selected="selected">Tất cả màu</option>
                        <c:forEach items="${requestScope.cllist}" var="i">
                            <option value="${i.id}" >${i.name}</option>
                        </c:forEach>
                    </select>
                    <select name="size">
                        <option value="" selected="selected">Tất cả kích cỡ</option>
                        <c:forEach items="${requestScope.slist}" var="i">
                            <option value="${i.id}" >${i.name}</option>
                        </c:forEach>
                    </select>
                    <select name="mat">
                        <option value="" selected="selected">Tất cả chất liệu</option>
                        <c:forEach items="${requestScope.mlist}" var="i">
                            <option value="${i.name}" >${i.name}</option>
                        </c:forEach>
                    </select>
                    <select name="odb">
                        <option value="" selected="selected">Sắp xếp theo</option>
                        <option value="1">Mới nhất</option>
                        <option value="2">Cũ nhất</option>
                        <option value="3">Giá giảm dần</option>
                        <option value="4">Giá tăng dần</option>
                        <option value="5">Tên sản phẩm từ a-z</option>
                        <option value="6">Tên sản phẩm từ z-a</option>
                    </select>
                    <button type="submit">Tìm kiếm</button>
                </form>
                </div>

                <c:set var="page" value="${requestScope.page}"/>
                <c:set var="n" value="${requestScope.num}"/>


                <c:forEach items="${requestScope.data}" var="p">
                    <a class="product" href="productview?pid=${p.productID}">
                        <div class="ava"><img src="${p.path}"/></div>
                        <div class="pname">${p.productName}</div>
                        <hr>
                        <div class="pprice">${p.price}₫</div>
                    </a>
                </c:forEach>
                <span class="pagination">
                    <c:if test="${n!=0}">
                        <a href="list?page=${page-1}" class=${page!=1?"":"disabled"}>Prev</a>

                        <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                            <a class="${i==page?('active'):('')}" href="list?page=${i}">${i}</a> 
                        </c:forEach>
                        <a href="list?page=${page+1}"  class=${(page!=n&&n!=0)?"":"disabled"}>Next</a>
                    </c:if>
                    <c:if test="${n==0}">
                        not Found!
                    </c:if>
                </span>
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
