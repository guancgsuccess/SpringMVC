<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href='${pageContext.request.contextPath}/dist/css/bootstrap.min.css'>
<title>首页</title>
	<style type="text/css">
		.a{
			margin-top: 50px;
		}
	</style>
</head>
<body>
	<div class="container a">
		<div>
			<ol class="breadcrumb">
				<c:if test="${null!=user.username}">
					<li><a href="#">欢迎<label class="text-info">${user.username}</label></a></li>
				</c:if>
				<c:if test="${null==user.username}">
					<li><a href="${pageContext.request.contextPath}/user/loginView">登录</a></li>
				</c:if>
				<c:if test="${null!=user.username}">
					<li><a href="${pageContext.request.contextPath}/user/logout">退出</a></li>
				</c:if>
			</ol>
		</div>
		<form  name="form_first" method="post">
			<div class="row">
				<div class="col-md-3">
					<div class="input-group">
						<input type="text" name="itemsCustom.name" value="${icname}" class="form-control">
						<span class="input-group-btn">
							<button class="btn btn-info" type="button" onclick="query()">查询</button>
						</span>
					</div>
				</div>
				<div class="col-md-3">
					<select class="form-control">
						<c:forEach items="${itemtypes}" var="v">
							<option value="${v.key}">${v.value}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-3">
					<button class="btn btn-danger" type="button" onclick="del()">批量删除</button>
				</div>
				<div class="col-md-3">
					<button class="btn btn-warning" type="button" onclick="updateItems()">批量更新</button>
				</div>
			</div>
		<div class="table-responsive">
			<table class="table table-hover">
				<caption>商品列表</caption>
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="checkAll"></th>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>生产日期</th>
						<th>商品描述</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${itemsList}" var="item">
						<tr>
							<td><input type="checkbox" name="items_id" value="${item.id}"></td>
							<td>${item.name}</td>
							<td>${item.price}</td>
							<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
							<td>${item.detail}</td>
							<td><a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
			/**根据名字查询**/
			function query(){
			    var form = document.forms.form_first;
			    form.action="${pageContext.request.contextPath}/items/queryItemsList.action";
				form.submit();
			}

            /**删除操作**/
            function del(){
                var form = document.forms.form_first;
                form.action="${pageContext.request.contextPath}/items/deleteItems.action";
                form.submit();
            }

            /**批量更新**/
            function updateItems(){
                var form = document.forms.form_first;
                form.action="${pageContext.request.contextPath}/items/editItemsQuery.action";
                form.submit();
			}
	</script>
</body>
</html>