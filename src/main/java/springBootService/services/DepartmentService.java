package springBootService.services;


import springBootService.models.Responser;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public interface DepartmentService {

    Responser getByCode(String code);
    Responser getAll();
    Responser getDepartmentWithChilds(String code, String parentAttribute, List<String> attribute);
}


