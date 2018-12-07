<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/12 0012
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

        .c1{
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            padding: 5px;
        }


    </style>
</head>
<body>
   <div class="container">

       <!-- 显示错误信息 -->
       <c:if test="${allErrors!=null }">
           <div class="alert alert-warning">
           <c:forEach items="${allErrors }" var="error">
               ${ error.defaultMessage}<br/>
           </c:forEach>
           </div>
       </c:if>
       <div class="row outer">
           <div class="col-md-offset-2 col-md-8">
               <div class="login_layout">
                   <fieldset>
                       <legend>修改商品信息入口</legend>
                       <form:form action="${pageContext.request.contextPath }/items/editItemsSubmit.action" enctype="multipart/form-data"
                                  id="loginForm" modelAttribute="itemsCustom" class="form-horizontal" role="form" method="post">

                           <!--隐藏域-->
                           <input type="hidden" name="id" value="${itemsCustom.id}"/>

                           <div class="form-group">
                               <label for="inputUserName" class="col-sm-2 control-label">商品名称</label>
                               <div class="col-sm-5">
                                   <input type="text" name="name" class="form-control" id="inputUserName" value="${itemsCustom.name}"/>
                               </div>
                               <div class="col-sm-5" style="margin-top: 8px">
                                    <form:errors path="name" cssClass="c1"/>
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
                               <label class="col-sm-2 control-label">商品图片</label>
                               <div class="col-md-5">
                                   <c:if test="${itemsCustom.pic!=null}">
                                         <img src="${pageContext.request.contextPath}/img/${itemsCustom.pic}" width="100" height="100" alt="图片加载失败">
                                         <input type="hidden" value="${itemsCustom.pic}" name="hpic">
                                   </c:if>
                                   <input type="file" name="items_pic">
                               </div>
                           </div>
                           <div class="form-group">
                               <label class="col-sm-2 control-label">商品简介</label>
                               <div class="col-sm-5">
                                   <textarea id="detail" name="detail" class="form-control">${itemsCustom.detail}</textarea>
                               </div>
                               <div class="col-sm-5" style="margin-top: 20px">
                                   <form:errors path="detail" cssClass="c1"/>
                               </div>
                           </div>
                           <div class="form-group">
                               <div class="col-sm-offset-2 col-sm-5">
                                   <button type="type" class="btn btn-primary">注册</button>
                                   <button type="reset" class="btn btn-danger">重置</button>
                               </div>
                           </div>
                       </form:form>
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
