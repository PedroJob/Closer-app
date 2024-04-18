package closer.controller;

import closer.registration.UserDao;
import closer.models.User;
import closer.utils.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("UserEmail");
        String username = request.getParameter("UserName");
        String password = request.getParameter("UserPassword");

        try {
            UserDao manager = new UserDao();
            manager.createUser(email, username, password);
        } catch(Exception e) {
            request.getSession().setAttribute("error", "Erro desconhecido");
            response.sendRedirect("/signup");
        }

        response.sendRedirect("/groups");
    }

    public void destroy() {
    }
}