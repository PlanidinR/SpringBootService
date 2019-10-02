package springBootService.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class Position {
    private String code;
    private String position;
    private String code_department;
    private String style;
    private List<Employee> employees = new ArrayList<>();
    public Position(){
    }
    public Position(String code, String position, String code_department, String style){
        this.code = code;
        this.position = position;
        this.code_department = code_department;
        this.style = style;
    }
    public String getCode(){
        return code;
    }
    public String getPosition() {
        return position;
    }
    public String getCode_department() {
        return code_department;
    }
    public String getStyle() {
        return style;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(getCode(), position1.getCode()) &&
                Objects.equals(getPosition(), position1.getPosition()) &&
                Objects.equals(getCode_department(), position1.getCode_department()) &&
                Objects.equals(getStyle(), position1.getStyle()) &&
                Objects.equals(getEmployees(), position1.getEmployees());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getPosition(), getCode_department(), getStyle(), getEmployees());
    }
    @Override
    public String toString() {
        return "Position{" +
                "code='" + code + '\'' +
                ", position='" + position + '\'' +
                ", code_department='" + code_department + '\'' +
                ", style='" + style + '\'' +
                ", employees=" + employees +
                '}';
    }
}
