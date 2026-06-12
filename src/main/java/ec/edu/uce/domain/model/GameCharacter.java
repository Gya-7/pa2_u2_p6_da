package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "character")
public class GameCharacter {

    @Id
    @SequenceGenerator(name = "seq_character_generator", sequenceName = "sec_character", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_character_generator")
    @Column(name = "char_id")
    private Integer id;

    @Column(name = "char_nickname")
    private String nickname;

    @Column(name = "char_class_type") 
    private String classType;

    @Column(name = "char_level")
    private Integer level; 

    @Column(name = "char_life_points")
    private Integer lifePoints; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getType() {
        return classType;
    }

    public void setType(String classType) {
        this.classType = classType;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", nickname=" + nickname + ", type=" + classType + ", level=" + level
                + ", lifePoints=" + lifePoints + "]";
    }

    
    

}
