<%-- 
    Document   : user
    Created on : Nov 4, 2021, 7:01:33 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        </style>
    </head>
    <body>
        <nav>
            <div class="logo"><img id="homelogo" src="images\page\icons\homelogo.png"/></div>
            <div class="tab"><a href="admin?tab=order" >Đơn hàng</a></div>
            <div class="tab"><a href="admin?tab=product">Sản phẩm</a></div>
            <div class="tab cur"><a href="admin?tab=user">Người dùng</a></div>

        </nav>

        <div class="container">
            <h1>Danh sách người dùng</h1>
            <c:forEach items="${requestScope.list}" var="i">
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
        </div>
    </body>
</html>
