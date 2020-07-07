import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    public int userId;

    @Column(name = "userName")
    public String userName;

    @OneToMany(mappedBy = "userComment")
    public List<Comment> commentUserList;

    @OneToMany(mappedBy = "userIssue")
    public List<Issue> userIssueList;

    public User(String userName) {
        this.userName = userName;

    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
