/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.mum.edu.com;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Redrain
 */
@Entity
@Table(name = "CarTbl")
@NamedQueries({
    @NamedQuery(name="Car.getAll", query="select e from Car e"),
    @NamedQuery(name="Car.getById", query="select e from Car e where e.id = :id")
})
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length= 11)
    private int id;
    @Column
    private String make;
    @Column
    private String model;
    
    @Column(name="manufacturingYear", length= 4)
    private int year; 
    
    @Column(length= 11)
    private int miles;
    
    @Enumerated(EnumType.STRING)
    private Color color;

    public Car(String make, String model, int year, int miles, Color color) {
        
        this.make = make;
        this.model = model;
        this.year = year;
        this.miles = miles;
        this.color = color;
    }

    public Car() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cs544.mum.edu.com.Car[ id=" + id + " ]";
    }
    
}
