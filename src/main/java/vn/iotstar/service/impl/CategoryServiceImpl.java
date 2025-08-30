package vn.iotstar.service.impl;

import java.io.File;
import java.util.List;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.models.Category;
import vn.iotstar.service.CategoryService;
import static vn.iotstar.constant.Constant.DIR;

public class CategoryServiceImpl implements CategoryService{
	private final CategoryDao dao = new CategoryDaoImpl();

	@Override
	public void insert(Category c) {
		dao.insert(c);
	}

	@Override
	public void edit(Category newC) {
		Category old = dao.get(newC.getId());
		if (old == null)
			return;
		old.setName(newC.getName());
		// nếu có icon mới thì xoá file cũ
		if (newC.getIcon() != null && !newC.getIcon().isEmpty()) {
			if (old.getIcon() != null) {
				File f = new File(DIR + File.separator + old.getIcon());
				if (f.exists())
					f.delete();
			}
			old.setIcon(newC.getIcon());
		}
		dao.edit(old);
	}

	@Override
	public void delete(int id) {
		Category old = dao.get(id);
		if (old != null && old.getIcon() != null) {
			File f = new File(DIR + File.separator + old.getIcon());
			if (f.exists())
				f.delete();
		}
		dao.delete(id);
	}

	@Override
	public Category get(int id) {
		return dao.get(id);
	}

	@Override
	public Category get(String name) {
		return dao.get(name);
	}

	@Override
	public List<Category> getAll() {
		return dao.getAll();
	}

	@Override
	public List<Category> search(String keyword) {
		return dao.search(keyword);
	}
}
