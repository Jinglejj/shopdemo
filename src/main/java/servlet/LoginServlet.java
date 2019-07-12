package servlet;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String path = null;
        String message = "";
        System.out.println(username);
        System.out.println(password);
        User user = userDao.login(username, password);
        if (user == null) {
            message = "账号或密码错误";
            path = request.getContextPath() + "/jsp/login.jsp";
            request.getSession().setAttribute("message", message);
        } else {
            System.out.println(user);
            request.getSession().setAttribute(Constant.USER_INFO, user);
            path = request.getContextPath() + "/index.jsp";
        }
        response.sendRedirect(path);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
