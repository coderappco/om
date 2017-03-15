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
@Table(name = "inv_proveedor_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvProveedorProductos.findAll", query = "SELECT i FROM InvProveedorProductos i")
    , @NamedQuery(name = "InvProveedorProductos.findByIdProveedorProducto", query = "SELECT i FROM InvProveedorProductos i WHERE i.idProveedorProducto = :idProveedorProducto")})
public class InvProveedorProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor_producto")
    private Integer idProveedorProducto;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private InvProductos idProducto;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne
    private InvProveedores idProveedor;

    public InvProveedorProductos() {
    }

    public InvProveedorProductos(Integer idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public Integer getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(Integer idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public InvProductos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(InvProductos idProducto) {
        this.idProducto = idProducto;
    }

    public InvProveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(InvProveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedorProducto != null ? idProveedorProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProveedorProductos)) {
            return false;
        }
        InvProveedorProductos other = (InvProveedorProductos) object;
        if ((this.idProveedorProducto == null && other.idProveedorProducto != null) || (this.idProveedorProducto != null && !this.idProveedorProducto.equals(other.idProveedorProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvProveedorProductos[ idProveedorProducto=" + idProveedorProducto + " ]";
    }
    
}
