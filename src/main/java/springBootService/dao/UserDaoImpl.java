package springBootService.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springBootService.mappings.Mappings;
import springBootService.models.User;

import javax.sql.DataSource;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Repository
public class UserDaoImpl extends UserDao {
    @Autowired
    private Mappings mappings;
    //language=SQL
    private static final String SQL_SELECT_NAME = "SELECT * FROM users WHERE login = ?";
    //language=SQL
    private final static String SQL_SELECT_USER_BY_USER_ID_FROM_TOKEN = "SELECT distinct us.* FROM users AS us join token AS tok on  tok.user_id=us.id where tok.user_id=? ";
    public UserDaoImpl(DataSource dataSource){
        super(dataSource);
    }
    @Override
    public User getUserByLogin(String login) {
        return getUser(login , SQL_SELECT_NAME, mappings.getUserRowMapper());
    }
    @Override
    public User getUserByUserIdFromToken(Integer user_id) {
        return getUser(user_id, SQL_SELECT_USER_BY_USER_ID_FROM_TOKEN, mappings.getUserRowMapper());
    }
}
