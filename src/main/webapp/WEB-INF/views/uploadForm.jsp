<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- method, enctype은 꼭 아래처럼 설정해야 파일전송 가능하다. get방식은 에러 -->
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="업로드"><br>
	</form>
</body>
</html>