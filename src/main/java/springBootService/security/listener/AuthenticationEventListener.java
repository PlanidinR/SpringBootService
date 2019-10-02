package springBootService.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Component
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {
    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {
        if (authenticationEvent instanceof InteractiveAuthenticationSuccessEvent) {
            return;
        }
        Authentication authentication = authenticationEvent.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getDetails();
        String auditMessage = "Login attempt with username: " +
                userDetails.getUsername() + " with token - " +
                authentication.getName()+
                "\t\tSuccess: " + authentication.isAuthenticated();
        System.out.println(auditMessage);
    }
}
