<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/style.css" />
<%@ include file="../topbar.jsp"%>

<div class="page">
	<div class="container">
		<div class="card">
			<h2>Thêm danh mục</h2>
			<form action="${pageContext.request.contextPath}/admin/category/add"
				method="post" enctype="multipart/form-data">
				<div class="row">
					<label>Tên danh mục</label><br />
					<input type="text" name="name" required />
				</div>
				<div class="row">
					<label>Icon</label><br />
					<input type="file" name="icon" accept="image/*" />
				</div>
				<br />
				<button class="btn" type="submit">Lưu</button>
				<a class="btn"
					href="${pageContext.request.contextPath}/admin/category/list">Hủy</a>
			</form>
		</div>
	</div>
</div>
