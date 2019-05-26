package dao.daoimpl;

import dao.AuctionDao;
import entity.AuctionDO;

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

    static {
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < 100; i++) {
            AuctionDO auctionDO = new AuctionDO();
            auctionDO.setId(i);
            auctionDO.setCategoryId(i);
            auctionDO.setTitle("商品" + i);
            double currentPrice=Math.random() * 100 + 100;
            BigDecimal bg = new BigDecimal(currentPrice).setScale(2, RoundingMode.UP);
            auctionDO.setCurrentPrice(Double.valueOf(df.format(currentPrice)));
            auctionDO.setHisPrice(Double.valueOf(df.format(bg.doubleValue() - (int)(Math.random() * 200) + 100)));
            auctionDO.setDescription("描述" + "商品" + i + "描述" + "商品" + i + "描述" + "商品" + i + "描述" + "商品" + i + "描述" + "商品" + i + "描述" + "商品" + i + "描述");
            auctionDO.setNumber((int) (Math.random() * 10000) + 1000);
            auctionDO.setSellNumber((int) (Math.random() * 1000) + 1000);
            auctionList.add(auctionDO);
        }
    }


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
        return auctionList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst().orElse(null);
    }
}
