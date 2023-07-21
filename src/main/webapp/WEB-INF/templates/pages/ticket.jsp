<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<div class="container ticket-page text-light">
  Ticket: ${example.name}
  Name: ${ticket.title}
  <br>
  <%-- JSP foreach tag --%>
  <c:forEach var="var" items="${rightHereMap.tickets}">
    <c:out value="${var.title}"/> <br> <br>
  </c:forEach>
</div>
<h2>This page is designed to demonstrate the use of foreach tag in JSP: </h2>
<jsp:scriptlet>
String[] var = new String[]{"Number 1" , "Number 2", "Number 3", "Number 4", "Number 5", "Number 6", "Number 7"};
pageContext.setAttribute("variables", var);
</jsp:scriptlet>
<%-- JSP foreach tag --%>
<c:forEach var="var" items="${pageScope.variables}">
<c:out value="${var}"/> <br> <br>
</c:forEach>
