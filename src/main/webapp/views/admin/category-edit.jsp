<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/style.css" />
<%@ include file="../topbar.jsp"%>

<div class="page">
	<div class="container">
		<div class="card">
			<h2>Sửa danh mục</h2>
			<form action="${pageContext.request.contextPath}/admin/category/edit"
				method="post" enctype="multipart/form-data">
				<input type="hidden" name="id" value="${category.id}" />
				<div class="row">
					<label>Tên danh mục</label><br /> <input type="text" name="name"
						value="${category.name}" required />
				</div>
				<div class="row">
					<label>Icon hiện tại</label><br />
					<c:if test="${not empty category.icon}">
						<img
							src="${pageContext.request.contextPath}/image?fname=${category.icon}"
							width="100" />
					</c:if>
				</div>
				<div class="row">
					<label>Icon mới</label><br />
					<input type="file" name="icon" accept="image/*" />
				</div>
				<br />
				<button class="btn" type="submit">Cập nhật</button>
				<a class="btn"
					href="${pageContext.request.contextPath}/admin/category/list">Hủy</a>
			</form>
		</div>
	</div>
</div>
