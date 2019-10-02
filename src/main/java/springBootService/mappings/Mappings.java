package springBootService.mappings;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import springBootService.models.*;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Component
public class Mappings {
    private RowMapper<Department> departmentRowMapper = ((resultSet, i)
            -> new Department(
            resultSet.getString("code"),
            resultSet.getString("department"),
            resultSet.getString("section"),
            resultSet.getString("code_parent"),
            resultSet.getInt("degree")
    ));
    private RowMapper<Employee> employeeRowMapper = ((resultSet, i)
            -> new Employee(
            resultSet.getString("code"),
            resultSet.getString("employee"),
            resultSet.getString("code_item"),
            resultSet.getString("kis_code")
    ));
    private RowMapper<Position> positionRowMapper = ((resultSet, i)
            -> new Position(
            resultSet.getString("code"),
            resultSet.getString("position"),
            resultSet.getString("code_department"),
            resultSet.getString("style")
    ));
    private RowMapper<Item> itemRowMapper = ((resultSet, i)
            -> new Item(
            resultSet.getString("code"),
            resultSet.getString("item")
    ));
    private RowMapper<User> userRowMapper = ((resultSet, i)
            -> new User(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("login"),
            resultSet.getString("password"),
            resultSet.getString("role"),
            resultSet.getString("state")
    ));
    private RowMapper<Token> tokenRowMapper = ((resultSet, i)
            -> new Token(
            resultSet.getString("value"),
            resultSet.getInt("user_id")
    ) );
    public RowMapper<Item> getItemRowMapper() { return itemRowMapper; }
    public RowMapper<Department> getDepartmentRowMapper() {
        return departmentRowMapper;
    }
    public RowMapper<Employee> getEmployeeRowMapper() {
        return employeeRowMapper;
    }
    public RowMapper<Position> getPositionRowMapper() {
        return positionRowMapper;
    }
    public RowMapper<User> getUserRowMapper() { return userRowMapper; }
    public RowMapper<Token> getTokenRowMapper() { return tokenRowMapper;
    }
}
