package net.aimeizi.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import net.aimeizi.biz.CategoryBiz;
import net.aimeizi.dao.CategoryDao;
import net.aimeizi.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("categoryBizImpl")
@Transactional
public class CategoryBizImpl implements CategoryBiz {

    @Resource(name = "categoryDaoImpl")
    private CategoryDao categoryDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delete(Category category) {
        return categoryDao.delete(category);
    }

    public Category get(int id) {
        return categoryDao.get(id);
    }

    public List<Category> listAll(int pageNumber, int pageSize) {
        return categoryDao.listAll(pageNumber, pageSize);
    }


    public List<Category> listAll() {
        return categoryDao.listAll();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public boolean save(Category category) {
        return categoryDao.save(category);
    }

    public List<Category> search(String queryString) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean update(Category category) {
        return categoryDao.update(category);
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


}
