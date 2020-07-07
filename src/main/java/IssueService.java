import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class IssueService {
//    private static IssueService INSTANCE;
//
//    private IssueService() {};
//
//    public static IssueService getInstance(){
//        if (INSTANCE == null) {
//            INSTANCE = new IssueService();
//        }
//        return INSTANCE;
//    }

    public void addIssue(Issue createIssue){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(createIssue);
        t.commit();
        session.close();
    }

    public String showIssueByTitleString(String readIssueString){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from Issue i where i.title like : readIssueString";
        Query query = session.createQuery(question);
        query.setParameter("readIssueString", readIssueString);
        String issueTitleString = (String) query.getSingleResult();
        session.close();
        return issueTitleString;
    }

    public Issue showIssueByTitle(String readIssue){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from Issue i where i.title like : readIssue";
        Query query = session.createQuery(question);
        query.setParameter("readIssue", "%" + readIssue + "%");
        Issue issueTitle = (Issue) query.getSingleResult();
        session.close();
        return issueTitle;
    }

    public Status showStatusByIssueTitle(String readStatusIssue){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "select i.statusIssue from Issue i where i.title = : readStatusIssue";
        TypedQuery<Status> query = session.createQuery(question);
        query.setParameter("readStatusIssue", readStatusIssue);
        Status statusIssue = query.getSingleResult();
        session.close();
        return statusIssue;
    }

    public void editIssueByTitle(String newTitle, String oldTitle){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String updateIssue = "update Issue i set i.title = : newTitle where i.title = : oldTitle";
        int updateID = session.createQuery(updateIssue)
                .setParameter("newTitle", newTitle)
                .setParameter("oldTitle", oldTitle)
                .executeUpdate();
        t.commit();
        session.close();
    }

    public void deleteIssueByTitle(String deleteIssueTitle){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("delete Issue i where i.title like : deleteIssueTitle");
        query.setParameter("deleteIssueTitle", deleteIssueTitle);
        query.executeUpdate();
        t.commit();
        session.close();
    }
}
