 <%-- 
    Document   : header
    Created on : Aug 16, 2022, 10:48:54 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--import c-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--format number-->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<!--content-->
<h1 class="text-center text-primary">NHÀ HÀNG</h1>
<div class="container">
    <!--phaan trang-->
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(restaurantCounter/pageSize)}" var="i">
            <c:url value="/" var="u" >
                <c:param name="page" value="${i}" />

            </c:url>
            <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
        </c:forEach>
    </ul>
    <!--đổ danh sách sản phẩm ra--> 
    <div class="row">
        <c:forEach items="${restaurants}" var="p">
            <div class="col-md-3 col-12" style="padding: 10px;">
                <div class="card">
                    <img class="card-img-top" class="img-fluid" src="${p.image}" alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">${p.name}</h4>


                        <a href="<c:url value="/restaurant/${p.id}" />" class="btn btn-primary">Xem chi tiet</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

