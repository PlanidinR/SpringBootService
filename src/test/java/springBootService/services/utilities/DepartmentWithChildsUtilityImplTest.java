package springBootService.services.utilities;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import springBootService.models.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@SpringBootTest(classes = DepartmentWithChildsUtilityImplTest.class)
@RunWith(SpringRunner.class)
class DepartmentWithChildsUtilityImplTest {
    private Map<String, Department> baseWithDepartment = new HashMap<>();
    private final Department DEPARTMENT_WITH_CHILDS = getTrueResult();
    private final Department DEPARTMENT_NULL = null;
    private List<String> listTest;
    private DepartmentWithChildsUtilityImpl departmentWithChildsUtility = new DepartmentWithChildsUtilityImpl();
    @MockBean
    private BuilderDepartmentUtilityImpl builderDepartment;
    @Test
    void createHashMapWithDepartmentAndChildsTest() {
        List<Department> allChilds = new ArrayList<>();
        allChilds.add(addInMapDepartments().get("п2"));
        allChilds.add(addInMapDepartments().get("п3"));
        when(builderDepartment.buildListChildsOfDepartment("п1", "test", listTest)).thenReturn(allChilds);
        allChilds = new ArrayList<>();
        allChilds.add(addInMapDepartments().get("п4"));
        when(builderDepartment.buildListChildsOfDepartment("п2", "test", listTest)).thenReturn(allChilds);
        when(builderDepartment.buildDepartment("п1", "test", listTest)).thenReturn(fakeDaoGetDepartmentByCode("п1"));
        departmentWithChildsUtility.setBuilderDepartmentImpl(builderDepartment);
        assertEquals(departmentWithChildsUtility.getChildsOfDepartment("п1", "test", listTest), DEPARTMENT_WITH_CHILDS);
    }
    @Test
    void createHashMapWithDepartmentAndChildsWhereResultNullTest() {
        when(builderDepartment.buildListChildsOfDepartment("test", "test", listTest)).thenReturn(new ArrayList<>());
        when(builderDepartment.buildDepartment("test", "test", listTest)).thenReturn(fakeDaoGetDepartmentByCode("test"));
        departmentWithChildsUtility.setBuilderDepartmentImpl(builderDepartment);
        assertEquals(departmentWithChildsUtility.getChildsOfDepartment("test", "test", listTest), DEPARTMENT_NULL);
    }
    private Department fakeDaoGetDepartmentByCode(String code) {
        return addInMapDepartments().get(code);
    }
    private Department getTrueResult() {
        Department department = new Department("п1", "тест1", "физ", null, 1);
        Department departmentChildWhichHasChild = new Department("п2", "тест2", "физ", "п1", 2);
        List<Department> childs = new ArrayList<>();
        List<Department> childOfChild = new ArrayList<>();
        departmentChildWhichHasChild.setChild(childOfChild);
        childs.add(departmentChildWhichHasChild);
        childs.add(new Department("п3", "тест3", "физ", "п1", 2));
        childOfChild.add(new Department("п4", "тест4", "физ", "п2", 3));
        department.setChild(childs);
        return department;
    }
    private Map<String, Department> addInMapDepartments() {
        baseWithDepartment.put("п1", new Department("п1", "тест1", "физ", null, 1));
        baseWithDepartment.put("п2", new Department("п2", "тест2", "физ", "п1", 2));
        baseWithDepartment.put("п3", new Department("п3", "тест3", "физ", "п1", 2));
        baseWithDepartment.put("п4", new Department("п4", "тест4", "физ", "п2", 3));
        baseWithDepartment.put("п5", new Department("п5", "тест5", "физ", "п7", 5));
        return baseWithDepartment;
    }
}
