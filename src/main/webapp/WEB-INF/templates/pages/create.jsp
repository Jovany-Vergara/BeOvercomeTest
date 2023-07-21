<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container create-page">
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text" id="basic-addon1">*Título del ticket</span>
    </div>
    <form action="create" method="post">
      <input type="text" name="title" class="form-control" placeholder="titile" aria-label="titile" aria-describedby="basic-addon1">
      <input type="text" name="responsableName" class="form-control" placeholder="Nombre de Responsable" aria-label="titile" aria-describedby="basic-addon1">
      <button type="submit">Crear Ticket</button>
    </form>
  </div>
</div>
