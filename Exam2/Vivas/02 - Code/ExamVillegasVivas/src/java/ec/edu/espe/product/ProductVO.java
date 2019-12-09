/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.product;

/**
 *
 * @author Santiago Vivas
 */
public class ProductVO {
    String id;
    String name;
    String type;
    String quantity;
    
    public ProductVO(){}

    public ProductVO(String idProduct, String nameProduct, String typeProduct, String quantityProduct) {
        this.id = idProduct;
        this.name = nameProduct;
        this.type = typeProduct;
        this.quantity = quantityProduct;
    }
    

    public String getIdProduct() {
        return id;
    }

    public void setIdProduct(String idProduct) {
        this.id = idProduct;
    }

    public String getNameProduct() {
        return name;
    }

    public void setNameProduct(String nameProduct) {
        this.name = nameProduct;
    }

    public String getTypeProduct() {
        return type;
    }

    public void setTypeProduct(String typeProduct) {
        this.type = typeProduct;
    }

    public String getQuantityProduct() {
        return quantity;
    }

    public void setQuantityProduct(String quantityProduct) {
        this.quantity = quantityProduct;
    }

    @Override
    public String toString() {
        return "ProductVO{" + "idProduct=" + id + ", nameProduct=" + name + ", typeProduct=" + type + ", quantityProduct=" + quantity + '}';
    }
    
    
}
