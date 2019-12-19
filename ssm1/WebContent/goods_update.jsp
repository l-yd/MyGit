<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/goods/upgood.action" method="post" enctype="multipart/form-data">
商品编号：<input name="id" type="text" value="${goods.id }" readonly="readonly">
商品名：<input name="name" type="text"" value="${goods.name }" >
商品价格：<input name="price" type="text" value="${goods.price }">
商品数量：<input name="number" type="text" value="${goods.number }">
商品描述：<input name="miaoshu" type="text" value="${goods.miaoshu }">
商品图片：<input name="upimg" type="file" >
<input  name="img" type="text" value="${goods.img }" style="visibility: hidden;">
<input type="submit" value="修改">
</form>
</body>
</html>