package controllers;

import DAO.PersonDAO;
import model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by wopqw on 23.10.16.
 */

@WebServlet("/userspace/")
public class UserSpace extends HttpServlet {

    private PersonDAO personDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {

        personDAO = (PersonDAO) config.getServletContext().getAttribute("personDAO");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Collection<Person> persons = personDAO.getAll();
        req.setAttribute("persons",persons);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userspace/index.jsp");
        requestDispatcher.forward(req,resp);
    }
}
