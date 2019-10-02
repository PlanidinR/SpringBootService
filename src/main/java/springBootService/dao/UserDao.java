package springBootService.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import springBootService.models.User;

import javax.sql.DataSource;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public abstract class UserDao<T> {
    public JdbcTemplate template;
    public UserDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    protected User getUser(T code, String sql, RowMapper rowMapper) {
        try {
            User user = (User)(template.queryForObject(sql, rowMapper, code));
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
            //TODO: иначе реализоваться проверку на null
        }
    }
    public abstract User getUserByUserIdFromToken(Integer user_id);
    public abstract User getUserByLogin(String login);
}
