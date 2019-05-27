package dao;

import entity.Category;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: 于锦江
 * Date: 2019/5/27
 * Time: 14:32
 */
public interface CategoryDao  extends BaseDao{


    List<Category> getAllCategory();

    Category findCategoryByName(String name);

    Category findCategoryById(Integer id);

}
