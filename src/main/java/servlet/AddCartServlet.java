package servlet;

import dao.AuctionDao;
import entity.AuctionDO;
import entity.CartDO;
import util.Constant;
import util.DaoFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Author: 于锦江
 * Date: 2019/5/26
 * Time: 12:35
 */
@WebServlet(name = "addCartServlet", urlPatterns = "/addCartServlet")
public class AddCartServlet extends HttpServlet {

    private AuctionDao auctionDao = DaoFactory.getAuctionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("auctionId");
        AuctionDO auctionDO = auctionDao.getAuction(Integer.parseInt(id));
        Map<Integer, CartDO> cartMap = (HashMap<Integer, CartDO>) req.getSession().getAttribute(Constant.CART_MAP);
        if (cartMap == null) {
            cartMap = new HashMap<>();
            CartDO cartDO = new CartDO();
            cartDO.setAuctionDO(auctionDO);
            cartDO.setNumber(1);
            cartDO.setTotalPrice(auctionDO.getCurrentPrice());
            cartMap.put(auctionDO.getId(), cartDO);
        } else {
            CartDO cartDO=null;
            if(cartMap.containsKey(Integer.parseInt(id))){
                cartDO=cartMap.get(Integer.parseInt(id));
            }else{
                cartDO=new CartDO();
                cartDO.setAuctionDO(auctionDO);
                cartDO.setNumber(0);
            }
            cartDO.setNumber(cartDO.getNumber() + 1);
            cartDO.setTotalPrice(cartDO.getNumber() * (cartDO.getAuctionDO().getCurrentPrice()));
            cartMap.put(Integer.parseInt(id), cartDO);
        }
        req.getSession().setAttribute(Constant.CART_MAP, cartMap);
        System.out.println(cartMap);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
