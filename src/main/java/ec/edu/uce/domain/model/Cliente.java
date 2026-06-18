package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @SequenceGenerator(name = "seq_cliente_generador", sequenceName= "sec_cliente", allocationSize= 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_cliente_generador")
    @Column(name = "clie_id")
    private Integer id;
    @Column(name = "clie_cedula")
    private String cedula;
    @Column(name = "clie_nombre")
    private String nombre;

    @OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("id=").append(id);
        sb.append(", cedula=").append(cedula);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }

   

    

}
