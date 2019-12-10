/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ╔Diego Huerta╗
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "Product.findByNameProduct", query = "SELECT p FROM Product p WHERE p.nameProduct = :nameProduct")
    , @NamedQuery(name = "Product.findByTypeProduct", query = "SELECT p FROM Product p WHERE p.typeProduct = :typeProduct")
    , @NamedQuery(name = "Product.findByStpckProduct", query = "SELECT p FROM Product p WHERE p.stpckProduct = :stpckProduct")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_product")
    private String idProduct;
    @Basic(optional = false)
    @Column(name = "name_product")
    private String nameProduct;
    @Basic(optional = false)
    @Column(name = "type_product")
    private String typeProduct;
    @Basic(optional = false)
    @Column(name = "stpck_product")
    private int stpckProduct;

    public Product() {
    }

    public Product(String idProduct) {
        this.idProduct = idProduct;
    }

    public Product(String idProduct, String nameProduct, String typeProduct, int stpckProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.typeProduct = typeProduct;
        this.stpckProduct = stpckProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public int getStpckProduct() {
        return stpckProduct;
    }

    public void setStpckProduct(int stpckProduct) {
        this.stpckProduct = stpckProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Product[ idProduct=" + idProduct + " ]";
    }
    
}
