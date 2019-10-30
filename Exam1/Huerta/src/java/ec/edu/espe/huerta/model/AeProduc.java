/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.huerta.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ae_produc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AeProduc.findAll", query = "SELECT a FROM AeProduc a"),
    @NamedQuery(name = "AeProduc.findByAeProCode", query = "SELECT a FROM AeProduc a WHERE a.aeProCode = :aeProCode"),
    @NamedQuery(name = "AeProduc.findByAeProDescri", query = "SELECT a FROM AeProduc a WHERE a.aeProDescri = :aeProDescri"),
    @NamedQuery(name = "AeProduc.findByAeProStock", query = "SELECT a FROM AeProduc a WHERE a.aeProStock = :aeProStock"),
    @NamedQuery(name = "AeProduc.findByAeProCatego", query = "SELECT a FROM AeProduc a WHERE a.aeProCatego = :aeProCatego"),
    @NamedQuery(name = "AeProduc.findByAeProPrice", query = "SELECT a FROM AeProduc a WHERE a.aeProPrice = :aeProPrice")})
public class AeProduc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AE_PRO_CODE")
    private String aeProCode;
    @Basic(optional = false)
    @Column(name = "AE_PRO_DESCRI")
    private String aeProDescri;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "AE_PRO_STOCK")
    private BigDecimal aeProStock;
    @Basic(optional = false)
    @Column(name = "AE_PRO_CATEGO")
    private String aeProCatego;
    @Basic(optional = false)
    @Column(name = "AE_PRO_PRICE")
    private BigDecimal aeProPrice;

    public AeProduc() {
    }

    public AeProduc(String aeProCode) {
        this.aeProCode = aeProCode;
    }

    public AeProduc(String aeProCode, String aeProDescri, BigDecimal aeProStock, String aeProCatego, BigDecimal aeProPrice) {
        this.aeProCode = aeProCode;
        this.aeProDescri = aeProDescri;
        this.aeProStock = aeProStock;
        this.aeProCatego = aeProCatego;
        this.aeProPrice = aeProPrice;
    }

    public String getAeProCode() {
        return aeProCode;
    }

    public void setAeProCode(String aeProCode) {
        this.aeProCode = aeProCode;
    }

    public String getAeProDescri() {
        return aeProDescri;
    }

    public void setAeProDescri(String aeProDescri) {
        this.aeProDescri = aeProDescri;
    }

    public BigDecimal getAeProStock() {
        return aeProStock;
    }

    public void setAeProStock(BigDecimal aeProStock) {
        this.aeProStock = aeProStock;
    }

    public String getAeProCatego() {
        return aeProCatego;
    }

    public void setAeProCatego(String aeProCatego) {
        this.aeProCatego = aeProCatego;
    }

    public BigDecimal getAeProPrice() {
        return aeProPrice;
    }

    public void setAeProPrice(BigDecimal aeProPrice) {
        this.aeProPrice = aeProPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aeProCode != null ? aeProCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AeProduc)) {
            return false;
        }
        AeProduc other = (AeProduc) object;
        if ((this.aeProCode == null && other.aeProCode != null) || (this.aeProCode != null && !this.aeProCode.equals(other.aeProCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.huerta.model.AeProduc[ aeProCode=" + aeProCode + " ]";
    }
    
}
