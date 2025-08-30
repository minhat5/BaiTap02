package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.models.Category;

public class CategoryDaoImpl extends DBConnection implements CategoryDao {

	@Override
	public void insert(Category c) {
		String sql = "INSERT INTO Category(cate_name, icons) VALUES (?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, c.getName());
			ps.setString(2, c.getIcon());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Category c) {
		String sql = "UPDATE Category SET cate_name=?, icons=? WHERE cate_id=?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, c.getName());
			ps.setString(2, c.getIcon());
			ps.setInt(3, c.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Category WHERE cate_id=?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Category get(int id) {
		String sql = "SELECT * FROM Category WHERE cate_id=?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return map(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category get(String name) {
		String sql = "SELECT * FROM Category WHERE cate_name=?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, name);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return map(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAll() {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT * FROM Category ORDER BY cate_id DESC";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next())
				list.add(map(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Category> search(String keyword) {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT * FROM Category WHERE cate_name LIKE ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, "%" + keyword + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next())
					list.add(map(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private Category map(ResultSet rs) throws SQLException {
		return new Category(rs.getInt("cate_id"), rs.getString("cate_name"), rs.getString("icons"));
	}

}
