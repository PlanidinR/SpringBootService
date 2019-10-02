package springBootService.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import springBootService.models.User;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public class UserDetailsImpl implements UserDetails {
    private User user;
    public  UserDetailsImpl(User user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRole = user.getRole();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
        return Collections.singletonList(authority);
    }
    @Override
    public String getPassword() {
        return user.getHashPassword();
    }
    @Override
    public String getUsername() {
        return user.getName();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return !user.getState().equals("BANNED");
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return user.getState().equals("ACTIVE");
    }
    public User getUser() {
        return user;
    }
}

