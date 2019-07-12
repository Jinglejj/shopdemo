package dao;

import entity.AuctionDO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: 于锦江
 * Date: 2019/5/25
 * Time: 16:56
 */
public interface AuctionDao {

    List<AuctionDO> getAllAuction();

    List<AuctionDO> findAuctionByName(String auctionName);

    List<AuctionDO> findAuctionByCategory(Integer categoryId);

    AuctionDO getAuction(Integer id);

    void addAcution(AuctionDO auctionDO);

}
