<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phép tính cộng trừ nhân chia</title>
</head>
<body>
	<form action = "TINH_TOAN" method="post">
		<h1> Phép tính cộng trừ nhân chia </h1>
		<div style ="display:flex;">
			<p>Nhập số A: </p>
			<p> <input type ="text" name ="soA"></p>
		</div>
		<div style ="display:flex;">
			<p>Nhập số B: </p>
			<p> <input type ="text" name ="soB"></p>
		</div>
		<hr>
		<p>
			<input type="submit" value="plus" name ="pheptinh">
			<input type="submit" value="minus"  name ="pheptinh">
			<input type="submit" value="nhan"  name ="pheptinh">
			<input type="submit" value="chia"  name ="pheptinh">
		</p>
	</form>
	
</body>
</html>