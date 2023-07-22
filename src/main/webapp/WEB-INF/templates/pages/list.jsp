<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container ticket-page bg-dark">
  <%-- JSP foreach tag --%>
  <div class="card">
    <h5 class="card-header">Numero de Tickets ${size}</h5>
    <div class="card-body">
      <h5 class="card-title">Lista de Tickets</h5>
      <p class="card-text">
        <table class="table table-striped table-primary">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Titile</th>
              <th scope="col">Fecha Ticket</th>
              <th scope="col">Nombre Responsable</th>
              <th scope="col">Equipo responsable</th>
              <th scope="col">Tipo Incidencia</th>
              <th scope="col">Gravedad</th>
              <th scope="col">Versión Incidencia</th>
              <th scope="col">Descripción</th>
              <th scope="col">Archivo</th>
              <th scope="col">Detalles</th>
              <th scope="col">Estatus</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="ticket" items="${command.tickets}">
              <tr>
                <th scope="row"><c:out value="${ticket.id}"/></th>
                <td>${ticket.title}</td>
                <td>${ticket.createDate}</td>
                <td>${ticket.responsableName}</td>
                <td>${ticket.responsibleTeam}</td>
                <td>${ticket.incidentType}</td>
                <td>${ticket.incidenceSeverity}</td>
                <td>${ticket.versionSoftware}</td>
                <td>${ticket.problemDescription}</td>
                <td>${ticket.uploadFile}</td>
                <td>${ticket.status}</td>
                <td>
                  <form action="/ticket/${ticket.id}" method="get">
                    <button type="submit" class="btn btn-light">Detalle</button>
                  </form>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </p>
    </div>
  </div>
</div>
