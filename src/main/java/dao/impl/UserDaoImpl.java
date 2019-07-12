package dao.impl;

import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import util.DBUtil;
import util.Pagination;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        try {
            QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
            String sql = "insert into user(username,password,school_name,profession)  values(?,?,?,?)";
            Object[] params = new Object[]{
                    user.getUsername(),
                    user.getPassword(),
            };
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String username) {

    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        User user=null;
        if(username.trim().equals("yu")&&password.trim().equals("123")){
            user=new User();
            user.setNickName("于锦江");
        }
        return user;
//        User user = null;
//        try {
//            QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
//            String sql = "select * from user where username=? and password=?";
//            String sqltechnology = "select technology from user where username=? and password=?";
//            Object[] params = new Object[]{username, password};
//            user = queryRunner.query(sql, new BeanHandler<User>(User.class), params);
//            Object[] technologyArr = queryRunner.query(sqltechnology, new ArrayHandler(), params);
//            List<String> technologyList = Arrays.stream(((String) technologyArr[0]).split(";")).collect(Collectors.toList());
//            System.out.println(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
    }

    @Override
    public List<User> getAllUser(Pagination page) {
        return null;
    }

    @Override
    public void addPersonalInfo(User user) {

    }

    @Override
    public void updateUser(User user) {
    }
}
