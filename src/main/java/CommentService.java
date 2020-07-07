import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CommentService {
//    private static CommentService INSTANCE;
//
//    private CommentService() {};
//
//    public static CommentService getInstance(){
//        if (INSTANCE == null) {
//            INSTANCE = new CommentService();
//        }
//        return INSTANCE;
//    }

    public void addComment(String createComment){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(createComment);
        t.commit();
        session.close();
    }

    public List<Comment> showCommentList(String readCommentList){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        String question = "from Comment c where c.commentText like : readComment";
        Query query = session.createQuery(question);
        query.setParameter("readComment", "%" + readCommentList + "%");
        List<Comment> commentList = query.list();
        return commentList;
    }

    public void editCommentByUser(String editText, String editUser){
        Session session = BugTrackerUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String updateComment = "update Comment c set c.commentText = : editText " +
                " where c.userComment.userName = : editUser";
        int updateID = session.createQuery(updateComment)
                .setParameter("editText", editText)
                .setParameter("editUser", editUser)
                .executeUpdate();
        t.commit();
        session.close();
    }

}
