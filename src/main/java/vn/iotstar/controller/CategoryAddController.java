package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.constant.Constant;
import vn.iotstar.models.Category;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 * Servlet implementation class CategoryAddController
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/admin/category/add")
@MultipartConfig     
public class CategoryAddController extends HttpServlet {
	private final CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		Category c = new Category();
		c.setName(req.getParameter("name"));

		Part iconPart = req.getPart("icon");
		if (iconPart != null && iconPart.getSize() > 0) {
			if (iconPart.getContentType() != null && !iconPart.getContentType().startsWith("image/")) {
				throw new ServletException("Chỉ cho phép upload ảnh");
			}
			String saved = savePart(iconPart, "category");
			c.setIcon(saved);
		}

		cateService.insert(c);
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}

	private String savePart(Part part, String folder) throws IOException {
		String submitted = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String ext = "";
		int dot = submitted.lastIndexOf('.');
		if (dot >= 0)
			ext = submitted.substring(dot);

		String fileName = System.currentTimeMillis() + ext;
		File dir = new File(Constant.DIR, folder);
		if (!dir.exists())
			dir.mkdirs();

		File out = new File(dir, fileName);
		try (InputStream is = part.getInputStream(); OutputStream os = new FileOutputStream(out)) {
			is.transferTo(os);
		}
		return folder + "/" + fileName;
	}

}
