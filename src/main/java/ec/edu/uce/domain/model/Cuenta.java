package ec.edu.uce.domain.model;

import java.math.BigDecimal;
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
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @SequenceGenerator(name = "seq_cuenta_generador", sequenceName = "sec_cuenta", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq_cuenta_generador")
    @Column(name = "cuen_id")
    private Integer id;
    @Column(name = "cuen_numero_cuenta")
    private String numeroCuenta;
    @Column(name = "cuen_nombre_titular")
    private String nombreTitular;
    @Column(name = "cuen_monto")
    private BigDecimal monto;

    @OneToMany(mappedBy= "cuentaDestino", cascade= CascadeType.ALL)
    private List<Transferencia> transferenciasRecibidas;

    @OneToMany(mappedBy = "cuentaOrigen", cascade = CascadeType.ALL)
    private List<Transferencia> transferenciasRealizadas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public List<Transferencia> getTransferenciasRecibidas() {
        return transferenciasRecibidas;
    }

    public void setTransferenciasRecibidas(List<Transferencia> transferenciasRecibidas) {
        this.transferenciasRecibidas = transferenciasRecibidas;
    }

    public List<Transferencia> getTransferenciasRealizadas() {
        return transferenciasRealizadas;
    }

    public void setTransferenciasRealizadas(List<Transferencia> transferenciasRealizadas) {
        this.transferenciasRealizadas = transferenciasRealizadas;
    }

    


    

    

}
