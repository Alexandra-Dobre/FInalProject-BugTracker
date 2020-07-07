import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issueId")
    public int issueId;

    @Column(name = "title")
    public String title;

    @Column(name = "descriptionIssue")
    public String descriptionIssue;

    @Column(name = "dateCreated")
    public Date dateCreated;

    @OneToMany(mappedBy = "issueComment")
    public List<Comment> commentIssueList;

    @ManyToOne
    @JoinColumn(name = "statusId")
    public Status statusIssue;

    @ManyToOne
    @JoinColumn(name = "typeId")
    public Type typeIssue;

    @ManyToOne
    @JoinColumn(name = "projectId")
    public Project projectIssue;

    @ManyToOne
    @JoinColumn(name = "submitterId")
    public User userIssue;

    public Issue(String title, String descriptionIssue, Date dateCreated, Status statusIssue,
                 Type typeIssue, Project projectIssue, User userIssue) {
        this.title = title;
        this.descriptionIssue = descriptionIssue;
        this.dateCreated = dateCreated;
        this.statusIssue = statusIssue;
        this.typeIssue = typeIssue;
        this.projectIssue = projectIssue;
        this.userIssue = userIssue;
    }

    public Issue(String title, Status statusIssue, Type typeIssue) {
        this.title = title;
        this.statusIssue = statusIssue;
        this.typeIssue = typeIssue;
    }

    public Issue() {
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", title='" + title + '\'' +
                ", descriptionIssue='" + descriptionIssue + '\'' +
                ", dateCreated=" + dateCreated +
                ", statusIssue=" + statusIssue +
                ", typeIssue=" + typeIssue +
                ", projectIssue=" + projectIssue +
                ", userIssue=" + userIssue +
                '}';
    }
}
