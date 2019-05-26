<%--
  Created by IntelliJ IDEA.
  User: 于锦江
  Date: 2018/12/23
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/shop.css">
    <link href="${pageContext.request.contextPath}/asset/css/index.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/asset/css/iconfont.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/asset/css/auction.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main.css">
</head>
<body>
<div class="container">
    <jsp:include page="/jsp/top.jsp"/>
    <div class="container">
        <form action="/searchAuctionByName" class="search-form">
            <div class="input-container">
                <input type="text" name="keyword" value="${keyword}" required>
            </div>
            <button class="btn-search" type="submit">搜索</button>
        </form>
    </div>
    <div style="margin: 30px"></div>
    <div>
        <c:forEach items="${auctionList}" var="auction">
            <div class="col-xs-6 col-sm-3 auction card">
                <div class="image">
                    <img src="https://gd4.alicdn.com/imgextra/i4/294693148/TB21NsUAmtYBeNjSspkXXbU8VXa_!!294693148.jpg_400x400.jpg"
                         alt="">
                </div>
                <div class="info">
                    <span class="price"><strong>¥ ${auction.currentPrice} </strong></span>
                    <del style="color: #9c9c9c">¥ ${auction.hisPrice}</del>
                    <span class="sell">已售出 ${auction.sellNumber}</span>
                </div>
                <a class="ellip">
                        ${auction.description}
                </a>
                <div class="handle">
                    <button class="btn btn-addcard" onclick="addCard(${auction.id},event)"><i
                            class="iconfont icon-gouwuche"></i>加入购物车
                    </button>
                    <button class="btn btn-default "><i class="iconfont icon-shoucang"></i>收藏</button>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/asset/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/asset/js/jquery-fly.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
<script>
    function addCard(id, e) {
        $.ajax({
            url: '/addCartServlet?auctionId=' + id,
            success(res){
                fly(e)
            }
        })
    }

    // 飞到的终点的坐标
    const globalLeft = $('#cart').offset().left + $("#cart").innerWidth() / 2;
    const globalTop = $('#cart').offset().top + $("#cart").innerHeight() / 2;

    function fly(event) {
        console.log(10);
        var flyer = $('<img  style="width:80px;height:80px;border-radius:50%" src="https://gd4.alicdn.com/imgextra/i4/294693148/TB21NsUAmtYBeNjSspkXXbU8VXa_!!294693148.jpg_400x400.jpg"\n' +
            ' alt="">');
        flyer.fly({
            start: {
                left: event.pageX,
                top: event.pageY - $(document).scrollTop()
            },
            end: {
                top: globalTop,
                left: globalLeft,
                width: 0,
                height: 0,
            },
            onEnd: function () {
                this.destroy();
            }
        })
    }
</script>
</body>
</html>
