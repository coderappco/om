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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "fac_smlv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacSmlv.findAll", query = "SELECT f FROM FacSmlv f")
    , @NamedQuery(name = "FacSmlv.findByAnnio", query = "SELECT f FROM FacSmlv f WHERE f.annio = :annio")
    , @NamedQuery(name = "FacSmlv.findByValorSalario", query = "SELECT f FROM FacSmlv f WHERE f.valorSalario = :valorSalario")})
public class FacSmlv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "annio")
    private Integer annio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_salario")
    private Double valorSalario;

    public FacSmlv() {
    }

    public FacSmlv(Integer annio) {
        this.annio = annio;
    }

    public Integer getAnnio() {
        return annio;
    }

    public void setAnnio(Integer annio) {
        this.annio = annio;
    }

    public Double getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(Double valorSalario) {
        this.valorSalario = valorSalario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (annio != null ? annio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacSmlv)) {
            return false;
        }
        FacSmlv other = (FacSmlv) object;
        if ((this.annio == null && other.annio != null) || (this.annio != null && !this.annio.equals(other.annio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.FacSmlv[ annio=" + annio + " ]";
    }
    
}
