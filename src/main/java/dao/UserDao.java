package dao;

import java.util.List;

import entity.User;
import util.Pagination;

public interface UserDao extends BaseDao {
    /**
     * 添加一个用户
     */
    public void addUser(User user);
    /**
     * 根据用户名删除一个用户
     */
    public void delete(String username);
    /**
     * 根据用户名查找一个用户
     */
    public User getUser(String username);

    User login(String username,String password);

    /**
     * 获取全部用户
     */
    public List<User> getAllUser(Pagination page);

    /**
     * 完善个人信息
     */
    public void addPersonalInfo(User user);

    /**
     * 修改用户信息
     */
    public void updateUser(User user);
}
