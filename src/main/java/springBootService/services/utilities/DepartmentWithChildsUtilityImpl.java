package springBootService.services.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springBootService.models.Department;

import java.util.*;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Component
public class DepartmentWithChildsUtilityImpl implements DepartmentWithChildsUtility {
    @Autowired
    private BuilderDepartmentUtility builderDepartment;
    @Override
    public Department getChildsOfDepartment(String code, String parentAttribute, List<String> attribute) {
        Department department = builderDepartment.buildDepartment(code, parentAttribute, attribute);
        if (department == null) {
            return null;
        }
        //TODO: придумать решение без проверки на null
        department.setChild(createTreeWithChildsOfDepartment(code, parentAttribute, attribute));
        return department;
    }
    private List<Department> createTreeWithChildsOfDepartment(String code, String parentAttribute, List<String> attribute){
        List<Department> childsOfDepartment = builderDepartment.buildListChildsOfDepartment(code, parentAttribute, attribute);
        List<Department> childsOfDepartmentFirstLevel = new ArrayList<>(childsOfDepartment);
        for (int i = 0; i < childsOfDepartment.size(); i++) { // цикл по списку детей подразделения
            Department child = childsOfDepartment.get(i);
            List<Department> childsOfChild = builderDepartment.buildListChildsOfDepartment(child.getCode(), parentAttribute, attribute);
            child.setChild(childsOfChild);
            childsOfDepartment.addAll(childsOfChild);
        }
        return childsOfDepartmentFirstLevel;
    }
    public void setBuilderDepartmentImpl(BuilderDepartmentUtilityImpl builderDepartment) { this.builderDepartment = builderDepartment; }
}
