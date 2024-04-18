package closer.controller;

import closer.models.User;
import closer.registration.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao manager = new UserDao();
        User user = manager.getByUsername(username);

        if (user == null) {
            request.getSession().setAttribute("error", "usuário não existe");
            response.sendRedirect("/login");
        }

        if (user.checkPassword(password)) {
            request.getSession().setAttribute("user", user); // login efetivo
            request.getSession().setAttribute("error", null);
            response.sendRedirect("/");
        } else {
            request.getSession().setAttribute("error", "senha incorreta");
            response.sendRedirect("/login");
        }

    }

    public void destroy() {
    }
}