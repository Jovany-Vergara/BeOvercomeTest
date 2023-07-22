<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<div class="container ticket-page bg-dark mb-6">

  <div class="card">
    <h5 class="card-header">Detalles</h5>
    <div class="card-body">
      <h5 class="card-title ">Detalles del ticket ${ticket.id}</h5>
      <p class="card-text">
        <table class="table table-striped table-info">
          <thead>
            <tr>
              <th scope="col">Titulo</th>
              <th scope="col">Fecha Ticket</th>
              <th scope="col">Nombre Responsable</th>
              <th scope="col">Equipo responsable</th>
              <th scope="col">Tipo Incidencia</th>
              <th scope="col">Gravedad</th>
              <th scope="col">Versión Incidencia</th>
              <th scope="col">Descripción</th>
              <th scope="col">Archivo</th>
              <th scope="col">Estatus de los Tickets</th>
              <th scope="col">Archivar</th>
            </tr>
          </thead>
          <tbody>
            <tr>
                <td scope="row">${ticket.title}</td>
                <td>${ticket.createDate}</td>
                <td>${ticket.responsableName}</td>
                <td>${ticket.responsibleTeam}</td>
                <td>${ticket.incidentType}</td>
                <td>${ticket.incidenceSeverity}</td>
                <td>${ticket.versionSoftware}</td>
                <td>${ticket.problemDescription}</td>
                <td>${ticket.uploadFile}</td>
                <td>
                  <form action="/updateStatus" method="post">
                    <input type="text" name="id" value="${ticket.id}">
                    <select class="custom-select" id="status" name="status">
                      <option value="created" ${ticket.status == 'created' ? 'selected="selected"' : ''}>Nuevo</option>
                      <option value="process" ${ticket.status == 'process' ? 'selected="selected"' : ''}>En proceso</option>
                      <option value="attend"  ${ticket.status == 'attend' ? 'selected="selected"' : ''}>Atendido</option>
                    </select>
                    <button type="submit" class="btn btn-success">Cambiar</button>
                  </form>
                </td>
              <td>
                <a href="#" class="btn btn-danger">Archivar</a>
              </td>
            </tr>
          </tbody>
        </table>
      </p>
    </div>
  </div>

</div>
