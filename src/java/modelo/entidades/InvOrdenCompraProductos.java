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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "inv_orden_compra_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvOrdenCompraProductos.findAll", query = "SELECT i FROM InvOrdenCompraProductos i")
    , @NamedQuery(name = "InvOrdenCompraProductos.findByIdOrdenCompraProducto", query = "SELECT i FROM InvOrdenCompraProductos i WHERE i.idOrdenCompraProducto = :idOrdenCompraProducto")
    , @NamedQuery(name = "InvOrdenCompraProductos.findByCantidad", query = "SELECT i FROM InvOrdenCompraProductos i WHERE i.cantidad = :cantidad")
    , @NamedQuery(name = "InvOrdenCompraProductos.findByPrecioUnidad", query = "SELECT i FROM InvOrdenCompraProductos i WHERE i.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "InvOrdenCompraProductos.findByDescuento", query = "SELECT i FROM InvOrdenCompraProductos i WHERE i.descuento = :descuento")})
public class InvOrdenCompraProductos implements Serializable,Comparable<InvOrdenCompraProductos>{

    @Column(name = "cantidad_entregada")
    private Double cantidadEntregada;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_compra_producto")
    private Integer idOrdenCompraProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "precio_unidad")
    private Double precioUnidad;
    @Column(name = "descuento")
    private Double descuento;
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id_orden_compra")
    @ManyToOne
    private InvOrdenCompra idOrdenCompra;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private InvProductos idProducto;

    @Transient
    private Double subTotal;
    @Transient
    private Double cantidadDevolver;
    public InvOrdenCompraProductos() {
    }

    public InvOrdenCompraProductos(Integer idOrdenCompraProducto) {
        this.idOrdenCompraProducto = idOrdenCompraProducto;
    }

    public Integer getIdOrdenCompraProducto() {
        return idOrdenCompraProducto;
    }

    public void setIdOrdenCompraProducto(Integer idOrdenCompraProducto) {
        this.idOrdenCompraProducto = idOrdenCompraProducto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public InvOrdenCompra getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(InvOrdenCompra idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public InvProductos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(InvProductos idProducto) {
        this.idProducto = idProducto;
    }

    public Double getSubTotal() {
        cantidad = cantidad==null?0:cantidad;
        Double dscto = descuento==null?0:(descuento/100d);
        subTotal = cantidad*precioUnidad;
        subTotal = subTotal-(subTotal*dscto);
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenCompraProducto != null ? idOrdenCompraProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvOrdenCompraProductos)) {
            return false;
        }
        InvOrdenCompraProductos other = (InvOrdenCompraProductos) object;
        if ((this.idOrdenCompraProducto == null && other.idOrdenCompraProducto != null) || (this.idOrdenCompraProducto != null && !this.idOrdenCompraProducto.equals(other.idOrdenCompraProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvOrdenCompraProductos[ idOrdenCompraProducto=" + idOrdenCompraProducto + " ]";
    }

    @Override
    public int compareTo(InvOrdenCompraProductos o) {
        if(idOrdenCompraProducto==null)return -1;
          if (idOrdenCompraProducto < o.idOrdenCompraProducto) {
              return -1;
          }
          if (idOrdenCompraProducto > o.idOrdenCompraProducto) {
              return 1;
          }
          return 0;
    }

    public Double getCantidadEntregada() {
        return cantidadEntregada;
    }

    public void setCantidadEntregada(Double cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public Double getCantidadDevolver() {
        return cantidadDevolver;
    }

    public void setCantidadDevolver(Double cantidadDevolver) {
        this.cantidadDevolver = cantidadDevolver;
    }
    
}
