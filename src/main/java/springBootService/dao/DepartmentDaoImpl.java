package springBootService.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springBootService.mappings.Mappings;
import springBootService.models.Department;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Repository
public class DepartmentDaoImpl implements DepartmentDao{
    private JdbcTemplate template;
    @Autowired
    private Mappings mappings;
    private final String SQL_SELECT_ALL_DEPARTMENS = "SELECT * FROM Departments";
    private final String SQL_SELECT_ONE_DEPARTMENT = "SELECT * FROM Departments where code=?";
    private final String SQL_SELECT_DEPARTMENT_WITH_CHILD = "SELECT * FROM Departments  where code_parent =?";
    public DepartmentDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    @Override
    public Department getByCode(String code) {
        try {
            Department department = template.queryForObject(SQL_SELECT_ONE_DEPARTMENT, mappings.getDepartmentRowMapper(), code);
            return department;
        } catch (EmptyResultDataAccessException e) {
            return null;
            //TODO: иначе реализовать проверку на null
        }
    }
    @Override
    public List<Department> getAll() {
        return template.query(SQL_SELECT_ALL_DEPARTMENS, mappings.getDepartmentRowMapper());
    }
    @Override
    public List<Department> getChildsOfDepartment(String code) {
        return template.query(SQL_SELECT_DEPARTMENT_WITH_CHILD,  mappings.getDepartmentRowMapper(), code);
    }
}