package springBootService.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springBootService.mappings.Mappings;
import springBootService.models.Position;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Repository
public class PositionDaoImpl implements PositionAndItemDao<Position> {
    private JdbcTemplate template;
    @Autowired
    private Mappings mappings;
    //language=SQL
    private final String SQL_SELECT_ALL_POSITION_BY_CODE_DEPARTMENT = "SELECT * FROM Positions WHERE code_department=?";
    public PositionDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Position> getAllByCodeDepartment(String code_department) {
        return template.query(SQL_SELECT_ALL_POSITION_BY_CODE_DEPARTMENT, mappings.getPositionRowMapper(), code_department);
    }
}
