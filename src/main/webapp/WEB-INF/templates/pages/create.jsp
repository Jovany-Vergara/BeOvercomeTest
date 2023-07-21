<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container create-page">
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text" id="basic-addon1">*Título del ticket</span>
    </div>
    <form action="create" method="post">
      <input type="text" name="title" class="form-control" placeholder="* Titulo de Ticket" aria-label="titile" aria-describedby="basic-addon1" required>
      <input type="text" name="responsableName" class="form-control" placeholder="* Nombre de Responsable" aria-label="titile" aria-describedby="basic-addon1" required>
      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <label class="input-group-text" for="inputGroupSelect01">Equipo responsable de la solución</label>
        </div>
        <select name="responsibleTeam" class="custom-select" id="inputGroupSelect01">
          <option selected>Elegir...</option>
          <option value="Soporte">Soporte</option>
          <option value="Desarrollo">Desarrollo</option>
          <option value="Atención a Clientes">Atención a Clientes</option>
        </select>
      </div>
      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <label class="input-group-text" for="inputGroupSelect01">* Tipo de incidencia</label>
        </div>
        <select name="incidentType" class="custom-select" id="inputGroupSelect02" required>
          <option selected>Elegir...</option>
          <option value="Bug">Bug</option>
          <option value="Feature">Feature</option>
        </select>
      </div>
      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <label class="input-group-text" for="inputGroupSelect01">* Gravedad de la incidencia</label>
        </div>
        <select name="incidenceSeverity" class="custom-select" id="inputGroupSelect03" required>
          <option selected>Elegir...</option>
          <option value="High">High</option>
          <option value="Medium">Medium</option>
          <option value="Low">Low</option>
        </select>
      </div>
      <input type="text" name="versionSoftware" class="form-control" placeholder="Versión del software en que se presenta la incidencia" aria-label="titile" aria-describedby="basic-addon1">
      <input type="text" name="problemDescription" class="form-control" placeholder="* Descripción completa del problema" aria-label="titile" aria-describedby="basic-addon1" required>
      <input type="file" name="uploadFile" class="form-control" placeholder="Cero o más archivos" aria-label="titile" aria-describedby="basic-addon1">
      <button type="submit">Crear Ticket</button>
    </form>
  </div>
</div>
