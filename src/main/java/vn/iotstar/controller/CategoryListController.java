package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class CategoryListController
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/admin/category/list")
public class CategoryListController extends HttpServlet {
	private final CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("cateList", cateService.getAll());
		req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
	}
}
