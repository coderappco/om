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
 * @author miguel
 */
@Entity
@Table(name = "inv_lote_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvLoteProductos.findAll", query = "SELECT i FROM InvLoteProductos i")
    , @NamedQuery(name = "InvLoteProductos.findByIdLoteProducto", query = "SELECT i FROM InvLoteProductos i WHERE i.idLoteProducto = :idLoteProducto")})
public class InvLoteProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lote_producto")
    private Integer idLoteProducto;
    @JoinColumn(name = "id_lote", referencedColumnName = "id_lote")
    @ManyToOne
    private InvLotes idLote;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private InvProductos idProducto;

    public InvLoteProductos() {
    }

    public InvLoteProductos(Integer idLoteProducto) {
        this.idLoteProducto = idLoteProducto;
    }

    public Integer getIdLoteProducto() {
        return idLoteProducto;
    }

    public void setIdLoteProducto(Integer idLoteProducto) {
        this.idLoteProducto = idLoteProducto;
    }

    public InvLotes getIdLote() {
        return idLote;
    }

    public void setIdLote(InvLotes idLote) {
        this.idLote = idLote;
    }

    public InvProductos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(InvProductos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoteProducto != null ? idLoteProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvLoteProductos)) {
            return false;
        }
        InvLoteProductos other = (InvLoteProductos) object;
        if ((this.idLoteProducto == null && other.idLoteProducto != null) || (this.idLoteProducto != null && !this.idLoteProducto.equals(other.idLoteProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvLoteProductos[ idLoteProducto=" + idLoteProducto + " ]";
    }
    
}
