<%-- 
    Document   : cart
    Created on : Oct 2, 2022, 12:39:05 AM
    Author     : HP
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<c:url value="/receipt" var="action" />

<form:form action="${action}" method="post">
    
    <h3>Sảnh : ${bill.lobby.name} </h3>
    <h3>Menu : ${bill.menu.id} </h3>
    <h3>Dịch vụ : 
        <c:forEach items="${bill.ser}" var="s">
            ${s.name},       
        </c:forEach>
            
    
    </h3>
        <input type="submit" value="Đặt" class="btn btn-danger" />
    
    </form:form>


