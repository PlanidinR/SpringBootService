package springBootService.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springBootService.dao.UserDao;
import springBootService.models.User;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.getUserByLogin(login);
        if(user != null){
            return new UserDetailsImpl(user);
        }
        else throw new IllegalArgumentException("Пользователя нет базе");
    }
}
