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
public class User {
    private int IDUSER;
    private String NAME;
    private String LASTNAME;
    private String PHONE;
    private String TYPE;
    private String EMAIL;
    private String USER;
    private String PASSWORD;

    public User() {
    }

    public User(int IDUSER, String NAME, String LASTNAME, String PHONE, String TYPE, String EMAIL, String USER, String PASSWORD) {
        this.IDUSER = IDUSER;
        this.NAME = NAME;
        this.LASTNAME = LASTNAME;
        this.PHONE = PHONE;
        this.TYPE = TYPE;
        this.EMAIL = EMAIL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public int getIDUSER() {
        return IDUSER;
    }

    public void setIDUSER(int IDUSER) {
        this.IDUSER = IDUSER;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
    
    
    
    
}
