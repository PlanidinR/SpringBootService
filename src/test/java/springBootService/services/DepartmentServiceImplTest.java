package springBootService.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import springBootService.models.Department;
import springBootService.models.Responser;
import springBootService.services.utilities.DepartmentWithChildsUtilityImpl;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@SpringBootTest(classes = DepartmentServiceImplTest.class)
@RunWith(SpringRunner.class)
public class DepartmentServiceImplTest {
    private Department department = new Department();
    private Department departmentNull = null;
    private final Responser RESPONSER = new Responser(department, "200");
    private final Responser RESPONSER_NULL = new Responser(departmentNull, "Данного подразделения нет");
    private List<String> listTest;
    private DepartmentServiceImpl departmentServiceimpl = new DepartmentServiceImpl();
    @MockBean
    private DepartmentWithChildsUtilityImpl departmentWithChildsUtility;
    @Test
    public void getDepartmentAndChildsTest() {
        when(departmentWithChildsUtility.getChildsOfDepartment("test", "test", listTest)).thenReturn(department);
        departmentServiceimpl.setDepartmentWithChildsUtility(departmentWithChildsUtility);
        assertEquals(departmentServiceimpl.getDepartmentWithChilds("test", "test", listTest), RESPONSER);
    }
    @Test
    public void getNullDepartmentWithChidsTest() {
        when(departmentWithChildsUtility.getChildsOfDepartment("test", "test", listTest)).thenReturn(departmentNull);
        departmentServiceimpl.setDepartmentWithChildsUtility(departmentWithChildsUtility);
        assertEquals(departmentServiceimpl.getDepartmentWithChilds("test", "test", listTest), RESPONSER_NULL);
    }
}