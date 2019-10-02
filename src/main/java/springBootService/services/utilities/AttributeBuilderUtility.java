package springBootService.services.utilities;


import java.util.List;

/**
 * @author Planidin Roman
 * @version v1.0
 */

public interface AttributeBuilderUtility<T> {
    List<T> attributeBuilderList(String code, List<String> attribute);
}
