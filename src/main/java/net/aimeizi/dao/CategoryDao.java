package net.aimeizi.dao;

import net.aimeizi.model.Category;

import java.util.List;

public interface CategoryDao {

    boolean save(Category category);

    boolean update(Category category);

    boolean delete(Category category);

    Category get(int id);

    List<Category> listAll(int pageNumber, int pageSize);

    List<Category> listAll();
}
