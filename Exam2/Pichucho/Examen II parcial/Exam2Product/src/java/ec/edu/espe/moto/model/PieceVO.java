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
public class PieceVO {
    private int idPiece;
    private String namePiece;
    private String categoryPiece;
    private String descriptionPiece;
    private float pricePiece;
    private int quantityPiece;

    public PieceVO() {
    }

    public PieceVO(int idPiece, String namePiece, String categoryPiece, String descriptionPiece, float pricePiece, int quantityPiece) {
        this.idPiece = idPiece;
        this.namePiece = namePiece;
        this.categoryPiece = categoryPiece;
        this.descriptionPiece = descriptionPiece;
        this.pricePiece = pricePiece;
        this.quantityPiece = quantityPiece;
    }

    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
    }

    public String getNamePiece() {
        return namePiece;
    }

    public void setNamePiece(String namePiece) {
        this.namePiece = namePiece;
    }

    public String getCategoryPiece() {
        return categoryPiece;
    }

    public void setCategoryPiece(String categoryPiece) {
        this.categoryPiece = categoryPiece;
    }

    public String getDescriptionPiece() {
        return descriptionPiece;
    }

    public void setDescriptionPiece(String descriptionPiece) {
        this.descriptionPiece = descriptionPiece;
    }

    public float getPricePiece() {
        return pricePiece;
    }

    public void setPricePiece(float pricePiece) {
        this.pricePiece = pricePiece;
    }

    public int getQuantityPiece() {
        return quantityPiece;
    }

    public void setQuantityPiece(int quantityPiece) {
        this.quantityPiece = quantityPiece;
    }
}
