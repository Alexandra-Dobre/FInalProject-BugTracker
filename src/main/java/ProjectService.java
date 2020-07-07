import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.*;
import java.util.List;

public class ProjectService {
//    private static ProjectService INSTANCE;
//
//    ProjectService() {};
//
//    public static ProjectService getInstance(){
//        if (INSTANCE == null) {
//            INSTANCE = new ProjectService();
//        }
//        return INSTANCE;
//    }


    public void addProject(Project createProject){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(createProject);
        t.commit();
        session.close();
    }

    public Project createProject(String projectName, String projectIdentifier){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Project myNewProject = new Project(projectName, projectIdentifier);
        Transaction t = session.beginTransaction();
        session.save(myNewProject);
        t.commit();
        session.close();
        return myNewProject;
    }


    public Project getProjectByName(String projectName) {
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String queryString = "select p from Project p where p.nameProject = :nameProject";
        TypedQuery<Project> query = session.createQuery(queryString, Project.class);
        query.setParameter("nameProject", projectName);
        Project foundProject;
        try {
            foundProject = query.getSingleResult();
        } catch (NoResultException nre){
            return null;
        } finally {
            session.close();
        }

        return foundProject;

    }

    public List<Project> getProjectByNameList(String projectByNameList){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from Project p where p.nameProject like : projectName";
        Query query = session.createQuery(question);
        query.setParameter("projectName","%" + projectByNameList + "%");
        List<Project> projectList = query.getResultList();
        return projectList;

    }

    public Project getProjectById(int id) {
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Project foundProject = session.find(Project.class, id);
        session.close();
        return foundProject;
    }

    public List<String> getProjectByIdentifierString(String projectByIdentifier){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from Project p where p.identifierProject = : projectIdentifier";
        TypedQuery<String> query = session.createQuery(question);
        query.setParameter("projectIdentifier", "%" + projectByIdentifier + "%");
        List<String> projectByIdentifierList = query.getResultList();
        return projectByIdentifierList;
    }

    public void editProjectByName(String newName, String oldName){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String update = "update Project p set p.nameProject = : newName where p.nameProject = : oldName";
        int updateID = session.createQuery(update)
                .setParameter("newName", newName)
                .setParameter("oldName", oldName)
                .executeUpdate();
        t.commit();
        session.close();
    }

    public void deleteProject (Project eraseProject){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(eraseProject);
        t.commit();
        session.close();
    }

    public void deleteProjectByName(String projectName){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("delete Project p where p.nameProject like : projectName");
        query.setParameter("projectName", projectName);
        query.executeUpdate();
        t.commit();
        session.close();
    }
}

