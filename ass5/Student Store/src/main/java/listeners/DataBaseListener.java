package listeners;

import DB.StoreDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class DataBaseListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        StoreDAO storeDAO = null;
        try {
            storeDAO = new StoreDAO();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        servletContext.setAttribute("database", storeDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
