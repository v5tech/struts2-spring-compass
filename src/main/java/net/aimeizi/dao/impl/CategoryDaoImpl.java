package net.aimeizi.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.aimeizi.dao.CategoryDao;
import net.aimeizi.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("categoryDaoImpl")
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

    @Resource(name = "sessionFactory")
    public void setSessionFactorys(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }


    public boolean delete(Category category) {
        try {
            this.getHibernateTemplate().delete(category);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Category get(int id) {
        return this.getHibernateTemplate().get(Category.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Category> listAll(int pageNumber, int pageSize) {
        /*SessionFactory sessionFactory=this.getSessionFactory();
		Session session = sessionFactory.openSession();*/
        Session session = this.getSession();
        Query query = session.createQuery(" from net.aimeizi.model.Category category ");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        List<Category> list = query.list();
        return list;
    }

    public boolean save(Category category) {
        try {
            this.getHibernateTemplate().saveOrUpdate(category);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(Category category) {
        try {
            this.getHibernateTemplate().update(category);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @SuppressWarnings("unchecked")
    public List<Category> listAll() {
        Session session = this.getSession();
        Query query = session.createQuery(" from net.aimeizi.model.Category category ");
        List<Category> list = query.list();
        return list;
    }

}
