package net.aimeizi.dao;

import net.aimeizi.model.Product;

import java.util.List;

public interface ProductDao {

    boolean save(Product product);

    boolean update(Product product);

    boolean delete(Product product);

    Product get(int id);

    List<Product> listAll(int pageNumber, int pageSize);

}
