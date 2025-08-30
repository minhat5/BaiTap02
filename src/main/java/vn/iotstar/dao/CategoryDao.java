package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.Category;

public interface CategoryDao {
	void insert(Category c);

	void edit(Category c);

	void delete(int id);

	Category get(int id);

	Category get(String name);

	List<Category> getAll();

	List<Category> search(String keyword);
}
