package springBootService.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import springBootService.mappings.Mappings;
import springBootService.models.Employee;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Repository
public class EmployeeDao extends AttributeDao<Employee> {
    @Autowired
    private Mappings mappings;
    //language=SQL
    private final String SQL_SELECT_ALL_EMPLOYEES_BY_CODE_ITEM = "SELECT * FROM Employees WHERE code_item=?";
    private final String SQL_SELECT_ALL_EMPLOYEES_BY_CODE_POSITION = "SELECT empl.*" +
            "FROM Employees AS empl\n" +
            "JOIN Items_Positions AS itm_pos ON empl.code_item = itm_pos.code_item\n" +
            "WHERE itm_pos.code_position = ?";
    //language=SQL
    private final String SQL_SELECT_ONE_EMPLOYEES = "SELECT * FROM Employees where code=?";
    public EmployeeDao(DataSource dataSource) {
        super(dataSource);
    }
    @Override
    public List<Employee> getAllByCodeItem(String code_item) {
        return template.query(SQL_SELECT_ALL_EMPLOYEES_BY_CODE_ITEM, mappings.getEmployeeRowMapper(), code_item);
    }
    @Override
    public List<Employee> getAllByCodePosition(String code_position) {
        return template.query(SQL_SELECT_ALL_EMPLOYEES_BY_CODE_POSITION, mappings.getEmployeeRowMapper(), code_position);
    }
    public Employee getByCode(String code) {
        return  getEntity(code, SQL_SELECT_ONE_EMPLOYEES, mappings.getEmployeeRowMapper());
    }
}
