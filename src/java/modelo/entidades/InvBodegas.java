/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "inv_bodegas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvBodegas.findAll", query = "SELECT i FROM InvBodegas i")
    , @NamedQuery(name = "InvBodegas.findByIdBodega", query = "SELECT i FROM InvBodegas i WHERE i.idBodega = :idBodega")
    , @NamedQuery(name = "InvBodegas.findByIdSede", query = "SELECT i FROM InvBodegas i WHERE i.idSede = :idSede")
    , @NamedQuery(name = "InvBodegas.findByTipo", query = "SELECT i FROM InvBodegas i WHERE i.tipo = :tipo")
    , @NamedQuery(name = "InvBodegas.findByCodigoBodega", query = "SELECT i FROM InvBodegas i WHERE i.codigoBodega = :codigoBodega")
    , @NamedQuery(name = "InvBodegas.findByNombre", query = "SELECT i FROM InvBodegas i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "InvBodegas.findByPrincipal", query = "SELECT i FROM InvBodegas i WHERE i.principal = :principal")})
public class InvBodegas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bodega")
    private Integer idBodega;
    @JoinColumn(name = "id_sede", referencedColumnName = "id_sede")
    @ManyToOne
    private CfgSede idSede;
    @Column(name = "tipo")
    private Integer tipo;
    @Size(max = 20)
    @Column(name = "codigo_bodega")
    private String codigoBodega;
    @Size(max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "principal")
    private Boolean principal;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "responsable", referencedColumnName = "id_usuario")
    @ManyToOne
    private CfgUsuarios responsable;
    @JoinColumn(name = "id_empresa", referencedColumnName = "cod_empresa")
    @ManyToOne
    private CfgEmpresa idEmpresa;
    @Column(name = "id_bodega_padre")
    private Integer idBodegaPadre;
    @OneToMany(mappedBy = "idBodegaOrigen")
    private List<InvMovimientos> invMovimientosList;
    @OneToMany(mappedBy = "idBodegaDestino")
    private List<InvMovimientos> invMovimientosList1;
    
    public InvBodegas() {
    }

    public InvBodegas(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(String codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public CfgUsuarios getResponsable() {
        return responsable;
    }

    public void setResponsable(CfgUsuarios responsable) {
        this.responsable = responsable;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvBodegas)) {
            return false;
        }
        InvBodegas other = (InvBodegas) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvBodegas[ idBodega=" + idBodega + " ]";
    }

    public CfgEmpresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(CfgEmpresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public CfgSede getIdSede() {
        return idSede;
    }

    public void setIdSede(CfgSede idSede) {
        this.idSede = idSede;
    }

    public Integer getIdBodegaPadre() {
        return idBodegaPadre;
    }

    public void setIdBodegaPadre(Integer idBodegaPadre) {
        this.idBodegaPadre = idBodegaPadre;
    }

    @XmlTransient
    public List<InvMovimientos> getInvMovimientosList() {
        return invMovimientosList;
    }

    public void setInvMovimientosList(List<InvMovimientos> invMovimientosList) {
        this.invMovimientosList = invMovimientosList;
    }

    @XmlTransient
    public List<InvMovimientos> getInvMovimientosList1() {
        return invMovimientosList1;
    }

    public void setInvMovimientosList1(List<InvMovimientos> invMovimientosList1) {
        this.invMovimientosList1 = invMovimientosList1;
    }

    

}
