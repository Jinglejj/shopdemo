<%--
  Created by IntelliJ IDEA.
  User: 于锦江
  Date: 2019/4/4
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>首页</title>
    <link href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/asset/css/index.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/asset/css/iconfont.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/asset/css/auction.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main.css">
  </head>
  <body>
  <div class="container">
    <jsp:include page="/jsp/top.jsp" />
    <div class="container">
      <form action="${pageContext.request.contextPath}/searchAuctionByName" class="search-form">
        <div class="input-container">
          <input type="text" name="keyword">
        </div>
        <button class="btn-search" type="submit">搜索</button>
      </form>
    </div>
    <div style="margin: 30px"></div>
    <jsp:include page="/jsp/category.jsp" />
    <div class="container auction-container">
    </div>

  </div>

  <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script src="${pageContext.request.contextPath}/asset/jquery.min.js"></script>
  <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  <script src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
  </body>
</html>
