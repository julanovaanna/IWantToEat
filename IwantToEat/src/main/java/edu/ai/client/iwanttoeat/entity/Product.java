/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ai.client.iwanttoeat.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Анна
 */
@Entity
public class Product implements Serializable {

    @Id
    private String name;

    private String description;

    @ManyToMany
    @JoinTable(name = "PRODUCT_VITAMIN",
    joinColumns =
    @JoinColumn(name = "PRODUCT_NAME", referencedColumnName = "NAME"),
    inverseJoinColumns =
    @JoinColumn(name = "VITAMIN_ID", referencedColumnName = "ID"))
    private Collection<Vitamin> vitamins;

    @ManyToMany(mappedBy = "products")
    private List<Dish> dishes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Vitamin> getVitamins() {
        return vitamins;
    }

    public void setVitamins(Collection<Vitamin> vitamins) {
        this.vitamins = vitamins;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
