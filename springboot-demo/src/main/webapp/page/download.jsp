<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>下载</h1>
    <form action="${pageContext.request.contextPath }/upload" method="post" enctype="multipart/form-data">
    <a href="${pageContext.request.contextPath }/download">下载</a>
    选择文件：<input type="file" name="file" >
    <input type="submit" value="上传">
    </form>
</body>
</html>