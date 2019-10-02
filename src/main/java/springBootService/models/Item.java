package springBootService.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class Item {
    private String code;
    private String item;
    private List<Employee> employees = new ArrayList<>();
    public Item(){
    }
    public Item(String code, String item) {
        this.code = code;
        this.item = item;
    }
    public String getCode() {
        return code;
    }
    public String getItem() {
        return item;
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
        Item item1 = (Item) o;
        return Objects.equals(getCode(), item1.getCode()) &&
                Objects.equals(getItem(), item1.getItem()) &&
                Objects.equals(getEmployees(), item1.getEmployees());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getItem(), getEmployees());
    }
    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", item='" + item + '\'' +
                ", employees=" + employees +
                '}';
    }
}
