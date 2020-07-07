import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "statusId")
    public int statusId;

    @Column(name = "statusName")
    public String statusName;

    @OneToMany(mappedBy = "statusIssue")
    public List<Issue> statusIssueList;

    public Status(String statusName) {
        this.statusName = statusName;

    }

    public Status() {
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
