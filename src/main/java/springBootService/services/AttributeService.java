package springBootService.services;

import springBootService.models.Responser;

import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public interface AttributeService<T>{
    Responser getByCode(String code);
    List<T> getAllByCodeItem(String code_item);
    List<T> getAllByCodePosition(String code_position);
}
