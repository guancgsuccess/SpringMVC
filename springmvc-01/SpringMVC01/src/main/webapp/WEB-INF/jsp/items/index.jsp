<%@ page language="java"	 contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href='../../../dist/css/bootstrap.min.css'>
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
							<td>${item.createtime}</td>
							<td>${item.detail}</td>
							<td><a href="#">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="../../../dist/js/jquery.min.js"></script>
	<script src="../../../dist/js/bootstrap.min.js"></script>
</body>
</html>