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
 * Time: 20:01
 */
@WebServlet(name = "searchAuctionByName", urlPatterns = "/searchAuctionByName")
public class SearchAuctionByName extends HttpServlet {
    private AuctionDao auctionDao = DaoFactory.getAuctionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String keyword = req.getParameter("keyword");
        System.out.println("关键字============" + keyword);
        List<AuctionDO> auctionList=auctionDao.findAuctionByName(keyword);
        req.setAttribute("auctionList", auctionList);
        req.setAttribute("keyword",keyword);
        System.out.println(auctionList);
        String path = req.getContextPath() + "/jsp/shop/shop.jsp";
        System.out.println(path);
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
