package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
@NamedQueries({
    @NamedQuery(name = "Profesor.listarApellidoNombreAsc", query = "SELECT p FROM Profesor p ORDER BY p.apellido ASC, p.nombre ASC"),
    @NamedQuery(name = "Profesor.listarPorCargaHoraria", query = "SELECT p FROM Profesor p WHERE p.cargaHoraria BETWEEN :min AND :max"),
    @NamedQuery(name = "Profesor.contarPorDepartamento", query = "SELECT COUNT(p) FROM Profesor p WHERE p.departamento = :departamento")
})
public class Profesor {

    @Id
    @SequenceGenerator(name = "seq_profesor_generador", sequenceName = "sec_profesor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profesor_generador")
    @Column(name = "prof_id")
    private Integer id;

    @Column(name = "prof_cedula")
    private String cedula;

    @Column(name = "prof_nombre")
    private String nombre;

    @Column(name = "prof_apellido")
    private String apellido;

    @Column(name = "prof_departamento")
    private String departamento;

    @Column(name = "prof_fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "prof_fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "prof_carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "prof_correo")
    private String correo;

    

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer carga_horaria) {
        this.cargaHoraria = carga_horaria;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Profesor Id: " + id + ", cedula: " + cedula + ", nombre: " + nombre + ", apellido: " + apellido
                + ", departamento: " + departamento + ", carga horaria: " + cargaHoraria + ", correo: " + correo;
    }

}
