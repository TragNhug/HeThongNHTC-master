<%-- 
    Document   : lobby
    Created on : Sep 19, 2022, 8:40:15 AM
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
        <h1 class="text-center text-info">SẢNH</h1>
        <div class="container">
            <!--phân trang-->
            <ul class="pagination">
                <c:forEach begin="1" end="${Math.ceil(lobbyCounter/pageSize)}" var="i">
                    <c:url value="/restaurant/${restaurantId}/lobby" var="u" >
                        <c:param name="page" value="${i}" />

                    </c:url>
                    <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
                    </c:forEach>
            </ul>
            <!--đổ danh sách sản phẩm ra--> 
            <div class="row">
                <c:forEach items="${lobbies}" var="p">
                    <div class="col-md-3 col-12" style="padding: 10px;">
                        <div class="card">
                            <img class="card-img-top" class="img-fluid" src="${p.image}" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${p.name}</h4>
                                <p class="card-text">
                                    <fmt:formatNumber value="${p.price}" type="currency"/> VND
                                </p>
                                <a href="<c:url value="/lobby/${p.id}" />" class="btn btn-primary">Xem chi tiet</a>
                                <button id="L${p.id}" onclick="check('L${p.id}',${p.idRestaurant.id}),themGioHang('L${p.id}',${p.idRestaurant.id})" class="btn btn-primary" value="Chon">Chon</button>
                                
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>