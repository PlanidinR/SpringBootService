package springBootService.services.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springBootService.models.Item;
import springBootService.services.AttributeService;
import springBootService.services.PositionAndItemService;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Component
public class AttributeBuilderUtilityItem implements AttributeBuilderUtility {
    @Qualifier("itemServiceImpl")
    @Autowired
    private PositionAndItemService itemService;
    @Qualifier("employeeServiceImpl")
    @Autowired
    private AttributeService employeeService;

    @Override
    public List<Item> attributeBuilderList(String code, List attribute) {
        List<Item> itemsWithAttributes = itemService.getAllByCodeDepartment(code);
        if (itemsWithAttributes == null) {
            return null;
        }
        return getRelationshipForItemsWithAtrributes(itemsWithAttributes, attribute);
    }
    private List<Item> getRelationshipForItemsWithAtrributes(List<Item> itemsWithAttributes , List attribute){
        for(Item item : itemsWithAttributes){
            for(Object element : attribute){
                if("employee".equals(element)){
                    item.setEmployees(employeeService.getAllByCodeItem(item.getCode()));
                }
            }
        }
        return itemsWithAttributes;
    }
    public void setItemService(PositionAndItemService itemService) {
        this.itemService = itemService;
    }
    public void setEmployeeService(AttributeService employeeService) {
        this.employeeService = employeeService;
    }
}
