package net.aimeizi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

@Entity
@Table(name = "category")
@Searchable(alias = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    private int id;
    @Column(name = "name", length = 50)
    @SearchableProperty(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    //@SearchableComponent(refAlias="product")
    private Set<Product> set;

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

    public Set<Product> getSet() {
        return set;
    }

    public void setSet(Set<Product> set) {
        this.set = set;
    }


}
