/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpersistence;

import cs544.mum.edu.com.Car;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
/**
 *
 * @author Redrain
 */
public class ManagerDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public ManagerDAO() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("CarPU");
        }
        if(em == null) {
            em = emf.createEntityManager();
        }
        
    }
    
    public void start() {
        if (emf != null) {
            end();
        }
        emf = Persistence.createEntityManagerFactory("CarPU");
        em = emf.createEntityManager();
    }
    
    public void end() {
        if (emf != null) {
            em.close();
            emf.close();
            emf = null;
        }
     }
    
    // Create Car
    public void addCar(Car car) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(car);
        tx.commit();
    }
    
    public void updateCar(Car car) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.merge(car);
        tx.commit();
        
    }
    
        
    public Car getCarById(int id) {
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Car car = em.find(Car.class, id);
        
        tx.commit();
        return car;
    }
    
    public void removeCar(int id) {
       
        Car car = em.find(Car.class, id);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.remove(car);
        tx.commit();
        
    }
    
    public List<Car> findAllCars() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        List<Car> list = em.createNamedQuery("Car.getAll", Car.class).getResultList();
        
        tx.commit();
        return list;
    }
}
