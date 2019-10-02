package springBootService.dao;

import springBootService.models.Department;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public interface DepartmentDao {
    Department getByCode(String code);
    List<Department> getAll();
    List<Department> getChildsOfDepartment(String code);
}

