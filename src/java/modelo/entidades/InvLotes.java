/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "inv_lotes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvLotes.findAll", query = "SELECT i FROM InvLotes i")
    , @NamedQuery(name = "InvLotes.findByIdLote", query = "SELECT i FROM InvLotes i WHERE i.idLote = :idLote")
    , @NamedQuery(name = "InvLotes.findByCodigo", query = "SELECT i FROM InvLotes i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "InvLotes.findByFechaVencimiento", query = "SELECT i FROM InvLotes i WHERE i.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "InvLotes.findByObservacion", query = "SELECT i FROM InvLotes i WHERE i.observacion = :observacion")
    , @NamedQuery(name = "InvLotes.findByFechaCreacion", query = "SELECT i FROM InvLotes i WHERE i.fechaCreacion = :fechaCreacion")})
public class InvLotes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lote")
    private Integer idLote;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Size(max = 2000)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @OneToMany(mappedBy = "idLote")
    private List<InvLoteProductos> invLoteProductosList;
    @JoinColumn(name = "usuario_crea", referencedColumnName = "id_usuario")
    @ManyToOne
    private CfgUsuarios usuarioCrea;

    public InvLotes() {
    }

    public InvLotes(Integer idLote) {
        this.idLote = idLote;
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<InvLoteProductos> getInvLoteProductosList() {
        return invLoteProductosList;
    }

    public void setInvLoteProductosList(List<InvLoteProductos> invLoteProductosList) {
        this.invLoteProductosList = invLoteProductosList;
    }

    public CfgUsuarios getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(CfgUsuarios usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLote != null ? idLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvLotes)) {
            return false;
        }
        InvLotes other = (InvLotes) object;
        if ((this.idLote == null && other.idLote != null) || (this.idLote != null && !this.idLote.equals(other.idLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvLotes[ idLote=" + idLote + " ]";
    }
    
}
