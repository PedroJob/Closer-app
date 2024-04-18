package closer.controller;

import closer.models.User;
import closer.registration.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("UserName");
        String password = request.getParameter("UserPasswordHash");

        UserDao manager = new UserDao();
        User user = manager.getByUsername(username);

        if (user == null) {
            request.getSession().setAttribute("error", "usuário não existe");
            response.sendRedirect("/login");
        }

        if (user.checkPassword(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // login efetivo
            session.setAttribute("error", null);
            session.setAttribute("signed", true);
            System.out.println(user.getId());
            response.sendRedirect("/groups.jsp");
        } else {
            request.getSession().setAttribute("error", "senha incorreta");
            response.sendRedirect("/login");
        }

    }

    public void destroy() {
    }
}