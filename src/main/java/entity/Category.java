package entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @Author 于锦江
 * @Date 2019/4/15 17:12
 */
@Data
@ToString
public class Category {

    private Integer id;

    private String name;

    private Boolean hasChildren = false;

    private Integer parentId;

    private Integer rootId;

    private List<Category> child;
}
