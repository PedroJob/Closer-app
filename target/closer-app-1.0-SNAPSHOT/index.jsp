<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Closer</title>
    <link rel="stylesheet" href="static/css/loginStyle.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>
<div class="wrapper">
    <form method="POST" action="/login" id="loginForm">
        <h1>Closer</h1>
        <div class="input-box">
            <input type="text" placeholder="Username" name="UserName" required>
            <i class='bx bxs-user'></i>
        </div>

        <div class="input-box">
            <input type="password" placeholder="Password" name="UserPasswordHash" required>
            <i class='bx bxs-lock-alt'></i>
        </div>

        <button type="submit" class="btn">Login</button>

        <div class="register-link">
            <p>Don't have an account? <a href="/signup.jsp">Register</a></p>
        </div>
    </form>
</div>

</body>

</html>