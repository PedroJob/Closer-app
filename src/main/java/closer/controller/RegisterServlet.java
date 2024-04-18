package closer.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import closer.registration.UserDao;
import closer.models.User;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("UserName");
        String password = request.getParameter("UserPasswordHash");
        String email = request.getParameter("UserEmail");
        String profilePic = request.getParameter("UserProfilePic");

        User user = new User();
        user.setUserEmail(email);
        user.setUserName(name);
        user.setUserPassword(password);
        user.setUserProfilePic(profilePic);

        try {
            userDao.registerUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("groups.jsp"); // TODO
    }
}