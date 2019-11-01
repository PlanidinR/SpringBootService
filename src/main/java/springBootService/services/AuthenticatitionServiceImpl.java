package springBootService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springBootService.dao.TokenDao;
import springBootService.dao.UserDao;
import springBootService.dto.UserDto;
import springBootService.forms.LoginForm;
import springBootService.models.Responser;
import springBootService.models.Token;
import springBootService.models.User;


import java.security.SecureRandom;

/**
 * @author Planidin Roman
 * @version v1.0
 */
@Service
public class AuthenticatitionServiceImpl implements AuthenticationService {

    private PasswordEncoder passwordEncoder;
    private TokenDao tokenDao;
    private UserDao userDao;

    @Autowired
    public AuthenticatitionServiceImpl(PasswordEncoder passwordEncoder, TokenDao tokenDao, UserDao userDao) {
        this.passwordEncoder = passwordEncoder;
        this.tokenDao = tokenDao;
        this.userDao = userDao;
    }

    @Override
    public Responser getAuthentication(LoginForm loginForm) {
        User user = userDao.getUserByLogin(loginForm.getLogin());
        Responser responser = new Responser();
        if (user == null){
            responser.setMessage("Ошибка авторизации: пользователь не найден");
            return responser;}
        else if (!passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())){
            responser.setMessage("Ошибка авторизации: данные пользователя введены неверно");
            return responser;
        }
        Token tokenInBase = tokenDao.getTokenByUserLogin(user.getLogin());
        Token newToken = new Token(createToken(), user.getLogin());
        if(tokenInBase == null){
            tokenDao.saveToken(newToken);
        }
        else {
            tokenDao.updateToken(newToken);
        }
        UserDto userDto = new UserDto(user.getLogin(), user.getName(), user.getRole(), user.getState(), newToken.getValue());
        responser.setResult(userDto);
        responser.setMessage("200");
        return responser;
    }

    private String createToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[32];
        random.nextBytes(bytes);
        String tokenRandom = bytes.toString();
        return tokenRandom;
        //TODO: учесть уникальность токена
    }
}