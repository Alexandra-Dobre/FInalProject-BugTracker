import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class StatusService {
//    private static StatusService INSTANCE;
//
//    private StatusService() {};
//
//    public static StatusService getInstance(){
//        if (INSTANCE == null) {
//            INSTANCE = new StatusService();
//        }
//        return INSTANCE;
//    }

    public void addStatus(Status createStatus) {
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(createStatus);
        transaction.commit();
        session.close();

    }

    public Status showStatusByName(String readStatus){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from Status s where s.statusName like : nameStatus";
        TypedQuery<Status> query = session.createQuery(question);
        query.setParameter("nameStatus", "%" + readStatus + "%");
        Status statusName = query.getSingleResult();
        session.close();
        return statusName;
    }

    public List<Status> showStatusList(String statusList){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from Status s where s.statusName like : statusNameList";
        Query query = session.createQuery(question);
        query.setParameter("statusNameList", "%" + statusList + "%");
        List<Status> statusNameList = query.getResultList();
        session.close();
        return statusNameList;
    }

    public void editStatusByName(String newName, String oldName){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String updateStatus = "update Status s set s.statusName = : newName where s.statusName = : oldName";
        int updateID = session.createQuery(updateStatus)
                .setParameter("newName", newName)
                .setParameter("oldName", oldName)
                .executeUpdate();
        t.commit();
        session.close();

    }

    public void deleteStatusByName(String deleteStatus){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("delete Status s where s.statusName like : nameStatus");
        query.setParameter("nameStatus", deleteStatus);
        query.executeUpdate();
        t.commit();
        session.close();
    }

}
