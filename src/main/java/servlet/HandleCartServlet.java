package servlet;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import entity.CartDO;
import util.Constant;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: 于锦江
 * Date: 2019/5/26
 * Time: 14:25
 */
@WebServlet(name = "handleCartServlet", urlPatterns = "/handleCart")
public class HandleCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String count = req.getParameter("count");
        String auctionId = req.getParameter("auctionId");
        Map<Integer, CartDO> cartMap = (HashMap<Integer, CartDO>) req.getSession().getAttribute(Constant.CART_MAP);
        CartDO cartDO = cartMap.get(Integer.parseInt(auctionId));
        cartDO.setNumber(Integer.parseInt(count));
        cartDO.setTotalPrice(cartDO.getNumber()*cartDO.getAuctionDO().getCurrentPrice());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
