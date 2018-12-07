<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/22 0022
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录入口</title>
    <link type="text/css" rel="stylesheet"
          href='${pageContext.request.contextPath}/dist/css/bootstrap.min.css'>
    <style>
        .login{
            width: 650px;
            margin-top: 100px;
            margin-left: auto;
            margin-right: auto;
            border: 1px solid #dddddd;
            border-radius: 6px 6px 0 0;
            margin-bottom: 10px;
            padding: 20px 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <!--导航-->
        <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Project name</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#"><span class="glyphicon glyphicon-home">Home</span></a></li>
                        <li><a href="#shop"><span class="glyphicon glyphicon-shopping-cart">Shop</span></a></li>
                        <li><a href="#support"><span class="glyphicon glyphicon-headphones">Support</span></a></li>
                    </ul>
                </div><!-- /.nav-collapse -->
            </div><!-- /.container -->
        </div>
        <!--导航结束-->

        <!--登录-->
        <div class="container" style="margin-top: 200px">
            <div class="row">
                <div class="col-md-offset-2 col-md-8">
                    <div class="login">
                        <fieldset>
                            <legend>用户登录入口</legend>
                            <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/user/login">
                                <div class="form-group">
                                    <label for="firstname" class="col-sm-2 col-xs-2 control-label">用户名</label>
                                    <div class="col-md-5 col-sm-5 col-xs-5">
                                        <input type="text" class="form-control" id="firstname" name="username">
                                    </div>
                                    <div class="col-md-5 col-sm-5 col-xs-5">
                                       <label class="text-danger">${errorsMap.usernull}</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-sm-2 col-xs-2 control-label">密码</label>
                                    <div class="col-md-5 col-sm-5 col-xs-5">
                                        <input type="password" name="password" class="form-control" id="lastname">
                                    </div>
                                    <div class="col-md-5 col-sm-5 col-xs-5">
                                        <label class="text-danger">${errorsMap.pwd}</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox">请记住我
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="submit" class="btn btn-default">登录</button>
                                    </div>
                                </div>
                            </form>
                        </fieldset>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
</body>
</html>
