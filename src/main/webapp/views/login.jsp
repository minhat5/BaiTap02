<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Đăng Nhập Vào Hệ Thống</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/style.css">
<!-- FontAwesome để có icon -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>
	<div class="page">
		<div class="login-page">
			<div class="login-container">
				<h2>Đăng Nhập Vào Hệ Thống</h2>

				<c:if test="${alert != null}">
					<h3 class="alert">${alert}</h3>
				</c:if>

				<form action="${pageContext.request.contextPath}/login"
					method="post">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" placeholder="Tài khoản" name="username"
							required>
					</div>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="password" placeholder="Mật khẩu" name="password"
							required>
					</div>

					<div class="options">
						<label><input type="checkbox" name="remember"> Nhớ
							tôi</label> <a href="${pageContext.request.contextPath}/forgotPassword">Quên
							mật khẩu?</a>
					</div>

					<button type="submit" class="btn-login">Đăng nhập</button>
				</form>

				<p class="register-text">
					Nếu bạn chưa có tài khoản, thì hãy <a
						href="${pageContext.request.contextPath}/register">Đăng ký</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
