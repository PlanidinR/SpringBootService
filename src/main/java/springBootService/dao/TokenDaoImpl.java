package springBootService.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springBootService.mappings.Mappings;
import springBootService.models.Token;

import javax.sql.DataSource;

@Repository
public class TokenDaoImpl extends TokenDao {

    @Autowired
    private Mappings mappings;

    //language=sql
    private final static String SQL_SELECT_TOKEN_BY_VALUE = "SELECT * FROM vis.token_test WHERE value = ?";
    //language=sql
    private final static String SQL_SELECT_TOKEN_BY_USER_LOGIN = "SELECT * FROM vis.token_test WHERE user_login = ?";
    //language=sql
    private final static String SQL_INSERT_TOKEN = "INSERT into vis.token_test(value, user_login)values(?,?)";
    //language=sql
    private final static String SQL_UPDATE_TOKEN_BY_USER_LOGIN  = "UPDATE vis.token_test SET value = ? WHERE user_login = ?";

    public TokenDaoImpl(DataSource dataSource){
        super(dataSource);
    }

    @Override
    public Token getTokenByValue(String value) {
        return getToken(value, SQL_SELECT_TOKEN_BY_VALUE,mappings.getTokenRowMapper());
    }

    @Override
    public Token getTokenByUserLogin(String user_login) {
        return getToken(user_login, SQL_SELECT_TOKEN_BY_USER_LOGIN, mappings.getTokenRowMapper());
    }

    @Override
    public void saveToken(Token token) {
        template.update(SQL_INSERT_TOKEN, token.getValue(), token.getUser_login());

    }
    @Override
    public void updateToken(Token token){
        template.update(SQL_UPDATE_TOKEN_BY_USER_LOGIN, token.getValue(), token.getUser_login());
    }
}