package springBootService.services.utilities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import springBootService.dao.DepartmentDao;
import springBootService.models.Department;
import springBootService.models.Position;
import springBootService.services.PositionAndItemService;

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

@SpringBootTest(classes = BuilderDepartmentUtilityImplTest.class)
@RunWith(SpringRunner.class)
public class BuilderDepartmentUtilityImplTest {
    private Map<String, Position> baseOfPositions = new HashMap<>();
    private Map<String, Department> baseWithDepartment =  new HashMap<>();
    private List<String> listTest;
    private final Department DEPARTMENT_WITH_POSITION = getDepartmentWithPosition();
    private final Department DEPARTMENT_NULL = null;
    private final List<Department> DEPARTMENT_WITH_CHILDS_WITH_POSITION = getChildsOfDepartmentWithPosition();
    private BuilderDepartmentUtilityImpl builderDepartment = new BuilderDepartmentUtilityImpl();
    @MockBean
    private DepartmentDao departmentDao;
    @MockBean
    private PositionAndItemService positionService;
    @Test
    public void buildDepartmentTest(){
        when(departmentDao.getByCode("test")).thenReturn(addInMapDepartments().get("п1"));
        builderDepartment.setDepartmentDao(departmentDao);
        List<Position> positions = new ArrayList<>();
        positions.add(addPositionsToBaseOfPositions().get("пз1"));
        positions.add(addPositionsToBaseOfPositions().get("пз2"));
        when(positionService.getAllByCodeDepartment("test")).thenReturn(positions);
        builderDepartment.setPositionService(positionService);
        assertEquals(builderDepartment.buildDepartment("test", "posit", listTest), DEPARTMENT_WITH_POSITION);
    }
    @Test
    public void buildDepartmentWithNullTest(){
        when(departmentDao.getByCode("test")).thenReturn(DEPARTMENT_NULL);
        builderDepartment.setDepartmentDao(departmentDao);
        assertEquals(builderDepartment.buildDepartment("test","test", listTest), DEPARTMENT_NULL);
    }
    @Test
    public void buildListChildsOfDepartmentTest(){
        List<Department> childsOfDepartment = new ArrayList<>();
        childsOfDepartment.add(addInMapDepartments().get("п2"));
        childsOfDepartment.add(addInMapDepartments().get("п3"));
        when(departmentDao.getChildsOfDepartment("п1")).thenReturn(childsOfDepartment);
        builderDepartment.setDepartmentDao(departmentDao);
        List<Position> positionsOfDepartment = new ArrayList<>();
        positionsOfDepartment.add(addPositionsToBaseOfPositions().get("пз2"));
        positionsOfDepartment.add(addPositionsToBaseOfPositions().get("пз3"));
        when(positionService.getAllByCodeDepartment("п2")).thenReturn(positionsOfDepartment);
        positionsOfDepartment = new ArrayList<>();
        positionsOfDepartment.add(addPositionsToBaseOfPositions().get("пз4"));
        when(positionService.getAllByCodeDepartment("п3")).thenReturn(positionsOfDepartment);
        builderDepartment.setPositionService(positionService);
        assertEquals(builderDepartment.buildListChildsOfDepartment("п1", "posit", listTest), DEPARTMENT_WITH_CHILDS_WITH_POSITION);
    }
    private Department getDepartmentWithPosition(){
        List<Position> positions = new ArrayList<>();
        positions.add(addPositionsToBaseOfPositions().get("пз1"));
        positions.add(addPositionsToBaseOfPositions().get("пз2"));
        addInMapDepartments().get("п1").setPosition(positions);
        return addInMapDepartments().get("п1");
    }
    private List<Department> getChildsOfDepartmentWithPosition(){
        List<Department> childOfDepartment = new ArrayList<>();
        List<Position> positionsOfChildsDepartment2 = new ArrayList<>();
        List<Position> positionsOfChildsDepartment3 = new ArrayList<>();
        Department department;
        positionsOfChildsDepartment2.add(addPositionsToBaseOfPositions().get("пз2"));
        positionsOfChildsDepartment2.add(addPositionsToBaseOfPositions().get("пз3"));
        department = addInMapDepartments().get("п2");
        department.setPosition(positionsOfChildsDepartment2);
        childOfDepartment.add(department);
        positionsOfChildsDepartment3.add(addPositionsToBaseOfPositions().get("пз4"));
        department= addInMapDepartments().get("п3");
        department.setPosition(positionsOfChildsDepartment3);
        childOfDepartment.add(department);
        return  childOfDepartment;
    }
    private Map<String, Position> addPositionsToBaseOfPositions(){
        baseOfPositions.put("пз1", new Position("пз1","Тест", "п1", null));
        baseOfPositions.put("пз2", new Position("пз2","Тест", "п2", null));
        baseOfPositions.put("пз3", new Position("пз3", "Тест", "п2", null));
        baseOfPositions.put("пз4", new Position("пз4", "Тест", "п3", null));
        baseOfPositions.put("пз5", new Position("пз5", "Тест", "п5", null));
        return baseOfPositions;
    }
    private Map<String, Department> addInMapDepartments() {
        baseWithDepartment.put("п1", new Department("п1", "тест1", "физ", null, 1));
        baseWithDepartment.put("п2", new Department("п2", "тест2", "физ", "п1", 2));
        baseWithDepartment.put("п3", new Department("п3", "тест3", "физ", "п1", 2));
        return baseWithDepartment;
    }
}
