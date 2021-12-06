<%-- 
    Document   : order
    Created on : Nov 4, 2021, 3:08:45 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            nav{
                position: absolute;
                width: 20vw;
                height: 100vh;
                top: 0;
                left: 0;
                margin: 0;
                padding: 0;
                background-color: rgba(39, 39, 39, 1)
            }
            .tab{
                width: 100%;
            }
            .cur{
                background: gray;
            }
            .logo{
                width: 300px;
            }
            nav img{
                width: 250px;
                margin-left: 25px;
                object-fit: contain;
            }
            .container{
                width: 70vw;
                display: inline-block;
                margin-left: 25vw;
            }
            nav a {
                text-decoration: none;
                line-height: 100px;
                display: block;
                transition: .3s background-color ;
                color: rgb(255, 101, 195);
                padding: auto;
                text-align: center;
                background-color: rgba(39, 39, 39, 1);
                font-size: 200%;
            }
            nav a:hover {
                background-color: grey;
            }  
            .cur a{
                background-color: gray;
            }
            h1{
                text-align: center;
            }
            .thead{
                width: 100%;
                background: rgb(255, 101, 195);
                text-align: center;
            }
            .orderid{
                border: 1px solid black;
                display: inline-block;
                width: 9%;
            }
            .name{
                border: 1px solid black;
                display: inline-block;
                width: 29%;
            }
            .phone{
                border: 1px solid black;
                display: inline-block;
                width: 19%;
            }
            .address{
                border: 1px solid black;
                display: inline-block;
                width: 30%;
            }
            .pricetotal{
                border: 1px solid black;
                display: inline-block;
                width: 10%;
            }
            .items{
                margin-top: 10px;
                border: 1px solid black;
                border-radius: 10px;
                overflow: hidden;
            }
            .notsend{
                background: lightsalmon;
            }
            .notship{
                background: lightyellow;
            }
            .finish{
                background: lightgreen;
            }
            .details{
                width: 90%;
                background: lightblue;
                text-align: center;
                border: 1px solid black;
            }
            .pdid{
                border: 1px solid black;
                display: inline-block;
                width: 10%;
            }
            .pimage{
                border: 1px solid black;
                display: inline-block;
                width: 15%;
            }
            .pimage img{
                width: 100%;
                object-fit: contain;
                vertical-align: middle;
            }
            .pname{
                border: 1px solid black;
                display: inline-block;
                width: 30%;
            }
            .pcname{
                border: 1px solid black;
                display: inline-block;
                width: 10%;
            }
            .psname{
                border: 1px solid black;
                display: inline-block;
                width: 10%;
            }
            .quantity{
                border: 1px solid black;
                display: inline-block;
                width: 10%;
            }
            .price{
                border: 1px solid black;
                display: inline-block;
                width: 10%;
            }
        </style>
    </head>

    <body>
        <nav>
            <div class="logo"><img id="homelogo" src="images\page\icons\homelogo.png"/></div>
            <div class="tab cur"><a href="admin?tab=order" >Đơn hàng</a></div>
            <div class="tab"><a href="admin?tab=product">Sản phẩm</a></div>
            <div class="tab"><a href="admin?tab=user">Người dùng</a></div>

        </nav>
        <div class="container">

            <h1>Danh sách đơn hàng</h1>
            <div class="thead">
                <div class="orderid" >OrderID</div>
                <div class="name" >Tên khách hàng</div>
                <div class="phone" >Số điện thoại</div>
                <div class="address" >Địa chỉ</div>
                <div class="pricetotal" >Tổng</div>
            </div>
            <c:forEach items="${requestScope.notsend}" var="i">
                <div class="items notsend">
                    <div class="orderid" >${i.orderID}</div>
                    <div class="name" >${i.customerName}</div>
                    <div class="phone" >${i.phonenumber}</div>
                    <div class="address" >${i.address}</div>
                    <div class="pricetotal" >${i.totalPrice}</div>
                    <details>
                        <summary>Chi tiết đơn hàng
                        </summary>
                        <c:forEach items="${i.list}" var="f">
                            <div class="details">
                                <div class="od pdid" >${f.productDetailID}</div>
                                <div class="od pimage" > <img src="${f.path}"></div>
                                <div class="od pname" >${f.productName}</div>
                                <div class="od pcname" >${f.colorName}</div>
                                <div class="od psname" >${f.sizeName}</div>
                                <div class="od quantity" >${f.quantity}</div>
                                <div class="od price" >${f.price}</div>
                            </div>
                        </c:forEach>
                    </details>
                </div>
                <form action="orderprocess" method="get">
                    <input type="hidden" name="oid" value="${i.orderID}">
                    <input type="submit" value="Đã giao hàng">
                </form>
            </c:forEach>
            <c:forEach items="${requestScope.notship}" var="i">
                <div class="items notship">
                    <div class="orderid" >${i.orderID}</div>
                    <div class="name" >${i.customerName}</div>
                    <div class="phone" >${i.phonenumber}</div>
                    <div class="address" >${i.address}</div>
                    <div class="pricetotal" >${i.totalPrice}</div>
                    <details>
                        <summary>Chi tiết đơn hàng
                        </summary>
                        <c:forEach items="${i.list}" var="f">
                            <div class="details">
                                <div class="od pdid" >${f.productDetailID}</div>
                                <div class="od pimage" > <img src="${f.path}"></div>
                                <div class="od pname" >${f.productName}</div>
                                <div class="od pcname" >${f.colorName}</div>
                                <div class="od psname" >${f.sizeName}</div>
                                <div class="od quantity" >${f.quantity}</div>
                                <div class="od price" >${f.price}</div>
                            </div>
                        </c:forEach>
                    </details>
                </div>
                <form action="orderprocess" method="post">
                    <input type="hidden" name="oid" value="${i.orderID}">
                    <input type="submit" value="Đã trả hàng">
                </form>
            </c:forEach>
            <c:forEach items="${requestScope.finish}" var="i">
                <div class="items finish">
                    <div class="orderid" >${i.orderID}</div>
                    <div class="name" >${i.customerName}</div>
                    <div class="phone" >${i.phonenumber}</div>
                    <div class="address" >${i.address}</div>
                    <div class="pricetotal" >${i.totalPrice}</div>
                    <details>
                        <summary>Chi tiết đơn hàng
                        </summary>
                        <c:forEach items="${i.list}" var="f">
                            <div class="details">
                                <div class="od pdid" >${f.productDetailID}</div>
                                <div class="od pimage" > <img src="${f.path}"></div>
                                <div class="od pname" >${f.productName}</div>
                                <div class="od pcname" >${f.colorName}</div>
                                <div class="od psname" >${f.sizeName}</div>
                                <div class="od quantity" >${f.quantity}</div>
                                <div class="od price" >${f.price}</div>
                            </div>
                        </c:forEach>
                    </details>
                </div>
            </c:forEach>


        </div>
    </body>
</html>
