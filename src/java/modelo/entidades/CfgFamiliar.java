/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "hc_estructura_familiar", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgFamiliar.findAll", query = "SELECT c FROM CfgFamiliar c"),
    @NamedQuery(name = "CfgFamiliar.findByIdPaciente", query = "SELECT c FROM CfgFamiliar c WHERE c.idPaciente= :idPaciente")})
public class CfgFamiliar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estructura_familiar", nullable = false)
    private Integer idEstructuraFamiliar;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente", nullable = false)
    @ManyToOne(optional = false)
    private CfgPacientes idPaciente;
    @Column(name = "nombre", length = 2147483647)
    private String nombre;
    @Column(name = "edad")
    private Integer edad;
    
//     @JoinColumn(name = "parentesco", referencedColumnName = "id")
//    @ManyToOne
//    private CfgClasificaciones parentesco;
//     
    @JoinColumn(name = "id_parentesco", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = true)
    private CfgClasificaciones idParentesco;
    
    @JoinColumn(name = "id_ocupacion", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = true)
    private CfgClasificaciones idOcupacion;
     
    public CfgFamiliar() {
    }

    public CfgFamiliar(Integer idEstructuraFamiliar) {
        this.idEstructuraFamiliar = idEstructuraFamiliar;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstructuraFamiliar != null ? idEstructuraFamiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgFamiliar)) {
            return false;
        }
        CfgFamiliar other = (CfgFamiliar) object;
        if ((this.idEstructuraFamiliar == null && other.idEstructuraFamiliar != null) || (this.idEstructuraFamiliar != null && !this.idEstructuraFamiliar.equals(other.idEstructuraFamiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.CfgFamiliar[ idEstructuraFamiliar=" + idEstructuraFamiliar + " ]";
    }

    public Integer getIdEstructuraFamiliar() {
        return idEstructuraFamiliar;
    }

    public void setIdEstructuraFamiliar(Integer idEstructuraFamiliar) {
        this.idEstructuraFamiliar = idEstructuraFamiliar;
    }

    public CfgPacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(CfgPacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public CfgClasificaciones getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(CfgClasificaciones idParentesco) {
        this.idParentesco = idParentesco;
    }

    public CfgClasificaciones getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(CfgClasificaciones idOcupacion) {
        this.idOcupacion = idOcupacion;
    }
    
}
