/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ai.client.iwanttoeat.entity;

import com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon;
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
public class Disease implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(mappedBy="goodFor")
    private Collection<Dish> dishes;

    private String diagnosis;

    public Disease() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Collection<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
