package net.aimeizi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.compass.annotations.Cascade;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

@Entity
@Table(name = "product")
@Searchable(alias = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    private int id;
    @Column(name = "name", length = 50)
    @SearchableProperty(name = "name")
    private String name;
    @Column(name = "price", length = 18)
    @SearchableProperty(name = "price")
    private float price;
    @Column(name = "descption", length = 20)
    @SearchableProperty(name = "descption")
    private String descption;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    @SearchableComponent(refAlias = "category", cascade = Cascade.ALL)
    private Category category;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescption() {
        return descption;
    }

    public void setDescption(String descption) {
        this.descption = descption;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
