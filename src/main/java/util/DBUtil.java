package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import entity.Category;
import function.HandleDB;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class DBUtil {
    private static DataSource ds = null;

    static {
        try {
            Properties pro = new Properties();
            pro.load(DBUtil.class.getClassLoader()
                    .getResourceAsStream("dbcpconfig.properties"));
            ds = BasicDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化连接错误,请检查配置文件");
        }
    }


    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        Connection con = ds.getConnection();
        con.setAutoCommit(false);
        return con;
    }

    public static void main(String[] args) {
        String sql = "select * from category where id = 1";
        Object o = process((QueryRunner qr) ->
                qr.query(sql, new BeanHandler<>(Category.class,new BasicRowProcessor(new GenerousBeanProcessor())))
        );
        System.out.println(o);
    }

    public static Object process(HandleDB p) {
        Object o=null;
        try {
            o= p.handle(new QueryRunner(getDataSource()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
}
