package closer.controller;

import closer.models.User;
import closer.models.Groups;
import closer.registration.GenericDao;
import closer.registration.GroupsDao;
import closer.registration.UserDao;


import closer.utils.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Transaction;
import org.hibernate.*;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "groups", value = "/groups")
public class GroupsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");

        if (user != null) {
            GroupsDao groupsDao = new GroupsDao();
            List<Groups> groupsList = groupsDao.getAllByUser(user);
            request.setAttribute("groupsList", groupsList); // Pass groups list to JSP
        }

        request.getRequestDispatcher("/groups.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name = request.getParameter("name");
        String type = request.getParameter("type");

        try {
        GroupsDao manager = new GroupsDao();
        manager.createGroup(name, Integer.parseInt(type));
        } catch(Exception e) {
        request.getSession().setAttribute("error", "Erro desconhecido");
        } finally {
            response.sendRedirect("/groups");
        }
    }

        public void destroy() {
        }
}
