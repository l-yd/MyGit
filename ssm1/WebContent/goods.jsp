<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/goods/select.action" method="post" >
<input type="text" name="selectgood">
<input type="submit" value="查询">
</form>
<a href="${pageContext.request.contextPath}/goods/insert.action">新添商品</a>
<table cellspcing="0" cellpanding="0" border="1">
<tr>
<td>商品编号</td>
<td>商品名</td>
<td>商品价格</td>
<td>商品数量</td>
<td>商品描述</td>
<td>商品图片</td>
<td>操作</td>
</tr>
<c:forEach items="${info.list }" var="g">
<tr>
<td>${g.id }</td>
<td>${g.name }</td>
<td>${g.price }</td>
<td>${g.number }</td>
<td>${g.miaoshu }</td>
<td>${g.img }</td>
<td><a href="${pageContext.request.contextPath}/goods/delete.action?id=${g.id}">删除</a>
<a href="${pageContext.request.contextPath}/goods/update.action?id=${g.id}">修改</a></td>
</c:forEach>
</table>
<a href="${pageContext.request.contextPath }/goods/findAll.action?page=1">首页</a>
<a href="${pageContext.request.contextPath }/goods/findAll.action?page=${info.hasPreviousPage?info.prePage:1}">上一页</a>
<c:forEach items="${info.navigatepageNums }" var="np">
<a href="${pageContext.request.contextPath }/goods/findAll.action?page=${np}" style="color: ${np==info.pageNum?'red':'black'}">${np}</a>
</c:forEach>
<a href="${pageContext.request.contextPath }/goods/findAll.action?page=${info.hasNextPage?info.nextPage:info.pages}">下一页</a>
<a href="${pageContext.request.contextPath }/goods/findAll.action?page=${info.pages}">尾页</a>
</body>
</html>