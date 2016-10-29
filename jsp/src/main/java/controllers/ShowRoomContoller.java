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
import java.util.HashSet;
import java.util.Map;

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();

        Collection<Gun> guns = new HashSet<>();

        guns = gunDAO.getAll();

        Gun gun = guns.stream()
                .filter(g -> g.getId() == Long.parseLong(parameterMap.get("id")[0]))
                .findFirst().get();

        log.info(gun.toString());
        gun.setName(parameterMap.get("name")[0]);
        gun.setCaliber(Double.parseDouble(parameterMap.get("caliber")[0]));
        gun.setPrice(Double.parseDouble(parameterMap.get("price")[0]));

        log.info(gun.toString());

        gunDAO.update(gun);

        doGet(request, response);

    }
}
