<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Đặt Lại Mật Khẩu</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/style.css">
</head>
<body>
	<div class="page">
		<div class="login-page">
			<div class="login-container">
				<h2>Đặt Lại Mật Khẩu</h2>

				<c:if test="${alert != null}">
					<h3 class="alert">${alert}</h3>
				</c:if>

				<form action="${pageContext.request.contextPath}/resetPassword"
					method="post">
					<div class="input-group">
						<input type="password" placeholder="Mật khẩu mới"
							name="newPassword" required>
					</div>

					<div class="input-group">
						<input type="password" placeholder="Xác nhận mật khẩu"
							name="confirmPassword" required>
					</div>

					<button type="submit" class="btn-login">Cập nhật mật khẩu</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
