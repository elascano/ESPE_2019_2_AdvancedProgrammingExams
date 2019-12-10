/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webresources;

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
 * @author Guiro
 */
@Entity
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
    , @NamedQuery(name = "Products.findByProdId", query = "SELECT p FROM Products p WHERE p.prodId = :prodId")
    , @NamedQuery(name = "Products.findByProdName", query = "SELECT p FROM Products p WHERE p.prodName = :prodName")
    , @NamedQuery(name = "Products.findByProdDescripcion", query = "SELECT p FROM Products p WHERE p.prodDescripcion = :prodDescripcion")
    , @NamedQuery(name = "Products.findByProdStock", query = "SELECT p FROM Products p WHERE p.prodStock = :prodStock")
    , @NamedQuery(name = "Products.findByProdPrice", query = "SELECT p FROM Products p WHERE p.prodPrice = :prodPrice")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prod_id")
    private Integer prodId;
    @Basic(optional = false)
    @Column(name = "prod_name")
    private String prodName;
    @Basic(optional = false)
    @Column(name = "prod_descripcion")
    private String prodDescripcion;
    @Basic(optional = false)
    @Column(name = "prod_stock")
    private int prodStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prod_price")
    private Double prodPrice;

    public Products() {
    }

    public Products(Integer prodId) {
        this.prodId = prodId;
    }

    public Products(Integer prodId, String prodName, String prodDescripcion, int prodStock) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodDescripcion = prodDescripcion;
        this.prodStock = prodStock;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDescripcion() {
        return prodDescripcion;
    }

    public void setProdDescripcion(String prodDescripcion) {
        this.prodDescripcion = prodDescripcion;
    }

    public int getProdStock() {
        return prodStock;
    }

    public void setProdStock(int prodStock) {
        this.prodStock = prodStock;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webresources.Products[ prodId=" + prodId + " ]";
    }
    
}
