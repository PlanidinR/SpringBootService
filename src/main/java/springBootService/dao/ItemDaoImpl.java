package springBootService.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springBootService.mappings.Mappings;
import springBootService.models.Item;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Repository
public class ItemDaoImpl implements PositionAndItemDao<Item>{
    private JdbcTemplate template;
    @Autowired
    private Mappings mappings;
    //language=SQL
    private final String SQL_SELECT_ALL_ITEMS_BY_CODE_DEPARTMENT = "SELECT items.code, items.item FROM Items AS items \n" +
            "JOIN Items_Positions AS item_posit ON items.code = item_posit.code_item\n" +
            "JOIN Positions AS posit ON item_posit.code_position = posit.code \n" +
            "WHERE  posit.code_department = ?";
    public ItemDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Item> getAllByCodeDepartment(String code_department) {
        return template.query(SQL_SELECT_ALL_ITEMS_BY_CODE_DEPARTMENT, mappings.getItemRowMapper(), code_department);
    }
}
