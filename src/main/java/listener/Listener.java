package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext-init");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext-destroy");
    }
}
