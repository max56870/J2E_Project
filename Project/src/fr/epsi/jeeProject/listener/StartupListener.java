package fr.epsi.jeeProject.listener;
import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IBlogDao;
import fr.epsi.jeeProject.dao.mockImpl.MockBlogDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {

    public StartupListener(){

    }
    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Démarage application");
        IBlogDao blogDao=new MockBlogDao();
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setEmail("contact@aquasys.fr");
        List<Blog> listOfBlogs=blogDao.getBlogs(utilisateur);
        System.out.println("nb blogs:"+listOfBlogs.size());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {


    }
}
