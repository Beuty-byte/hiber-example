package hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "children")
public class Child {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section", joinColumns = @JoinColumn(name = "child_id")
    ,inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sectionList;

    public Child() {
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addSection(Section section){
        if(sectionList == null){
            sectionList = new ArrayList<>();
        }
        sectionList.add(section);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return id == child.id &&
                age == child.age &&
                Objects.equals(name, child.name) &&
                Objects.equals(sectionList, child.sectionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sectionList);
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
