package util;

import dao.AuctionDao;
import dao.UserDao;
import dao.daoimpl.AuctionDaoImpl;
import dao.daoimpl.UserDaoImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

    private static UserDao userDao =new UserDaoImpl();
    private static AuctionDao auctionDao=new AuctionDaoImpl();


    public static UserDao getUserDao(){
        return userDao;
    }

    public static AuctionDao getAuctionDao(){
        return auctionDao;
    }

}
