<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Formulário de Contato com JavaScript</title>
  <link rel="stylesheet" href="static/css/formStyle.css" />
<%--  <script defer src="app.js"></script>--%>
</head>
<body>
  <form method="POST" action="/groups" id="groupForm">
    <label for="grupo">Nome do Grupo</label>
    <input type="text" name="name" id="grupo" required />
    <label for="tipo_grupo">Tipo do Grupo</label>
    <select name="type" id="tipo_grupo" required>
      <option value="">Selecione</option>
      <option value="1">Friends</option>
      <option value="2">Date</option>
      <option value="3">Family</option>
    </select>
    <!-- Campos para os nomes dos participantes -->
    <div id="participantes_container">
      <!-- Este campo será preenchido dinamicamente -->
    </div>
    <!-- Script para adicionar campos de participantes dinamicamente -->
    <button type="submit" data-button>Enviar</button>
  </form>
</body>
</html>