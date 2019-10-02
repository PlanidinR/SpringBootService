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
public class AuthenticatitionServiceImpl implements AuthenticationService{

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
    public Responser getAuthenticatedOrNot(LoginForm loginForm) {
        User user = userDao.getUserByLogin(loginForm.getLogin());
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String tokenRandom = bytes.toString();
        if(user != null )
            if(passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())) {
                Token token =  new Token(tokenRandom, user.getId());
                token.setUser(user);
                tokenDao.saveToken(token);
                UserDto userDto = new UserDto(user.getLogin(), user.getName(), user.getRole(), user.getState(), token.getValue());
                Responser responser = new Responser();
                responser.setResult(userDto);
                responser.setMessage("200");
                return responser;
            }
        throw new IllegalArgumentException("Пользователя нет в базе");
    }
}
