import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class BugTrackerUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Comment.class);
                configuration.addAnnotatedClass(CommentService.class);
                configuration.addAnnotatedClass(Issue.class);
                configuration.addAnnotatedClass(IssueService.class);
                configuration.addAnnotatedClass(Project.class);
                configuration.addAnnotatedClass(ProjectService.class);
                configuration.addAnnotatedClass(Status.class);
                configuration.addAnnotatedClass(StatusService.class);
                configuration.addAnnotatedClass(Type.class);
                configuration.addAnnotatedClass(TypeService.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(UserService.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
