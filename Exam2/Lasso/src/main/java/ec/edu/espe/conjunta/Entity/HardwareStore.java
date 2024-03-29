package ec.edu.espe.conjunta.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HardwareStore")
public class HardwareStore {
    @Id
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private Long quantity;

    public HardwareStore() {
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public HardwareStore(Long id, String name, String type, Long quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

}