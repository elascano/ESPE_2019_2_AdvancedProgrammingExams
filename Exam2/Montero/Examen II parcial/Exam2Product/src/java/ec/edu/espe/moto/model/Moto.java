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
public class Moto {
    private int IDMOTO;
    private String MODELMOTO;
    private String DESPTIONMOTO;
    private float PRICEMOTO;
    private String COLORMOTO;
    private int WARRANTYMOTO;
    private int DISPLACEMENTMOTO;
    private float POWERMOTO;

    public Moto() {
    }

    public Moto(int IDMOTO, String MODELMOTO, String DESPTIONMOTO, float PRICEMOTO, String COLORMOTO, int WARRANTYMOTO, int DISPLACEMENTMOTO, float POWERMOTO) {
        this.IDMOTO = IDMOTO;
        this.MODELMOTO = MODELMOTO;
        this.DESPTIONMOTO = DESPTIONMOTO;
        this.PRICEMOTO = PRICEMOTO;
        this.COLORMOTO = COLORMOTO;
        this.WARRANTYMOTO = WARRANTYMOTO;
        this.DISPLACEMENTMOTO = DISPLACEMENTMOTO;
        this.POWERMOTO = POWERMOTO;
    }

    public int getIDMOTO() {
        return IDMOTO;
    }

    public void setIDMOTO(int IDMOTO) {
        this.IDMOTO = IDMOTO;
    }

    public String getMODELMOTO() {
        return MODELMOTO;
    }

    public void setMODELMOTO(String MODELMOTO) {
        this.MODELMOTO = MODELMOTO;
    }

    public String getDESPTIONMOTO() {
        return DESPTIONMOTO;
    }

    public void setDESPTIONMOTO(String DESPTIONMOTO) {
        this.DESPTIONMOTO = DESPTIONMOTO;
    }

    public float getPRICEMOTO() {
        return PRICEMOTO;
    }

    public void setPRICEMOTO(float PRICEMOTO) {
        this.PRICEMOTO = PRICEMOTO;
    }

    public String getCOLORMOTO() {
        return COLORMOTO;
    }

    public void setCOLORMOTO(String COLORMOTO) {
        this.COLORMOTO = COLORMOTO;
    }

    public int getWARRANTYMOTO() {
        return WARRANTYMOTO;
    }

    public void setWARRANTYMOTO(int WARRANTYMOTO) {
        this.WARRANTYMOTO = WARRANTYMOTO;
    }

    public int getDISPLACEMENTMOTO() {
        return DISPLACEMENTMOTO;
    }

    public void setDISPLACEMENTMOTO(int DISPLACEMENTMOTO) {
        this.DISPLACEMENTMOTO = DISPLACEMENTMOTO;
    }

    public float getPOWERMOTO() {
        return POWERMOTO;
    }

    public void setPOWERMOTO(float POWERMOTO) {
        this.POWERMOTO = POWERMOTO;
    }
          
         
}
