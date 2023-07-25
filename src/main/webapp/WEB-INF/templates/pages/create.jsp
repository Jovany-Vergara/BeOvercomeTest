<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container create-page bg-dark">
  <div class="card">
    <div class="card-header">
      Crear Ticket
    </div>
    <div class="card-body">
      <h5 class="card-title">Ticket</h5>
      <p class="card-text">
        <div class="input-group mb-3">
          <form action="create" method="post">
            <input type="text" name="title" class="form-control mb-3" placeholder="* Titulo de Ticket" aria-label="titile" aria-describedby="basic-addon1" required>
            <input type="text" name="responsableName" class="form-control mb-3" placeholder="* Nombre de Responsable" aria-label="titile" aria-describedby="basic-addon1" required>
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
            <input type="text" name="versionSoftware" class="form-control mb-3" placeholder="Versión del software en que se presenta la incidencia" aria-label="titile" aria-describedby="basic-addon1">
            <input type="text" name="problemDescription" class="form-control mb-3" placeholder="* Descripción completa del problema" aria-label="titile" aria-describedby="basic-addon1" required>
            <input type="file" name="uploadFile" class="form-control mb-3" placeholder="Cero o más archivos" aria-label="titile" aria-describedby="basic-addon1">
            <button class="btn btn-info" type="submit">Crear Ticket</button>
          </form>
        </div>
      </p>
    </div>
  </div>
</div>
