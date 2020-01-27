/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

/**
 *
 * @author Henry
 */
public class Vehicle {
    
    private String ID;
    private String brand;
    private String model;

    public Vehicle(String ID, String brand, String model) {
        this.ID = ID;
        this.brand = brand;
        this.model = model;
    }

    public Vehicle() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
}
