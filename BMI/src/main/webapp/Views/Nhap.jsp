<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Chào mừng đến với phần mềm tính BMI</h1>
	<form action="TinhBMI" method="post">
	<div class="chieucao">
		<span>
			Nhập vào chiều cao của bạn (mét):
		</span>
		<input type="text" name="dulieucc">
	</div>
	<div class="cannang">
		<span>
			Nhập vào cân nặng của bạn:
		</span>
		<input type="text" name="dulieucn">
	</div>
	<input type ="submit">
	</form>
</body>
</html>