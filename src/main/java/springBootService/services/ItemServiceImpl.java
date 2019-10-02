package springBootService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springBootService.dao.PositionAndItemDao;
import springBootService.models.Item;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Service
public class ItemServiceImpl implements PositionAndItemService{
    @Qualifier("itemDaoImpl")
    @Autowired
    private PositionAndItemDao itemDao;
    @Override
    public List<Item> getAllByCodeDepartment(String code_department) {
        List<Item> allItemsByCodeDepartment = itemDao.getAllByCodeDepartment(code_department);
        if(allItemsByCodeDepartment.size()== 0){
            return null;
        }
        return allItemsByCodeDepartment;
    }
}
