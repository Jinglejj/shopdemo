package dao.impl;

import dao.AuctionDao;
import entity.AuctionDO;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.DBUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Author: 于锦江
 * Date: 2019/5/25
 * Time: 17:02
 */
public class AuctionDaoImpl implements AuctionDao {
    private static List<AuctionDO> auctionList = new ArrayList<>();
    private static String[] categoryNames = {"女装", "母婴", "家电", "国际", "美妆", "鞋包", "男装"};


    @Override
    public List<AuctionDO> getAllAuction() {
        return auctionList;
    }

    @Override
    public List<AuctionDO> findAuctionByName(String auctionName) {
        return auctionList.stream()
                .filter(e -> e.getTitle().contains(auctionName))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuctionDO> findAuctionByCategory(Integer categoryId) {
        return auctionList.stream()
                .filter(e -> e.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    @Override
    public AuctionDO getAuction(Integer id) {
        String sql="select * from auction_do where id=?";
        return (AuctionDO) DBUtil.process((QueryRunner qr) ->
                qr.query(sql,
                        new BeanHandler<AuctionDO>(AuctionDO.class, new BasicRowProcessor(new GenerousBeanProcessor())),
                        id));
    }

    @Override
    public void addAcution(AuctionDO auctionDO) {
        auctionDO.setId(auctionList.get(auctionList.size()).getId()+1);
        auctionList.add(auctionDO);
    }
}
