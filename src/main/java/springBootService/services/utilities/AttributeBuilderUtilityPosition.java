package springBootService.services.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springBootService.models.Position;
import springBootService.services.AttributeService;
import springBootService.services.PositionAndItemService;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Component
public class AttributeBuilderUtilityPosition implements AttributeBuilderUtility {
    @Qualifier("positionServiceImpl")
    @Autowired
    private PositionAndItemService positionService;
    @Qualifier("employeeServiceImpl")
    @Autowired
    private AttributeService employeeService;

    @Override
    public List<Position> attributeBuilderList(String code, List attribute) {
        List<Position> positionWithAttribute = positionService.getAllByCodeDepartment(code);
        if(positionWithAttribute == null){
            return null;
        }
        return getRelationshipPositionWithAttribute(positionWithAttribute, attribute);
    }
    private List<Position> getRelationshipPositionWithAttribute(List<Position> positionWithAttribute, List attribute){
        for(Position position : positionWithAttribute){
            for(Object element : attribute){
                if("employee".equals(element)){
                    position.setEmployees(employeeService.getAllByCodePosition(position.getCode()));
                }
            }
        }
        return positionWithAttribute;
    }
}