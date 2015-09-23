package net.aimeizi.biz;

import net.aimeizi.model.Category;

import java.util.List;

public interface CategoryBiz {

    boolean save(Category category);

    boolean update(Category category);

    boolean delete(Category category);

    Category get(int id);

    List<Category> listAll(int pageNumber, int pageSize);


    List<Category> listAll();

    /**
     * 用于compass搜索的
     *
     * @param queryString
     * @return
     */
    List<Category> search(String queryString);
}
