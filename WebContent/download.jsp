<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="download?fileName=a.txt">下载</a>
<form action="upload" enctype="multipart/form-data" method="post">
	姓名:<input type="text" name="name"/><br/>
	文件:<input type="file" name="file"/><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>