package springBootService.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class Department {
    private String code;
    private String department;
    private String section;
    private String code_parent;
    private Integer degree;
    private List<Department> child = new ArrayList<>();
    private List<Position> position = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    public Department() {
    }
    public Department(String code, String department, String section, String code_parent, Integer degree) {
        this.code = code;
        this.department = department;
        this.section = section;
        this.code_parent = code_parent;
        this.degree = degree;
    }
    public String getCode() {
        return code;
    }
    public String getDepartment() {
        return department;
    }
    public String getSection() {
        return section;
    }
    public String getCode_parent() {
        return code_parent;
    }
    public Integer getDegree() {
        return degree;
    }
    public List<Position> getPosition() {
        return position;
    }
    public List<Item> getItems() { return items; }
    public List<Department> getChild() { return child; }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void setPosition(List<Position> position) {
        this.position = position;
    }
    public void setChild(List<Department> child) { this.child = child; }
    @Override
    public String toString() {
        return "Department{" +
                "code='" + code + '\'' +
                ", department='" + department + '\'' +
                ", section='" + section + '\'' +
                ", code_parent='" + code_parent + '\'' +
                ", degree=" + degree +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getDepartment(), that.getDepartment()) &&
                Objects.equals(getSection(), that.getSection()) &&
                Objects.equals(getCode_parent(), that.getCode_parent()) &&
                Objects.equals(getDegree(), that.getDegree()) &&
                Objects.equals(getChild(), that.getChild()) &&
                Objects.equals(getPosition(), that.getPosition()) &&
                Objects.equals(getItems(), that.getItems());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getDepartment(), getSection(), getCode_parent(), getDegree(), getChild(), getPosition(), getItems());
    }
}
