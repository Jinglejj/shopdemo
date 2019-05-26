<%--
  Created by IntelliJ IDEA.
  User: 于锦江
  Date: 2019/5/25
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/cart.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/main.css">
    <script src="${pageContext.request.contextPath}/asset/js/vue.js"></script>
</head>
<body>
<div id="app">
    <div class="container">
        <div>
            <jsp:include page="/jsp/top.jsp"/>
            <table class="card-table table table-bordered table-hover">
                <th>
                    <input id="checkAll" type="checkbox"/>
                <td>全选</td>
                <td>商品信息</td>
                <td>单价</td>
                <td>数量</td>
                <td>金额</td>
                <td>操作</td>
                </th>
                <c:forEach items="${cartList}" var="cart" >
                    <tr>
                        <td class="col-xs-1">
                            <input name="selectFlag" type="checkbox" @click="add(${cart.totalPrice},$event)">
                        </td>
                        <td class="col-xs-2">
                            <div style="position: relative;width: 100%;padding-bottom: 100%;height: 0">
                                <img style="width: 100%;height: 100%;position: absolute;"
                                     src="https://img.alicdn.com/imgextra/i2/1917047079/O1CN0122AEDl63tBxSppf_!!1917047079.jpg_430x430q90.jpg"
                                     alt="">
                            </div>
                        </td>
                        <td class="col-xs-3">${cart.auctionDO.description}</td>
                        <td class="col-xs-1">${cart.auctionDO.currentPrice}</td>
                        <td class="col-xs-2">
                            <div class="row">
                                <div class="col-xs-10 col-xs-offset-1">
                                    <div class="input-group">
                                        <span class="input-group-btn">
                                            <c:if test="${cart.number==1}">
                                                <button class="btn btn-default" type="button" disabled>-</button>
                                            </c:if>
                                            <c:if test="${cart.number>1}">
                                                <button class="btn btn-default" type="button" onclick="delCount(${cart.auctionDO.id},${cart.number},event)">-</button>
                                            </c:if>
                                        </span>
                                        <input type="number" style="vertical-align:middle;text-align:center"
                                               value="${cart.number}"
                                               class="form-control">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button" onclick="addCount(${cart.auctionDO.id},${cart.number},event)">+</button>
                                        </span>
                                    </div><!-- /input-group -->
                                </div><!-- /.col-lg-6 -->
                            </div>
                        </td>
                        <td class="col-xs-1">${cart.totalPrice}</td>
                        <td class="col-xs-2">
                            <dl>
                                <dt>
                                    <a href="${pageContext.request.contextPath}/deleteCart?auctionId=${cart.auctionDO.id}">删除</a>
                                </dt>
                                <dt><a href="#">添加到收藏夹</a></dt>
                            </dl>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="cart-toolbar fixed-bottom">
        <div class="container">
            <div class="handler" style="float: right">
                总价 : <span class="count">{{ " "+count+" " }}</span> 元
                <div class="pay">
                    <a> 去结算</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/asset/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
<script>
    let carts =${carts};
    console.log(carts);
    const vm = new Vue({
        el: "#app",
        data: {
            count: 0,
            carts
        },
        methods: {
            add(value, e) {
                console.log(e.target.checked)
                if (e.target.checked) {
                    this.count += value;
                } else {
                    this.count -= value;
                }
                console.log(this.count)
            },
            selectAll() {
                this.count = this.carts.map(e=>e.totalPrice).reduce((pre,cur) => pre+cur);
            },
            delAll() {
                this.count = 0;
            }
        }
    });

    function delCount(id,val,e){
        console.log(e)
        $.ajax({
            url:"/handleCart",
            methods:"POST",
            data:{
                auctionId:id,
                count:val-1
            },
            success:(res)=>{
                window.location.href="${pageContext.request.contextPath}"+"/cart";
            }
        })
    }
    function addCount(id,val,e){
        console.log(e)
        $.ajax({
            url:"/handleCart",
            methods:"POST",
            data:{
                auctionId:id,
                count:val+1
            },
            success:(res)=>{
                window.location.href="${pageContext.request.contextPath}"+"/cart";
            }
        })
    }
    $("#checkAll").click(function () {
        if (this.checked) {
            $("input[name='selectFlag']:checkbox").each(function () { //遍历所有的name为selectFlag的 checkbox
                $(this).context.checked=true;
            })
            vm.selectAll();
        } else {
            $("input[name='selectFlag']:checkbox").each(function () { //遍历所有的name为selectFlag的 checkbox
                $(this).context.checked=false;
            })
            vm.delAll();
        }
    })
</script>
</body>
</html>
