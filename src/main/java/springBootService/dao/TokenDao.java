package springBootService.dao;

import springBootService.models.Token;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public interface TokenDao {
    Token getByValue(String value);
    void saveToken(Token token);
}
