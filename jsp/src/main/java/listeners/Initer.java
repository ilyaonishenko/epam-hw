package listeners;

import DAO.GunDAO;
import DAO.H2.H2GunDAO;
import DAO.common.ConnectionPool;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by wopqw on 25.10.16.
 */
@WebListener
public class Initer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        //noinspection Split Declaration
        String path = servletContext.getRealPath("/") + "WEB-INF/classes/";

        ConnectionPool connectionPool = ConnectionPool.create(path + "db.properties");

        connectionPool.initDb(path+ "h2_jsp.sql");

        GunDAO gunDAO = new H2GunDAO(connectionPool);

        servletContext.setAttribute("gunDAO",gunDAO);
    }
}
