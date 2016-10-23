package listeners;

import DAO.PersonDAO;
import DAO.common.ConnectionPool;
import DAO.h2.H2PersonDAO;
import lombok.extern.java.Log;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by wopqw on 24.10.16.
 */

@Log
@WebListener
public class Initer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();

        //noinspection Split Declaration
        String path = servletContext.getRealPath("/") + "WEB-INF/classes/";

        ConnectionPool connectionPool = ConnectionPool.create(path + "db.properties");

        connectionPool.initDb(path+"h2.sql");

        PersonDAO personDAO = new H2PersonDAO(connectionPool);

        servletContext.setAttribute("personDAO",personDAO);
    }
}
