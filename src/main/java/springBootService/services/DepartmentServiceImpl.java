package springBootService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBootService.dao.DepartmentDao;
import springBootService.models.Department;
import springBootService.models.Responser;
import springBootService.services.utilities.DepartmentWithChildsUtility;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private DepartmentWithChildsUtility departmentWithChildsUtility;
    @Override
    public Responser getByCode(String code) {
        Department department = departmentDao.getByCode(code);
        Responser responser = new Responser<>();
        responser.setResult(department);
        if (department == null) {
            responser.setMessage("Данного подразделения нет");
            return responser;
        }
        responser.setMessage("200");
        return responser;
    }
    @Override
    public Responser getAll() {
        Responser responser = new Responser<>();
        responser.setResult( departmentDao.getAll());
        responser.setMessage("200");
        return responser;
    }
    @Override
    public Responser getDepartmentWithChilds(String code, String parentAttribute, List<String> attribute) {
        Department departmentWithChilds = departmentWithChildsUtility.getChildsOfDepartment(code, parentAttribute, attribute);
        Responser responser = new Responser<>();
        responser.setResult(departmentWithChilds);
        if (departmentWithChilds == null) {
            responser.setMessage("Данного подразделения нет");
            return responser;
        }
        responser.setMessage("200");
        return responser;
    }
    public void setDepartmentWithChildsUtility(DepartmentWithChildsUtility departmentWithChildsUtility) {
        this.departmentWithChildsUtility = departmentWithChildsUtility;
    }
}