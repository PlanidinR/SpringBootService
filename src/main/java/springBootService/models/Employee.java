package springBootService.models;

import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class Employee {
    private String code;
    private String employee;
    private String code_item;
    private String kis_code;
    public Employee(String code, String employee, String code_item, String kis_code) {
        this.code = code;
        this.employee = employee;
        this.code_item = code_item;
        this.kis_code = kis_code;
    }
    public String getCode() { return code; }
    public String getEmployee() {
        return employee;
    }
    public String getCode_item() {
        return code_item;
    }
    public String getKis_code() {
        return kis_code;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee1 = (Employee) o;
        return Objects.equals(getCode(), employee1.getCode()) &&
                Objects.equals(getEmployee(), employee1.getEmployee()) &&
                Objects.equals(getCode_item(), employee1.getCode_item()) &&
                Objects.equals(getKis_code(), employee1.getKis_code());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getEmployee(), getCode_item(), getKis_code());
    }
    @Override
    public String toString() {
        return "Employee{" +
                "code='" + code + '\'' +
                ", employee='" + employee + '\'' +
                ", code_item='" + code_item + '\'' +
                ", kis_code='" + kis_code + '\'' +
                '}';
    }
}
