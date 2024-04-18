<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Group Chat</title>
  <link rel="stylesheet" href="css/chatStyle.css">
</head>

<body>
  <ion-icon id="dislike" name="heart-dislike"></ion-icon>
  <div id="swiper">
  </div>
  <ion-icon id="like" name="heart"></ion-icon>
  
  <script src="javascript/cardScript.js"></script>
  <script src="javascript/chatScript.js"></script>
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

  <script>
    // Função para exibir um pop-up com uma string do desafio do grupo
    window.onload = function() {
      // Esse dado deve ser coletado do back-end
      const groupType = 0;
      // Descobrir o dia da semana:
      var dataAtual = new Date();
      var diaDaSemana = dataAtual.getDay();
      
      // Banco de dados dos desafios:
      const temasFamiliares = [
      "Selfie durante um almoço em família",
      "Selfie durante uma viagem de família",
      "Selfie com todos os membros da família reunidos",
      "Selfie brincando de jogos de tabuleiro em família",
      "Selfie em um evento especial, como aniversário ou casamento na família",
      "Selfie fazendo uma atividade ao ar livre com a família, como caminhada ou piquenique",
      "Selfie assistindo a um filme ou série em família"
      ];

      const temasAmigos = [
      "Selfie durante uma festa com os amigos",
      "Selfie em um encontro casual com os amigos",
      "Selfie em uma viagem com os amigos",
      "Selfie em um jogo ou evento esportivo com os amigos",
      "Selfie durante um dia de compras com os amigos",
      "Selfie em um café ou restaurante favorito com os amigos",
      "Selfie durante uma sessão de cinema ou maratona de séries com os amigos"
      ];

      const temasNamoro = [
      "Selfie em um encontro romântico",
      "Selfie durante um passeio de mãos dadas",
      "Selfie em um piquenique a dois",
      "Selfie durante uma viagem romântica",
      "Selfie assistindo ao pôr do sol juntos",
      "Selfie trocando olhares apaixonados",
      "Selfie em um jantar à luz de velas"
      ];
      
      if(groupType == 0){
        alert("Desafio do Dia: "+ temasFamiliares[diaDaSemana]);
      }
      
      else if(groupType == 1){
        alert("Desafio do Dia: "+ temasAmigos[diaDaSemana]);
      }
      
      else if(groupType == 2){
        alert("Desafio do Dia: "+ temasNamoro[diaDaSemana]);
      }
      
      else{
        alert("Front-End saying: Error!");
      }

    };
  </script>
</body>

</html>