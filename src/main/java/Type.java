import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeId")
    public int typeId;

    @Column(name = "typeName")
    public String typeName;

    @OneToMany(mappedBy = "typeIssue")
    public List<Issue> typeIssueList;

    public Type(String typeName) {
        this.typeName = typeName;

    }

    public Type() {
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
