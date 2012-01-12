/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ai.client.iwanttoeat.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

/**
 *
 * @author Анна
 */
@Entity
public class Vitamin implements Serializable {

    @TableGenerator(name = "vitaminGen",
    table = "PERSISTENCE_FOOD_SEQUENCE_GENERATOR",
    pkColumnName = "GEN_KEY",
    valueColumnName = "GEN_VALUE",
    pkColumnValue = "ID",
    allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "vitaminGen")
    private int id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "vitamins")
    private Collection<Product> products;

    public Vitamin() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
