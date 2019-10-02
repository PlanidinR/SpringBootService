package springBootService.services.utilities;

import springBootService.models.Department;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public interface BuilderDepartmentUtility {
    Department buildDepartment(String code , String parentAttribute, List<String> attribute);
    List<Department> buildListChildsOfDepartment(String code, String parentAttribute, List<String> attribute);
}
