package net.aimeizi.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.aimeizi.dao.ProductDao;
import net.aimeizi.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("productDaoImpl")
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

    @Resource(name = "sessionFactory")
    public void setSessionFactorys(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    public boolean delete(Product product) {
        try {
            this.getHibernateTemplate().delete(product);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Product get(int id) {
        return this.getHibernateTemplate().get(Product.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Product> listAll(int pageNumber, int pageSize) {
        /*SessionFactory sessionFactory=this.getSessionFactory();
		Session session = sessionFactory.openSession();*/
        Session session = this.getSession();
        Query query = session.createQuery(" from net.aimeizi.model.Product product ");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        List<Product> list = query.list();
        return list;
    }

    public boolean save(Product product) {
        try {
            this.getHibernateTemplate().save(product);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(Product product) {
        try {
            this.getHibernateTemplate().update(product);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
