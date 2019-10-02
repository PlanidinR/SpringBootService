package springBootService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springBootService.dao.PositionAndItemDao;
import springBootService.models.Position;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Service
public class PositionServiceImpl implements PositionAndItemService<Position> {
    @Qualifier("positionDaoImpl")
    @Autowired
    private PositionAndItemDao positionDao;
    @Override
    public List<Position> getAllByCodeDepartment(String code_department) {
        List<Position> allPositionsByCodeDepartment = positionDao.getAllByCodeDepartment(code_department);
        if(allPositionsByCodeDepartment.size()== 0){
            return null;
        }
        return allPositionsByCodeDepartment;
    }
}
