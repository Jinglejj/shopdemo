<%--
  Created by IntelliJ IDEA.
  User: 于锦江
  Date: 2019/5/25
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .carts {
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: column;
        background-color: #87B7CB;
        position: fixed;
        top: 30vh;
        right: 0;
        width: 30px;
        height: 150px;
        text-align: center;
        cursor: pointer;
    }

    .carts:hover {
        background-color: #B8E0D8
    }

    .carts span {
        display: block;
    }
</style>
<div id="cart" class="carts" onclick="window.location.href='${pageContext.request.contextPath}/cart'">
    <i class="iconfont icon-gouwuche"></i>
    <span>购</span>
    <span>物</span>
    <span>车</span>
</div>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">购物商城系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <c:if test="${user!=null}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">${user.nickName}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">我的订单</a></li>
                            <li><a href="#">我的收藏</a></li>
                            <li><a href="#">个人中心</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/loginOut">退出登录</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if  test="${user==null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a>
                    </li>
                </c:if>
                <%--<li id="cart"><a href="${pageContext.request.contextPath}/cart">购物车</a></li>--%>
            </ul>
            <!-- <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form> -->
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

