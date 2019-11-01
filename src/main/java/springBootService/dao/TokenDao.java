package springBootService.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import springBootService.models.Token;

/**
 * @author Planidin Roman
 * @version v1.0
 */

import javax.sql.DataSource;

public abstract class TokenDao<T> {

    public JdbcTemplate template;

    public TokenDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    protected Token getToken(T value, String sql, RowMapper rowMapper){
        try {
            Token token = (Token) (template.queryForObject(sql, rowMapper, value));
            return token;
        } catch (EmptyResultDataAccessException e) {
            return null;
            //TODO: иначе реализовать проверку на null. Лучше заменить на Optional
        }
    }

    public abstract Token getTokenByValue(String value);
    public abstract Token getTokenByUserLogin(String user_login);
    public abstract void saveToken(Token token);
    public abstract void updateToken(Token token);

}
