<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Closer</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="static/css/indexStyle.css">
    <header>
        <nav class="container">
            <h1>Closer</h1>
            <div class="Closer-contact-container">
                <img src="static/img/github.svg" alt="Github">
                <a>User Name</a>
            </div>
            <a href="form.jsp" class="btn btn-primary">Novo Grupo</a>
        </nav>
    </header>
</head>

<body>

    <main>
        
        <section id="Closer-card-list" class="container">

            <div class="Closer-pagination-container">
                <div class="Closer-pagination-box">
                    <button disabled><img src="static/img/arrow.svg" alt="Voltar"></button>
                    <p>Group List</p>
                    <button class="Closer-flip-horizontal"><img class="Closer" src="static/img/arrow.svg" alt="Próxima"></button>
                </div>
            </div>
            
            <div id="card-container" class="row">
                <!-- Cards serão adicionados dinamicamente aqui -->
                <script>
                    // Dados do usuário (vai ser recuperado atraves do BD)
                    const userData = [
                        { groupName: "Grupo 1", groupType: "Family", imageURL: "static/img/family.jpg" },
                        { groupName: "Grupo 2", groupType: "Friends", imageURL: "static/img/friends.jpg" },
                        { groupName: "Grupo 3", groupType: "Date", imageURL: "static/img/date.jpg" },
                        { groupName: "Grupo 4", groupType: "Friends", imageURL: "static/img/friends.jpg" }
                    ];
                
                    // Função para criar e adicionar os cards dinamicamente

                    function createCards() {
                        const cardContainer = document.getElementById("card-container");

                        userData.forEach(data => {
                            const cardColumn = document.createElement("div");
                            cardColumn.classList.add("col-sm-6", "col-lg-4", "col-xl-3", "mb-3");

                            const card = document.createElement("div");
                            card.classList.add("Closer-card");

                            const cardImage = document.createElement("img");
                            cardImage.src = data.imageURL;

                            const cardDescription = document.createElement("div");
                            cardDescription.classList.add("Closer-card-description");

                            const groupName = document.createElement("h3");
                            groupName.textContent = data.groupName;

                            const groupType = document.createElement("p");
                            groupType.textContent = data.groupType;

                            const openButton = document.createElement("button");
                            openButton.textContent = "Open";
                            openButton.classList.add("Closer-btn");

                            // Adicionando evento de clique ao botão "Open"
                            openButton.addEventListener("click", () => {
                                // Criando um URL personalizado com parâmetros de consulta
                                const urlParams = new URLSearchParams();
                                urlParams.append("groupName", data.groupName);
                                urlParams.append("groupType", data.groupType);
                                urlParams.append("imageURL", data.imageURL);
                                const url = `chat.jsp?${urlParams.toString()}`;

                                // Redirecionando para a página chat.jsp com os parâmetros de consulta
                                window.location.href = url;
                            });

                            cardDescription.appendChild(groupName);
                            cardDescription.appendChild(groupType);
                            cardDescription.appendChild(openButton);

                            card.appendChild(cardImage);
                            card.appendChild(cardDescription);

                            cardColumn.appendChild(card);
                            cardContainer.appendChild(cardColumn);
                        });
                    }

                    // Chame a função para criar os cards quando a página carregar
                    window.addEventListener("DOMContentLoaded", createCards);
                </script>
            </div>
       
        </section>
    </main>

</body>

</html>