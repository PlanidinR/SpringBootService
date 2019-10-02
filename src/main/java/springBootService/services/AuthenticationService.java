package springBootService.services;

import springBootService.forms.LoginForm;
import springBootService.models.Responser;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public interface AuthenticationService{
    Responser getAuthenticatedOrNot(LoginForm loginForm);
}
