package servlet;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import entity.AuctionDO;
import entity.CartDO;
import org.json.JSONObject;
import util.Constant;

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
 * Time: 13:02
 */
@WebServlet(name="cartServelt",urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, CartDO> cartMap = (HashMap<Integer, CartDO>) req.getSession().getAttribute(Constant.CART_MAP);
        List<CartDO> cartList=new ArrayList<>();
        if(cartMap!=null){
            cartList=cartMap.entrySet().stream()
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
        }
        req.setAttribute(Constant.CART_LIST,cartList);
        req.setAttribute(Constant.CART_JSON,JSONObject.valueToString(cartList));
        String path=req.getContextPath()+"jsp/shop/cart.jsp";
        req.getRequestDispatcher(path).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
