/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.cedeno.model;

/**
 *
 * @author Melissa
 */
public class ProductVO {
    private int idProduct;
    private String nameProduct;
    private String descriProduct;
    private int stockProduct;
    private float priceProduct;

    public ProductVO() {
    }

    public ProductVO(int idProduct, String nameProduct, String descriProduct, int stockProduct, float priceProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.descriProduct = descriProduct;
        this.stockProduct = stockProduct;
        this.priceProduct = priceProduct;
    }

    
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriProduct() {
        return descriProduct;
    }

    public void setDescriProduct(String descriProduct) {
        this.descriProduct = descriProduct;
    }

    public int getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(int stockProduct) {
        this.stockProduct = stockProduct;
    }

    public float getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public String toString() {
        return "ProductVO{" + "idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", descriProduct=" + descriProduct + ", stockProduct=" + stockProduct + ", priceProduct=" + priceProduct + '}';
    }
    
    
    
    
    
}
