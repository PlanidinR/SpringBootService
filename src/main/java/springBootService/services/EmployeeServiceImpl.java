package springBootService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springBootService.dao.AttributeDao;
import springBootService.models.Employee;
import springBootService.models.Responser;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Service
public class EmployeeServiceImpl implements AttributeService{
    @Qualifier("employeeDao")
    @Autowired
    private AttributeDao employeeDao;
    @Override
    public Responser getByCode(String code) {
        Employee employeeByCode = (Employee) employeeDao.getByCode(code);
        Responser responser = new Responser<>();
        responser.setResult(employeeByCode);
        if (employeeByCode == null) {
            responser.setMessage("Данного сотрудника нет");
            return responser;
        }
        responser.setMessage("200");
        return responser;
    }
    @Override
    public List<Employee> getAllByCodeItem(String code_item) {
        List<Employee> allEmployee = employeeDao.getAllByCodeItem(code_item);
        if(allEmployee.size() == 0){
            return null;
        }
        return allEmployee;
    }
    @Override
    public List<Employee> getAllByCodePosition(String code_position) {
        List<Employee> allEmployee = employeeDao.getAllByCodePosition(code_position);
        if(allEmployee.size() == 0){
            return null;
        }
        return allEmployee;
    }
}
