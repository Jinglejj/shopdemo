package util;

import dao.AuctionDao;
import dao.BaseDao;
import dao.CategoryDao;
import dao.UserDao;
import dao.daoimpl.AuctionDaoImpl;
import dao.daoimpl.CategoryDaoImpl;
import dao.daoimpl.UserDaoImpl;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.util.Properties;

public class DaoFactory {

    private static UserDao userDao =new UserDaoImpl();
    private static AuctionDao auctionDao=new AuctionDaoImpl();
    private static CategoryDao categoryDao=new CategoryDaoImpl();


    static {
        new DaoFactory();
    }

    private DaoFactory(){
        Properties props=new Properties();
        InputStream in =DaoFactory.class.getResourceAsStream("beans-config.properties");
        try{
            props.load(in);
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        String userDaoImpl=props.getProperty("userDao");
        String auctionDaoImpl=props.getProperty("auctionDao");
        String categoryDaoImpl=props.getProperty("categoryDao");
        System.out.println(userDaoImpl);
        try{
            userDao=(UserDao)Class.forName(userDaoImpl).newInstance();
            auctionDao=(AuctionDao)Class.forName(auctionDaoImpl).newInstance();
            categoryDao=(CategoryDao)Class.forName(categoryDaoImpl).newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static UserDao getUserDao(){
        return userDao;
    }

    public static AuctionDao getAuctionDao(){
        return auctionDao;
    }

    public static CategoryDao getCategoryDao() {return categoryDao;}
}
