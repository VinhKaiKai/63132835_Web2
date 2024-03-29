<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trang about me</title>
</head>
<style>
	body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f8f8f8; /* Màu nền của trang */
}

.all {
    width: 80%;
    margin: 0 auto;
}

.content {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
}

.one {
    flex-basis: 40%;
}

.framimage {
    border-radius: 50%; /* Làm cho hình ảnh có góc bo tròn */
    overflow: hidden;
}

img {
    max-width: 100%;
    height: auto;
    display: block; /* Loại bỏ đường kẻ dưới ảnh khi nó là một liên kết */
}

.two {
    flex-basis: 55%;
}

h2 {
    color: #333; /* Màu chữ cho các tiêu đề */
    margin-bottom: 15px;
}

</style>
<body>
	<div class="all">
		<div class="content">
			<div class="one">
				<div class="framimage">
					<img alt="" src="../Anh/cogiao.jpg">
				</div>
			</div>
			<div class="two">
				<h1>介绍自己</h1>
				<p>Tôi tên <b>Trầm Quang Vinh</b></p>
				<p>Tôi năm nay <i>20 tuổi</i></p>
				<p>Đang học môn <u>Web 2</u></p>
				<p>Tôi ước muốn học được backend mà khó quá</p>
			</div>
		</div>
	</div>
</body>
</html>