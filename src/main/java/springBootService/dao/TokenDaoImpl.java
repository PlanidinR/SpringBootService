package springBootService.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springBootService.mappings.Mappings;
import springBootService.models.Token;

import javax.sql.DataSource;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Repository
public class TokenDaoImpl implements TokenDao {
    private Mappings mappings;
    private JdbcTemplate template;
    //language=sql
    private final static String SQL_SELECT_TOKEN_BY_VALUE = "SELECT * FROM token WHERE value = ?";
    //language=sql
    private final static String SQL_INSERT_TOKEN = "INSERT INTO token(value, user_id)values(?,?)";
    @Autowired
    public TokenDaoImpl(DataSource dataSource, Mappings mappings ) {
        this.mappings = mappings;
        this.template = new JdbcTemplate(dataSource);
    }
    @Override
    public Token getByValue(String value) {
        try {
            Token token= template.queryForObject(SQL_SELECT_TOKEN_BY_VALUE, mappings.getTokenRowMapper(), value);
            return token;
        } catch (EmptyResultDataAccessException e) {
            return null;
            //TODO: иначе реализовать проверку на null
        }
    }
    @Override
    public void saveToken(Token token) {
        template.update(SQL_INSERT_TOKEN, token.getValue(), token.getUser_id());
    }
}
