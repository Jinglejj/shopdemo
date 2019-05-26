package servlet;

import entity.CartDO;
import util.Constant;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: 于锦江
 * Date: 2019/5/26
 * Time: 13:47
 */
@WebServlet(name = "deleteCartServlet", urlPatterns = "/deleteCart")
public class DeleteCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("auctionId");
        Map<Integer, CartDO> cartDOMap = (HashMap<Integer, CartDO>) req.getSession().getAttribute(Constant.CART_MAP);
        cartDOMap.remove(Integer.parseInt(id));
        req.getSession().setAttribute(Constant.CART_MAP,cartDOMap);
        String path=req.getContextPath()+"/cart";
        resp.sendRedirect(path);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
