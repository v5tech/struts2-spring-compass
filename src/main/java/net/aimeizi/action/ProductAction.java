package net.aimeizi.action;

import com.opensymphony.xwork2.ActionSupport;
import net.aimeizi.biz.CategoryBiz;
import net.aimeizi.biz.ProductBiz;
import net.aimeizi.model.Category;
import net.aimeizi.model.Product;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("productAction")
public class ProductAction extends ActionSupport {

    private ProductBiz productBiz;

    @Resource(name = "categoryBizImpl")
    private CategoryBiz categoryBiz;


    private Product product;

    @Resource(name = "productBizImpl")
    public void setProductBiz(ProductBiz productBiz) {
        this.productBiz = productBiz;
    }

    public String save() throws Exception {
        Category category = categoryBiz.get(product.getCategory().getId());
        product.setCategory(category);
        productBiz.save(product);
        return "query";
    }

    public String get() throws Exception {
        List<Category> listCategory;
        listCategory = categoryBiz.listAll();
        product = productBiz.get(product.getId());
        ServletActionContext.getRequest().setAttribute("listCategory", listCategory);
        return "update";
    }


    public String delete() throws Exception {
        productBiz.delete(product);
        return "query";
    }


    public String update() throws Exception {
        productBiz.update(product);
        return "query";
    }

    public String list() throws Exception {
        List<Product> list;
        int pageNumber = 0;
        try {
            pageNumber = Integer.parseInt(ServletActionContext.getRequest().getParameter("pageNumber"));
        } catch (RuntimeException e) {
            //e.printStackTrace();
            pageNumber = 0;
        }
        int pageSize = 5;
        try {
            pageSize = Integer.parseInt(ServletActionContext.getRequest().getParameter("pageSize"));
        } catch (RuntimeException e) {
            //e.printStackTrace();
            pageSize = Integer.MAX_VALUE;
        }
        list = productBiz.listAll(pageNumber, pageSize);
        ServletActionContext.getRequest().setAttribute("list", list);
        return "list";
    }

    /**
     * compass搜索
     *
     * @return
     * @throws Exception
     */
    public String search() throws Exception {
        List list = productBiz.search(ServletActionContext.getRequest().getParameter("queryString"));
        ServletActionContext.getRequest().setAttribute("list", list);
        return "list";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCategoryBiz(CategoryBiz categoryBiz) {
        this.categoryBiz = categoryBiz;
    }


    public String tosave() throws Exception {
        List<Category> listCategory = categoryBiz.listAll();
        ServletActionContext.getRequest().setAttribute("listCategory", listCategory);
        return "tosave";
    }


}
