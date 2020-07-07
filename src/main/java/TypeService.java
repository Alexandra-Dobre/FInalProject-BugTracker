import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

public class TypeService {
//    private static TypeService INSTANCE;
//
//    private TypeService() {};
//
//    public static TypeService getInstance(){
//        if (INSTANCE == null) {
//            INSTANCE = new TypeService();
//        }
//        return INSTANCE;
//    }

    public void addType(Type createType) {
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(createType);
        t.commit();
        session.close();
    }

    public List<Type> showTypeList(String readTypeList) {
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from Type t where t.typeName like : readTypeList";
        Query query = session.createQuery(question);
        query.setParameter("readTypeList", "%" + readTypeList + "%");
        List<Type> typeList = query.list();
        return typeList;

    }

    public Type showTypeByName(String readTypeByName) {
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from Type t where t.typeName = : readTypeByName";
        TypedQuery<Type> query = session.createQuery(question);
        query.setParameter("readTypeByName", readTypeByName);
        Type showType = query.getSingleResult();
        return showType;

    }

    public void editTypeByName(String newName,  String oldName) {
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String updateType = "update Type t set  t.typeName = : newName where t.typeName = : oldName" ;
        int updatedID = session.createQuery( updateType )
                .setParameter( "newName", newName)
                .setParameter("oldName", oldName)
                .executeUpdate();
        t.commit();
        session.close();
    }

    public void deleteTypeByName(String deleteTypeName){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("delete Type t where t.typeName like : nameType");
        query.setParameter("nameType", deleteTypeName);
        query.executeUpdate();
        t.commit();
        session.close();
    }


}
