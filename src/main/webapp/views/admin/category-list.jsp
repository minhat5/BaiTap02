<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/style.css" />

<%@ include file="../topbar.jsp"%>
<div class="page">
	<div class="container">
		<div class="card" style="width: 100%;">
			<h2>Danh sách danh mục</h2>
			<p>
				<a class="btn"
					href="${pageContext.request.contextPath}/admin/category/add">+
					Thêm danh mục</a>
			</p>
			<table class="table">
				<tr>
					<th>#</th>
					<th>Icon</th>
					<th>Tên</th>
					<th>Hành động</th>
				</tr>
				<c:forEach var="cate" items="${cateList}" varStatus="st">
					<tr>
						<td>${st.index + 1}</td>
						<td><c:if test="${not empty cate.icon}">
								<img
									src="${pageContext.request.contextPath}/image?fname=${cate.icon}"
									width="80" />
							</c:if></td>
						<td><c:out value="${cate.name}" /></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/category/edit?id=${cate.id}">Sửa</a>
							| <a
							href="${pageContext.request.contextPath}/admin/category/delete?id=${cate.id}"
							onclick="return confirm('Xóa danh mục này?');">Xóa</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
