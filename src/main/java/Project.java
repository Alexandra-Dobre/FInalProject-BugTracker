import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    public int projectId;

    @Column(name = "nameProject")
    public String nameProject;

    @Column(name = "identifierProject")
    public String identifierProject;

    @Column(name = "descriptionProject")
    public String descriptionProject;

    @OneToMany(mappedBy = "projectIssue")
    public List<Issue> projectIssueList;

    public Project(String nameProject, String identifierProject, String descriptionProject) {
        this.nameProject = nameProject;
        this.identifierProject = identifierProject;
        this.descriptionProject = descriptionProject;

    }

    public Project(String nameProject) {
        this.nameProject = nameProject;

    }

    public Project(String nameProject, String descriptionProject) {
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
}

    public Project(int projectId, String identifierProject) {
        this.projectId = projectId;
        this.identifierProject = identifierProject;
    }

    public Project(int projectId, String identifierProject, String descriptionProject) {
        this.projectId = projectId;
        this.identifierProject = identifierProject;
        this.descriptionProject = descriptionProject;
    }

    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", nameProject='" + nameProject + '\'' +
                ", identifierProject=" + identifierProject +
                ", descriptionProject='" + descriptionProject + '\'' +
                '}';
    }
}
