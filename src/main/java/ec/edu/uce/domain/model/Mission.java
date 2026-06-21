package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "mission")
public class Mission {

    @Id
    @SequenceGenerator(name = "seq_mision_generator", sequenceName = "sec_mision", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mision_generator")
    @Column(name = "miss_id")
    private Integer id;
    @Column(name = "miss_title")
    private String title;
    @Column(name = "miss_description")
    private String description;
    @Column(name = "miss_required_level")
    private Integer requiredLevel;
    @Column(name = "miss_points")
    private Double points;

    @ManyToMany(mappedBy = "missions", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GameCharacter> characters;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitulo(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getRequiredLevel() {
        return requiredLevel;
    }
    public void setNivelRequerido(Integer requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
    public Double getPoints() {
        return points;
    }
    public void setPoints(Double points) {
        this.points = points;
    }
    public List<GameCharacter> getCharacters() {
        return characters;
    }
    public void setCharacters(List<GameCharacter> characters) {
        this.characters = characters;
    }

    

}
