package servlet;

import dao.AuctionDao;
import entity.AuctionDO;
import util.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: 于锦江
 * Date: 2019/5/25
 * Time: 17:15
 */
@WebServlet(name = "getAllAuctionServlet", urlPatterns = "/getAllAuction")
public class GetAllAuctionServlet extends HttpServlet {

    private AuctionDao auctionDao = DaoFactory.getAuctionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AuctionDO> auctionList = auctionDao.getAllAuction();
        req.setAttribute("auctionList", auctionList);
        String path = req.getContextPath() + "/jsp/shop/shop.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
