<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Đăng Nhập Vào Hệ Thống</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="login-box">
		<h2>Đăng Nhập Vào Hệ Thống</h2>
		<form action='login'>
			<div class="input-group">
				<span>👤</span> <input type="text" placeholder="Tên đăng nhập">
			</div>
			<div class="input-group">
				<span>🔒</span> <input type="password" placeholder="Mật khẩu">
			</div>
			<div class="options">
				<label><input type="checkbox"> Nhớ tôi</label> <a href="#">Quên
					mật khẩu?</a>
			</div>
			<button type="submit" class="btn">Đăng nhập</button>
		</form>
		<div class="register">
			Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a href="#">Đăng
				ký</a>
		</div>
	</div>
</body>
</html>
