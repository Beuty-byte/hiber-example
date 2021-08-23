package hibernate_one_to_many_bi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "departments")
public class Department {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employeeList;

    public Department() {
    }

    public Department(String departmentName, int maxSalary, int minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public void addEmployeeToDepartment(Employee employee){
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
        employee.setDepartment(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                maxSalary == that.maxSalary &&
                minSalary == that.minSalary &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(employeeList, that.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName, maxSalary, minSalary, employeeList);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
