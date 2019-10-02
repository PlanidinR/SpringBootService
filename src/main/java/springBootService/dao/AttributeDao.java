package springBootService.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public abstract class AttributeDao<T> {
    public JdbcTemplate template;
    public AttributeDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    protected T getEntity(String code, String sql, RowMapper rowMapper) {
        try {
            T entity = (T) template.queryForObject(sql, rowMapper, code);
            return entity;
        } catch (EmptyResultDataAccessException e) {
            return null;
            //TODO: иначе реализоваться проверку на null
        }
    }
    public abstract List<T> getAllByCodeItem(String code_item);
    public abstract List<T> getAllByCodePosition(String code_position);
    public abstract T getByCode(String code);
}

