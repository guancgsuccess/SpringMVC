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
</head>
<body>

	<div class="container">
		<div class="table-responsive">
			<table class="table table-hover">
				<caption>商品列表</caption>
				<thead>
					<tr class="active">
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
							<td>${item.name}</td>
							<td>${item.price}</td>
							<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
							<td>${item.detail}</td>
							<td><a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
</body>
</html>