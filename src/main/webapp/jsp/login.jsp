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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Content-Language" content="en" />
    <meta name="msapplication-TileColor" content="#2d89ef">
    <meta name="theme-color" content="#4188c9">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <link rel="icon" href="./favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" type="image/x-icon" href="./favicon.ico" />
    <!-- Generated: 2019-04-04 16:55:45 +0200 -->
    <title>Login - tabler.github.io - a responsive, flat and full featured admin template</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
    <script src="${pageContext.request.contextPath}/asset/js/require.min.js"></script>
    <script>
        requirejs.config({
            baseUrl: '.'
        });
    </script>
    <!-- Dashboard Core -->
    <link href="${pageContext.request.contextPath}/asset/css/dashboard.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/asset/js/dashboard.js"></script>
    <!-- c3.js Charts Plugin -->
    <link href="${pageContext.request.contextPath}/asset/plugins/charts-c3/plugin.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/asset/plugins/charts-c3/plugin.js"></script>
    <!-- Google Maps Plugin -->
    <link href="${pageContext.request.contextPath}/asset/plugins/maps-google/plugin.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/asset/plugins/maps-google/plugin.js"></script>
    <!-- Input Mask Plugin -->
    <script src="${pageContext.request.contextPath}/asset/plugins/input-mask/plugin.js"></script>
    <!-- Datatables Plugin -->
    <script src="${pageContext.request.contextPath}/asset/plugins/datatables/plugin.js"></script>
</head>
<c:if test="${message!=null }">
    <script type="text/javascript">
        alert("${message}");
    </script>
    <c:remove var="message" scope="session"/>
</c:if>
<body class="">
<div class="page">
    <div class="page-single">
        <div class="container">
            <div class="row">
                <div class="col col-login mx-auto">
                    <div class="text-center mb-6">
                    </div>
                    <form class="card" action="${pageContext.request.contextPath}/login" method="post">
                        <div class="card-body p-6">
                            <div class="form-group">
                                <label class="form-label">用户名</label>
                                <input type="text" name="username" class="form-control" id="exampleInputEmail1"
                                       aria-describedby="emailHelp" placeholder="用户名" required>
                            </div>
                            <div class="form-group">
                                <label class="form-label">
                                    密码
                                    <a href="./forgot-password.html" class="float-right small">忘记密码</a>
                                </label>
                                <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                                       placeholder="Password">
                            </div>
                            <div class="form-group">
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input"/>
                                    <span class="custom-control-label">记住密码</span>
                                </label>
                            </div>
                            <div class="form-footer">
                                <button type="submit" class="btn btn-primary btn-block">登录</button>
                            </div>
                        </div>
                    </form>
                    <div class="text-center text-muted">
                        还没有账号？ <a href="./register.html">立即注册</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
