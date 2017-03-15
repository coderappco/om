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
@Table(name = "inv_bodega_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvBodegaProductos.findAll", query = "SELECT i FROM InvBodegaProductos i")
    , @NamedQuery(name = "InvBodegaProductos.findByIdBodegaProducto", query = "SELECT i FROM InvBodegaProductos i WHERE i.idBodegaProducto = :idBodegaProducto")
    , @NamedQuery(name = "InvBodegaProductos.findByExistencia", query = "SELECT i FROM InvBodegaProductos i WHERE i.existencia = :existencia")})
public class InvBodegaProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bodega_producto")
    private Integer idBodegaProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "existencia")
    private Double existencia;
    @JoinColumn(name = "id_bodega", referencedColumnName = "id_bodega")
    @ManyToOne
    private InvBodegas idBodega;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private InvProductos idProducto;

    public InvBodegaProductos() {
    }

    public InvBodegaProductos(Integer idBodegaProducto) {
        this.idBodegaProducto = idBodegaProducto;
    }

    public Integer getIdBodegaProducto() {
        return idBodegaProducto;
    }

    public void setIdBodegaProducto(Integer idBodegaProducto) {
        this.idBodegaProducto = idBodegaProducto;
    }

    public Double getExistencia() {
        return existencia;
    }

    public void setExistencia(Double existencia) {
        this.existencia = existencia;
    }

    public InvBodegas getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(InvBodegas idBodega) {
        this.idBodega = idBodega;
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
        hash += (idBodegaProducto != null ? idBodegaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvBodegaProductos)) {
            return false;
        }
        InvBodegaProductos other = (InvBodegaProductos) object;
        if ((this.idBodegaProducto == null && other.idBodegaProducto != null) || (this.idBodegaProducto != null && !this.idBodegaProducto.equals(other.idBodegaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvBodegaProductos[ idBodegaProducto=" + idBodegaProducto + " ]";
    }
    
}
