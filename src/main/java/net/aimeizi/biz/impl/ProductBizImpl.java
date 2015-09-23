package net.aimeizi.biz.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.aimeizi.biz.ProductBiz;
import net.aimeizi.dao.ProductDao;
import net.aimeizi.model.Product;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("productBizImpl")
@Transactional
public class ProductBizImpl implements ProductBiz {

    private ProductDao productDao;

    @Resource(name = "compassTemplate")
    private CompassTemplate compassTemplate;


    @Resource(name = "productDaoImpl")
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delete(Product product) {
        return productDao.delete(product);
    }

    public Product get(int id) {
        return productDao.get(id);
    }

    public List<Product> listAll(int pageNumber, int pageSize) {
        return productDao.listAll(pageNumber, pageSize);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean save(Product product) {
        return productDao.save(product);
    }

    //用于compass搜索的
    public List search(String queryString) {

        List list = new ArrayList();

        CompassSession session = compassTemplate.getCompass().openSession();
        CompassHits hits = session.queryBuilder().queryString(queryString).toQuery().hits();

        System.out.println("本次搜索关键字是:" + queryString);
        System.out.println("本次搜索结果:" + hits.length());

        for (int i = 0; i < hits.length(); i++) {
            Object object = hits.data(i);
            if (object instanceof Product) {
                Product product = (Product) object;
                String name = hits.highlighter(i).fragment("name");
                String price = hits.highlighter(i).fragment("price");
                String descption = hits.highlighter(i).fragment("descption");
                /*String categoryname=hits.highlighter(i).fragment("category.name");
				System.out.println(categoryname);*/
                if (name != null) {
                    product.setName(name);
                }
                if (price != null) {
                    product.setPrice(Float.parseFloat(price));
                }
                if (descption != null) {
                    product.setDescption(descption);
                }
                list.add(product);
            }
			/*if(object instanceof Category ){
				Category category=(Category) object;
				String name=hits.highlighter(i).fragment("name");
				if(name!=null){
					category.setName(name);
				}
				list.add(category);
			}*/
        }

        return list;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean update(Product product) {
        return productDao.update(product);
    }

    public void setCompassTemplate(CompassTemplate compassTemplate) {
        this.compassTemplate = compassTemplate;
    }


}
