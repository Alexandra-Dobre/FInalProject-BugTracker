import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserService {
//    private static UserService INSTANCE;
//
//    private UserService() {};
//
//    public static UserService getInstance(){
//        if (INSTANCE == null) {
//            INSTANCE = new UserService();
//        }
//        return INSTANCE;
//    }

    public void addUser (User createUser){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(createUser);
        t.commit();
        session.close();

    }

    public User showUser(String readUser){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from User u where u.userName like: name";
        Query query = session.createQuery(question);
        query.setParameter("name", "%" + readUser + "%" );
        User userName = (User) query.list();
        return userName;
    }

    public List<User> showUserList (String readUserList){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from User u where u.userName like: nameList";
        Query query = session.createQuery(question);
        query.setParameter("nameList", "%" + readUserList + "%" );
        List<User> userNameList = query.list();
        session.close();
        return userNameList;
    }

    public void editUserByName(String newName, String oldName){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String updateUserName = "update User u set u.userName = : newName where u.userName = : oldName" ;
        int updateID = session.createQuery(updateUserName)
                .setParameter("newName", newName)
                .setParameter("oldName", oldName)
                .executeUpdate();
        t.commit();
        session.close();
    }

    public void deleteUser (User eraseUser){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(eraseUser);
        t.commit();
        session.close();
    }

    public void deleteUserByName (String eraseUserByName){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String question = "delete User u where u.userName like : eraseUserByName";
        Query query = session.createQuery(question);
        query.setParameter("eraseUserByName", eraseUserByName);
        query.executeUpdate();
        t.commit();
        session.close();

    }
}
