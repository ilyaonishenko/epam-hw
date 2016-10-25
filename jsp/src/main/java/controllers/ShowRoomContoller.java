package controllers;

import DAO.GunDAO;
import lombok.extern.java.Log;
import models.Gun;

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
 * Created by wopqw on 25.10.16.
 */
@Log
@WebServlet("/showroom/")
public class ShowRoomContoller extends HttpServlet {

    private GunDAO gunDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {

        gunDAO = (GunDAO) config.getServletContext().getAttribute("gunDAO");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Collection<Gun> guns = gunDAO.getAll();

        System.out.println(guns.size());

        req.setAttribute("guns", guns);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/showroom/index.jsp");
        requestDispatcher.forward(req,resp);
    }
}
