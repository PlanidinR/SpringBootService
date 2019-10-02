package springBootService.services.utilities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import springBootService.models.Employee;
import springBootService.models.Item;
import springBootService.services.AttributeService;
import springBootService.services.PositionAndItemService;

import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@SpringBootTest(classes = AttributeBuilderUtilityItemTest.class)
@RunWith(SpringRunner.class)
public class AttributeBuilderUtilityItemTest {
    private final List<Item> ITEM_WITH_ATTRIBUTES = getFakeTrueResult();
    private final List<Item> ITEM_NULL = null;
    private List<String> listTest = new ArrayList<>(Arrays.asList("employee","di"));
    private AttributeBuilderUtilityItem attributeBuilderUtilityItem = new AttributeBuilderUtilityItem();
    @Qualifier("itemServiceImpl")
    @MockBean
    private PositionAndItemService itemService;
    @Qualifier("employeeServiceImpl")
    @MockBean
    private AttributeService employeeService;
    @Qualifier("diServiceImpl")
    @MockBean
    private AttributeService diService;
    @Test
    public void attributeBuilderListWithNullTest(){
        when(itemService.getAllByCodeDepartment("test")).thenReturn(null);
        attributeBuilderUtilityItem.setItemService(itemService);
        assertEquals(attributeBuilderUtilityItem.attributeBuilderList("test", listTest), ITEM_NULL);
    }
    @Test
    public void attributeBuilderListTest(){
        List<Item> items = new ArrayList<>();
        items.add(getFakeBaseWithItems().get("уе1"));
        items.add(getFakeBaseWithItems().get("уе3"));
        when(itemService.getAllByCodeDepartment("test")).thenReturn(items);
        List<Employee> employeesOfItem1 = new ArrayList<>();
        employeesOfItem1.add(getFakeBaseWithEmployee().get("стр1"));
        when(employeeService.getAllByCodeItem("уе1")).thenReturn(employeesOfItem1);

        List<Employee> employeesOfItem3 = new ArrayList<>();
        employeesOfItem3.add(getFakeBaseWithEmployee().get("стр3"));
        employeesOfItem3.add(getFakeBaseWithEmployee().get("стр4"));
        when(employeeService.getAllByCodeItem("уе3")).thenReturn(employeesOfItem3);

        attributeBuilderUtilityItem.setItemService(itemService);
        attributeBuilderUtilityItem.setEmployeeService(employeeService);

        assertEquals(attributeBuilderUtilityItem.attributeBuilderList("test", listTest), ITEM_WITH_ATTRIBUTES);
    }
    private List<Item> getFakeTrueResult(){
        Item item;
        List<Item> fakeTrueResult = new ArrayList<>();
        List<Employee> employeesOfItem1 = new ArrayList<>();
        List<Employee> employeesOfItem3 = new ArrayList<>();

        employeesOfItem1.add(getFakeBaseWithEmployee().get("стр1"));

        item = getFakeBaseWithItems().get("уе1");
        item.setEmployees(employeesOfItem1);

        fakeTrueResult.add(item);
        employeesOfItem3.add(getFakeBaseWithEmployee().get("стр3"));
        employeesOfItem3.add(getFakeBaseWithEmployee().get("стр4"));

        item = getFakeBaseWithItems().get("уе3");
        item.setEmployees(employeesOfItem3);

        fakeTrueResult.add(item);
        return fakeTrueResult;
    }

    private Map<String, Employee> getFakeBaseWithEmployee(){
        Map<String, Employee> baseWithEmpployee = new HashMap<>();
        baseWithEmpployee.put("стр1", new Employee("стр1", "test", "уе1", "test"));
        baseWithEmpployee.put("стр3", new Employee("стр3", "test", "уе3","test"));
        baseWithEmpployee.put("стр4", new Employee("стр4", "test", "уе3", "test"));
        baseWithEmpployee.put("стр5", new Employee("стр5", "test", "уе4", "test"));
        return baseWithEmpployee;
    }
    private Map<String, Item> getFakeBaseWithItems(){
        Map<String, Item> baseWithItems = new HashMap<>();
        baseWithItems.put("уе1", new Item("уе1", "test"));
        baseWithItems.put("уе3", new Item("уе3", "test"));
        return baseWithItems;
    }
}
