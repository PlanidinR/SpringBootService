package springBootService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBootService.models.Responser;
import springBootService.services.DepartmentService;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@RestController
@CrossOrigin("*")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/allDepartments")
    public Responser getAllDepartments() {
        return  departmentService.getAll();
    }
    @GetMapping("/department")
    public Responser getDepartmentByCode(@RequestParam(value = "code", required = false) String code) {
        return departmentService.getByCode(code);
    }
    @GetMapping("/childOfDepartment")
    public Responser getDepartmentWithChilds(@RequestParam(value = "code", required = false) String code ,
                                             @RequestParam(value = "parentAttribute", required = false)String parentAttribute,
                                             @RequestParam(value = "attribute", required = false) List<String> attribute)
    {
        return departmentService.getDepartmentWithChilds(code, parentAttribute, attribute);
    }
}
