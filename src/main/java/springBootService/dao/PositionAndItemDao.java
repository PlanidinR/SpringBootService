package springBootService.dao;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public interface PositionAndItemDao<T> {
    List<T> getAllByCodeDepartment(String code_department);
}
