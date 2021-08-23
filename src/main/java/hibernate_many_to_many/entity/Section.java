package hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section", joinColumns = @JoinColumn(name = "section_id")
            ,inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Child> childList;

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public void addChild(Child child){
        if(childList == null){
            childList = new ArrayList<>();
        }
        childList.add(child);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id == section.id &&
                Objects.equals(name, section.name) &&
                Objects.equals(childList, section.childList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, childList);
    }
}
