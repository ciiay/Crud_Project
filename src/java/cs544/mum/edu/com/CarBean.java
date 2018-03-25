/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.mum.edu.com;

import carpersistence.ManagerDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Redrain
 */
@ManagedBean
@SessionScoped
public class CarBean {
    private ManagerDAO managerDAO;

    private int id;
    private String make;
    private String model;
    private int year; 
    private int miles;
    private Color color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
    public CarBean() {
        managerDAO = new ManagerDAO();
    }
    
    public List<Car> getAllCars() {
        return managerDAO.findAllCars();
    }
    
    public String createCar() {
        
        Car car = new Car();
        car.setMake(this.make);
        car.setModel(this.model);
        car.setYear(this.year);
        car.setMiles(this.miles);
        car.setColor(this.color);
        
        managerDAO.addCar(car);
        car = null;
        make = null;
        model = null;
        year = 0;
        miles = 0;
        color = null;
        return "";
    }
    
    public String deleteCar(Car car) {
        managerDAO.removeCar(car.getId());
        return "";
    }
    
    public String loadCar(Car car) {
        id = car.getId();
        make = car.getMake();
        model = car.getModel();
        year = car.getYear();
        miles = car.getMiles();
        color = car.getColor();
        
        return "editCar";
    }
    
    public String editCar() {
        Car car = new Car();
        car.setId(id);
        car.setMake(this.make);
        car.setModel(this.model);
        car.setYear(this.year);
        car.setMiles(this.miles);
        car.setColor(this.color);
        
        managerDAO.updateCar(car);
        car = null;
        make = null;
        model = null;
        year = 0;
        miles = 0;
        color = null;
        
        return "index";
    }

}
