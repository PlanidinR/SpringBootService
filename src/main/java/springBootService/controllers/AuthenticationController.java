package springBootService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBootService.dto.UserDto;
import springBootService.forms.LoginForm;
import springBootService.models.Responser;
import springBootService.services.AuthenticationService;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@RestController
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("/loginPage")
    public Responser loginPage (HttpServletResponse httpServletResponse, @RequestBody LoginForm loginForm) throws IOException {
        Responser responser = authenticationService.getAuthentication(loginForm);
        if(responser.getResult() == null){
            return responser;
        }
        UserDto userDto =  (UserDto) responser.getResult();
        httpServletResponse.addHeader("x-auth-token", userDto.getToken());
        httpServletResponse.setHeader("x-auth-token", userDto.getToken());
        return responser;
    }
}
