<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Formulário de Contato com JavaScript</title>
  <link rel="stylesheet" href="css/formStyle.css" />
  <script defer src="app.js"></script>
</head>
<body>
  <form action="https://formsubmit.co/ajax/peteramvs@gmail.com"
    method="POST"
    data-form>
    <label for="username">Username</label>
    <input type="text" name="username" id="username" required />
    <label for="grupo">Nome do Grupo</label>
    <input type="text" name="grupo" id="grupo" required />
    <label for="tipo_grupo">Tipo do Grupo</label>
    <select name="tipo_grupo" id="tipo_grupo" required>
      <option value="">Selecione</option>
      <option value="Friends">Friends</option>
      <option value="Date">Date</option>
      <option value="Family">Family</option>
    </select>
    <label for="num_participantes">Número de Participantes</label>
    <input type="number" name="num_participantes" id="num_participantes" required min="1" />
    <!-- Campos para os nomes dos participantes -->
    <div id="participantes_container">
      <!-- Este campo será preenchido dinamicamente -->
    </div>
    <!-- Script para adicionar campos de participantes dinamicamente -->
    <script>
      document.getElementById('num_participantes').addEventListener('input', function() {
        var numParticipantes = parseInt(this.value);
        var participantesContainer = document.getElementById('participantes_container');
        participantesContainer.innerHTML = ''; // Limpa os campos existentes
        
        if (numParticipantes > 0) {
          for (var i = 0; i < numParticipantes; i++) {
            var participanteDiv = document.createElement('div');
            participanteDiv.innerHTML = `
              <label for="participante_${i+1}">Participante ${i+1}</label>
              <input type="text" name="participante_${i+1}" id="participante_${i+1}" required />
            `;
            participantesContainer.appendChild(participanteDiv);
          }
        }
      });
    </script>
    <button type="submit" data-button>Enviar</button>
  </form>
</body>
</html>