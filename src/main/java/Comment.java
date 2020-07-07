import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    public int commentId;

    @Column(name = "commentText")
    public String commentText;

    @Column(name = "dateTimeCreated")
    public LocalDateTime dateTimeCreated;

    @ManyToOne
    @JoinColumn(name = "submitterId")
    public User userComment;

    @ManyToOne
    @JoinColumn(name = "issueId")
    public Issue issueComment;

    public Comment(String commentText, User userComment, Issue issueComment) {
        this.commentText = commentText;
        this.userComment = userComment;
        this.issueComment = issueComment;
        this.dateTimeCreated = LocalDateTime.now();
    }

    public Comment(String commentText, User userComment) {
        this.commentText = commentText;
        this.userComment = userComment;
        this.dateTimeCreated = LocalDateTime.now();
    }

    public Comment(User userComment, Issue issueComment) {
        this.userComment = userComment;
        this.issueComment = issueComment;
        this.dateTimeCreated = LocalDateTime.now();
    }

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentText='" + commentText + '\'' +
                ", dateTimeCreated=" + dateTimeCreated +
                ", userComment=" + userComment +
                ", issueComment=" + issueComment +
                '}';
    }
}
