<%-- 
    Document   : restaurantDetails
    Created on : Sep 19, 2022, 1:54:14 AM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--kiểm tra trjang thái đăng nhập-->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!--format number-->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        css
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        js
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        font awesome
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
    </head>
    <body>-->

<!--navbar-->
<!--        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="javascript:void(0)">HeThongNHTC</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/" />">&#127758; Trang chu</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-info" href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-info" href="<c:url value="/register" />">Đăng ký</a>
                        </li>

                </div>
            </div>
        </nav>-->
<!--content-->

<div class="row">
    <div class="col-md-3 col-xs-12 bg-light">
        <nav class="navbar bg-light">
            <div class="container-fluid">
                <ul class="navbar-nav">
                    <c:url value="/restaurant/${restaurantId}" var="cUrl">
                    </c:url>
                    <%--<c:param name="cateId" value="lobby"></c:param>--%>

                    <li class="nav-item">
                        <a class="nav-link" href="${cUrl}">Giới thiệu nhà hàng</a>
                    </li>
                    <c:url value="/restaurant/${restaurantId}" var="cUrl">
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${cUrl}/lobby" />Sảnh</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="${cUrl}/menu">Thực đơn</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${cUrl}/service" />Dịch vụ cưới</a>
                    </li>



                </ul>
            </div>
        </nav>
    </div>
    <div class="col-md-9 col-xs-12">
        <h1 class="text-center text-info">GIỚI THIỆU NHÀ HÀNG</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="${restaurant.image}" class="img-fluid" />
                </div>
                <div class="col-md-7">
                    <h1>${restaurant.name}</h1>
                    <h3>Địa chỉ: ${restaurant.road} ${restaurant.ward} ${restaurant.district}</h3>
                    <h3>Hotline: ${restaurant.hotline}</h3>
                </div>
            </div>
            <!--SẢNH-->

        </div>
        <!--thực đơn-->
        

        <!--DỊCH VỤ CƯỚI-->
        
    </div>

</div>

<!--footer-->
<!--        <div class="mt-4 p-5 bg-primary text-white rounded">
            <h1>HeThongNHTC</h1>
            <p>HTTN &copy; 2022</p>
        </div>-->
<!--    </body>
</html>-->

