/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ai.client.iwanttoeat.entity;

import edu.ai.client.iwanttoeat.entity.Cuisine;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

/**
 *
 * @author Анна
 */
@Entity
public class Dish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "DESCRIPTION", length = 1024)
    private String description;

    @Column(name = "DIFFICULTY")
    private int difficulty;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "DESEASE_DISH",
    joinColumns =
    @JoinColumn(name = "DISH_ID", referencedColumnName = "ID"),
    inverseJoinColumns =
    @JoinColumn(name = "DISEASE_ID", referencedColumnName = "ID"))
    private Collection<Disease> goodFor;

    @ManyToOne
    @JoinColumn(name = "CUISINE_ID", referencedColumnName = "ID")
    private Cuisine cuisine;

    @ManyToMany
    @JoinTable(name = "DISH_PRODUCT",
    joinColumns =
    @JoinColumn(name = "DISH_ID", referencedColumnName = "ID"),
    inverseJoinColumns =
    @JoinColumn(name = "PRODUCT_NAME", referencedColumnName = "NAME"))
    private Collection<Product> products;

    public Dish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Collection<Disease> getGoodFor() {
        return goodFor;
    }

    public void setGoodFor(Collection<Disease> goodFor) {
        this.goodFor = goodFor;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
