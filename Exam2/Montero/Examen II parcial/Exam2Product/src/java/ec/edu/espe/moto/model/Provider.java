/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.model;

/**
 *
 * @author Galo Pichucho
 */
public class Provider {
    
    private int idprovider; 
    private  String rucprovider;          
    private  String nameprovider;        
    private  String addressprovider;     
    private  String cityprovider;         
    private  String representativeprovider; 
    private  String phoneprovider;        
    private  String cellphoneprovider;    
    private  String emailproveedor;       
    private  String faxprovider;

    public Provider() {
    }

    public Provider(int idprovider, String rucprovider, String nameprovider, String addressprovider, String cityprovider, String representativeprovider, String phoneprovider, String cellphoneprovider, String emailproveedor, String faxprovider) {
        this.idprovider = idprovider;
        this.rucprovider = rucprovider;
        this.nameprovider = nameprovider;
        this.addressprovider = addressprovider;
        this.cityprovider = cityprovider;
        this.representativeprovider = representativeprovider;
        this.phoneprovider = phoneprovider;
        this.cellphoneprovider = cellphoneprovider;
        this.emailproveedor = emailproveedor;
        this.faxprovider = faxprovider;
    }

    public int getIdprovider() {
        return idprovider;
    }

    public void setIdprovider(int idprovider) {
        this.idprovider = idprovider;
    }

    public String getRucprovider() {
        return rucprovider;
    }

    public void setRucprovider(String rucprovider) {
        this.rucprovider = rucprovider;
    }

    public String getNameprovider() {
        return nameprovider;
    }

    public void setNameprovider(String nameprovider) {
        this.nameprovider = nameprovider;
    }

    public String getAddressprovider() {
        return addressprovider;
    }

    public void setAddressprovider(String addressprovider) {
        this.addressprovider = addressprovider;
    }

    public String getCityprovider() {
        return cityprovider;
    }

    public void setCityprovider(String cityprovider) {
        this.cityprovider = cityprovider;
    }

    public String getRepresentativeprovider() {
        return representativeprovider;
    }

    public void setRepresentativeprovider(String representativeprovider) {
        this.representativeprovider = representativeprovider;
    }

    public String getPhoneprovider() {
        return phoneprovider;
    }

    public void setPhoneprovider(String phoneprovider) {
        this.phoneprovider = phoneprovider;
    }

    public String getCellphoneprovider() {
        return cellphoneprovider;
    }

    public void setCellphoneprovider(String cellphoneprovider) {
        this.cellphoneprovider = cellphoneprovider;
    }

    public String getEmailproveedor() {
        return emailproveedor;
    }

    public void setEmailproveedor(String emailproveedor) {
        this.emailproveedor = emailproveedor;
    }

    public String getFaxprovider() {
        return faxprovider;
    }

    public void setFaxprovider(String faxprovider) {
        this.faxprovider = faxprovider;
    }
    

}
