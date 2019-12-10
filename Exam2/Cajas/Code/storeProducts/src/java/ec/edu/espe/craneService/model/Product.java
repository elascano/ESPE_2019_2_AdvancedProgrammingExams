/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.model;

/**
 *
 * @author diego
 */
public class Product {
    private int id;
    private String name;
    private String type;
    private int quatity;

    public Product(int id, String name, String type, int quatity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quatity = quatity;
    }

    public Product() {
        this.id = 0;
        this.name = "";
        this.type = "";
        this.quatity = 0;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

   
}
