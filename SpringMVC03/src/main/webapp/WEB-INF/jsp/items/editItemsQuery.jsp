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
	<link type="text/css" rel="stylesheet"
		  href='${pageContext.request.contextPath}/dist/css/bootstrap-datetimepicker.min.css'>
<title>批量修改</title>
	<style type="text/css">
		.a{
			margin-top: 50px;
		}
	</style>
</head>
<body>
	<div class="container a">
		<form  name="form_first" action="${pageContext.request.contextPath}/items/editItemsAllSubmit.action" method="post">
		<div class="table-responsive">
			<table class="table table-hover">
				<caption>商品列表</caption>
				<thead>
					<tr class="active">
						<th>商品名称</th>
						<th>商品价格</th>
						<th>生产日期</th>
						<th>商品描述</th>
					</tr>
				</thead>
				<tbody id="tby">
					<c:forEach items="${itemsList}" var="item" varStatus="vs">
						<tr>
							<!--隐藏域-->
							<input name="itemsList[${vs.index}].id" value="${item.id}" type="hidden">
							<td><input  class="form-control" name="itemsList[${vs.index}].name" value="${item.name}"></td>
							<td><input  class="form-control" name="itemsList[${vs.index}].price" value="${item.price}"></td>
							<td style="position: relative"><input id="datetimepicker_${vs.index}" class="form-control" name="itemsList[${vs.index}].createtime"
																  value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd"/> "></td>
							<td><input  class="form-control" name="itemsList[${vs.index}].detail" value="${item.detail}"></td>
						</tr>
					</c:forEach>
				</tbody>
				<tbody>
					<tr>
						<td><input type="submit" value="更改" class="btn btn-success"></td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/moment.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/bootstrap-datetimepicker.min.js"></script>
	<script>
		window.onload=function () {
            var inputs = document.getElementById("tby").getElementsByTagName("tr");
            for(var i=0;i<inputs.length;i++){
                $('#datetimepicker_'+i).datetimepicker({
                    format:'YYYY-MM-DD'
                });
            }
        }
	</script>
</body>
</html>