package springBootService.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import springBootService.dao.TokenDao;
import springBootService.dao.UserDao;
import springBootService.models.Token;
import springBootService.models.User;
import springBootService.security.token.TokenAuthentication;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {
    private TokenDao tokenDao;
    private UserDetailsService userDetailsService;
    private UserDao userDao;
    @Autowired
    public TokenAuthenticationProvider(TokenDao tokenDao, @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, UserDao userDao) {
        this.tokenDao = tokenDao;
        this.userDetailsService = userDetailsService;
        this.userDao = userDao;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication)authentication;
        Token tokenCandidate = tokenDao.getByValue(tokenAuthentication.getName());
        User user = userDao.getUserByUserIdFromToken(tokenCandidate.getUser_id());
        if (tokenCandidate != null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
            tokenAuthentication.setUserDetails(userDetails);
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        } else throw new IllegalArgumentException("Bad token");
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
