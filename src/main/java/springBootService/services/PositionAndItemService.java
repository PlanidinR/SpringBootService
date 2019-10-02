package springBootService.services;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public interface PositionAndItemService<T> {
    List<T> getAllByCodeDepartment(String code_department);
}
