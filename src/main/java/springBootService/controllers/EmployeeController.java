package springBootService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springBootService.models.Responser;
import springBootService.services.AttributeService;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Qualifier("employeeServiceImpl")
    @Autowired
    private AttributeService employeeService;
    @GetMapping("/employee")
    public Responser getEmployeeByCode(@RequestParam(value = "code", required = false) String code){
        return employeeService.getByCode(code);
    }
}


