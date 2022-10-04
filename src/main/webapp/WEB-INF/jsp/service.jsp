<%-- 
    Document   : service
    Created on : Sep 20, 2022, 5:39:43 PM
    Author     : HP
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--kiểm tra trjang thái đăng nhập-->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!--format number-->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<script src="<c:url value="/js/receipt.js" />"></script>

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
        <h1 class="text-center text-primary">DỊCH VỤ TIỆC CƯỚI</h1>
        <div class="row">
            <ul class="pagination">
                <c:forEach begin="1" end="${Math.ceil(serviceCounter/pageSize)}" var="i">
                    <c:url value="/restaurant/${restaurantId}/service" var="u" >
                        <c:param name="page" value="${i}" />

                    </c:url>
                    <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
                    </c:forEach>
            </ul>
            <c:forEach items="${services}" var="s">
                <div class="col-md-3 col-12" style="padding: 10px;">
                    <div class="card">
                        <img class="card-img-top" class="img-fluid" src="${s.image}" alt="Card image">
                        <div class="card-body">
                            <h4 class="card-title">${s.name}</h4>
                            <p class="card-text">
                                <fmt:formatNumber value="${s.price}" type="currency"/> VND
                            </p>
                            <a id="S${s.id}" onclick="themGioHang('S${s.id}',${s.idRestaurant.id})"  class="btn btn-primary">Chọn dịch vụ</a>

                            <a href="<c:url value="/service/${s.id}" />" class="btn btn-primary">Xem chi tiet</a>


                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
