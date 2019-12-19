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
商品名：<input name="name" type="text">
商品价格：<input name="price" type="text">
商品数量：<input name="number" type="text">
商品描述：<input name="miaoshu" type="text">
商品图片：<input name="upimg" type="file">
<input type="submit" value="上传">
</form>
</body>
</html>