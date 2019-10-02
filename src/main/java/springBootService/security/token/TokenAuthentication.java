package springBootService.security.token;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class TokenAuthentication implements Authentication {
    private String userName;
    private boolean isAuthenticated;
    private UserDetails userDetails;
    public TokenAuthentication(String userName) {
        this.userName = userName;
    }
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities();
    }
    @Override
    public Object getCredentials() {
        return null;
    }
    @Override
    public Object getDetails() {
        return userDetails;
    }
    @Override
    public Object getPrincipal() {
        return null;
    }
    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated  = isAuthenticated;
    }
    @Override
    public String getName() {
        return userName;
    }
}
