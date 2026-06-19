package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @SequenceGenerator(name = "seq_inventory_generator", sequenceName = "sec_inventory", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inventory_generator")
    @Column(name = "inve_id")
    private Integer id;

    @Column(name = "inve_total_space")
    private Integer totalSpace;

    @Column(name = "inve_occupied_space")
    private Integer occupiedSpace;

    @Column(name = "inve_state")
    private String state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inve_player")
    private GameCharacter character;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<Item> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(Integer totalSpace) {
        this.totalSpace = totalSpace;
    }

    public Integer getOccupiedSpace() {
        return occupiedSpace;
    }

    public void setOccupiedSpace(Integer occupiedSpace) {
        this.occupiedSpace = occupiedSpace;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public void setCharacter(GameCharacter character) {
        this.character = character;
    }

    public List<Item> getItem() {
        return items;
    }

    public void setItem(List<Item> item) {
        this.items = item;
    }
    
    @Override
    public String toString() {
        return "Inventory [id=" + id + ", totalSpace=" + totalSpace + ", occupiedSpace=" + occupiedSpace + ", state="
                + state + ", character=" + character + "]";
    }
    
}
