package closer.controller;

import closer.models.User;
import closer.models.Groups;
import closer.registration.GroupsDao;
import closer.registration.UserDao;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "groups", value = "/groups")
public class GroupsServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null) {
            request.getRequestDispatcher("/").forward(request, response);
        }
        request.getRequestDispatcher("/groups.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String type =  request.getParameter("type");
        System.out.println("inputs: "+ name + " " + Integer.parseInt(type));
        GroupsDao manager = new GroupsDao();
        manager.createGroup(name, Integer.parseInt(type));
        response.sendRedirect("/groups");
    }
}
