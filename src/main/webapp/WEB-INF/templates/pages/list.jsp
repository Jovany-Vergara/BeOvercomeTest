<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container ticket-page text-light">
  Test Lista: ${size}
  <%-- JSP foreach tag --%>
  <table class="table table-striped table-primary">
    <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Titile</th>
        <th scope="col">Last</th>
        <th scope="col">Handle</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="ticket" items="${command.tickets}">
        <tr>
          <th scope="row"><c:out value="${ticket.id}"/></th>
          <td>${ticket.title}</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
