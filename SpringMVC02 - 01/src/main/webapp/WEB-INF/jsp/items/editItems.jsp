<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/12 0012
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>商品修改页面</title>
    <link type="text/css" rel="stylesheet"
          href='${pageContext.request.contextPath}/dist/css/bootstrap.min.css'>
    <link type="text/css" rel="stylesheet"
          href='${pageContext.request.contextPath}/dist/css/bootstrap-datetimepicker.min.css'>
    <style>
        .outer{
            border: 1px solid #ccc;
            margin-top: 100px;
            padding: 20px;
        }
    </style>
</head>
<body>
   <div class="container">
       <div class="row outer">
           <div class="col-md-offset-2 col-md-8">
               <div class="login_layout">
                   <fieldset>
                       <legend>修改商品信息入口</legend>
                       <form id="loginForm" class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath }/items/editItemsSubmit.action">

                           <!--隐藏域-->
                           <input type="hidden" name="id" value="${itemsCustom.id}"/>

                           <div class="form-group">
                               <label for="inputUserName" class="col-sm-2 control-label">商品名称</label>
                               <div class="col-sm-5">
                                   <input type="text" name="name" class="form-control" id="inputUserName" value="${itemsCustom.name}"/>
                               </div>
                           </div>
                           <div class="form-group">
                               <label for="inputItemPrice" class="col-sm-2 control-label">商品价格</label>

                               <div class="col-sm-5">
                                   <input type="text" name="price" class="form-control" id="inputItemPrice" value="${itemsCustom.price}"/>
                               </div>
                           </div>
                           <div class="form-group">
                               <label class="col-sm-2 control-label">商品生产日期</label>
                               <div class="col-sm-5">
                                   <input type="text" id="datetimepicker" name="createtime" class="form-control" value='<fmt:formatDate value='${itemsCustom.createtime}' pattern='yyyy-MM-dd'/>'"/>
                               </div>
                           </div>
                           <div class="form-group">
                               <label class="col-sm-2 control-label">商品简介</label>
                               <div class="col-sm-5">
                                   <textarea id="detail" name="detail" class="form-control">${itemsCustom.detail}</textarea>
                               </div>
                           </div>
                           <div class="form-group">
                               <div class="col-sm-offset-2 col-sm-5">
                                   <button type="submit" class="btn btn-primary">注册</button>
                                   <button type="reset" class="btn btn-danger">重置</button>
                               </div>
                           </div>
                       </form>
                   </fieldset>
               </div>
           </div>
       </div>
   </div>
   <script src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/dist/js/moment.js"></script>
   <script src="${pageContext.request.contextPath}/dist/js/bootstrap-datetimepicker.min.js"></script>
   <script>
       $('#datetimepicker').datetimepicker({
           format:'YYYY-MM-DD'
       });
   </script>
</body>
</html>
