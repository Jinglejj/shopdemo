package config;

import dao.CategoryDao;
import entity.Category;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import util.Constant;
import util.DaoFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: 于锦江
 * Date: 2019/5/27
 * Time: 15:49
 */
public class ProjectInit implements ServletContextListener {

    private static CategoryDao categoryDao= DaoFactory.getCategoryDao();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //初始化加载商品类目
        List<Category> categoryList=categoryDao.getAllCategory();
        servletContextEvent.getServletContext().setAttribute(Constant.CATEGORY_LIST,categoryList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
