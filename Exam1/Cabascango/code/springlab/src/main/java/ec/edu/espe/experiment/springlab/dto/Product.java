package ec.edu.espe.experiment.springlab.dto;


public class Product{

    private Integer id;
    private String name;
    private String description;
    private Integer quantity;
    private Float price;
    
    public Product(){
    }
 
    public Product(Integer id){
        this.id = id;
    }
 
    public Product(Integer id, String name, String description, Integer quantity, Float price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    //Setters & Getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
  
}