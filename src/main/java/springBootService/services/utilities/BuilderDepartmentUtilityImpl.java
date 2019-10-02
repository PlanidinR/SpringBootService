package springBootService.services.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springBootService.dao.DepartmentDao;
import springBootService.models.Department;
import springBootService.services.PositionAndItemService;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Service
public class BuilderDepartmentUtilityImpl implements BuilderDepartmentUtility {
    @Autowired
    private DepartmentDao departmentDao;
    @Qualifier("positionServiceImpl")
    @Autowired
    private PositionAndItemService positionService;
    @Qualifier("itemServiceImpl")
    @Autowired
    private PositionAndItemService itemService;
    @Qualifier("attributeBuilderUtilityItem")
    @Autowired
    private AttributeBuilderUtility attributeBuilderItem;
    @Qualifier("attributeBuilderUtilityPosition")
    @Autowired
    private AttributeBuilderUtility attributeBuilderPosition;
    private static final String POSITION = "posit";
    private static final String ITEM = "item";
    @Override
    public Department buildDepartment(String code , String parentAttribute, List<String> attribute) {
        Department department = departmentDao.getByCode(code);
        if(department == null){
            return department;
        }
        return addAttributesForDepartment(department, parentAttribute, attribute);
    }
    @Override
    public List<Department> buildListChildsOfDepartment(String code, String parentAttribute, List<String> attribute) {
        List<Department> childsOfDepartment = departmentDao.getChildsOfDepartment(code);
        for (Department department:childsOfDepartment) {
            addAttributesForDepartment(department, parentAttribute, attribute);
        }
        return childsOfDepartment;
    }
    private Department addAttributesForDepartment(Department department, String parentAttribute, List<String> attribute){
        if(parentAttribute == null){
            return department;
        }
        else if(POSITION.equals(parentAttribute) && attribute == null){
            department.setPosition(positionService.getAllByCodeDepartment(department.getCode()));
        }
        else if(POSITION.equals(parentAttribute) && attribute.size() != 0){
            department.setPosition(attributeBuilderPosition.attributeBuilderList(department.getCode(), attribute));
        }
        else if(POSITION.equals(parentAttribute)){
            department.setPosition(positionService.getAllByCodeDepartment(department.getCode()));
            return department;
        }
        else if(ITEM.equals(parentAttribute) && attribute == null){
            department.setItems(itemService.getAllByCodeDepartment(department.getCode()));
            return department;
        }
        else if(ITEM.equals(parentAttribute)  && attribute.size() != 0){
            department.setItems(attributeBuilderItem.attributeBuilderList(department.getCode(), attribute));
            return department;
        }
        else if(ITEM.equals(parentAttribute) ){
            department.setItems(itemService.getAllByCodeDepartment(department.getCode()));
            return department;
        }
        return department;
    }
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    public void setPositionService(PositionAndItemService positionService) {
        this.positionService = positionService;
    }
}
