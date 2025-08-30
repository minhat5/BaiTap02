package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.CategoryService;

import java.io.IOException;

/**
 * Servlet implementation class CategoryDeleteController
 */
@WebServlet(urlPatterns = "/admin/category/delete")
public class CategoryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		cateService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}

}
