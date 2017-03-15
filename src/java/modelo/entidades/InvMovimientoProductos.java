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
@Table(name = "inv_movimiento_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvMovimientoProductos.findAll", query = "SELECT i FROM InvMovimientoProductos i")
    , @NamedQuery(name = "InvMovimientoProductos.findByIdMovimientoProducto", query = "SELECT i FROM InvMovimientoProductos i WHERE i.idMovimientoProducto = :idMovimientoProducto")
    , @NamedQuery(name = "InvMovimientoProductos.findByCantidadSolicitada", query = "SELECT i FROM InvMovimientoProductos i WHERE i.cantidadSolicitada = :cantidadSolicitada")
    , @NamedQuery(name = "InvMovimientoProductos.findByCantidadRecibida", query = "SELECT i FROM InvMovimientoProductos i WHERE i.cantidadRecibida = :cantidadRecibida")})
public class InvMovimientoProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimiento_producto")
    private Integer idMovimientoProducto;
    @Column(name = "cantidad_solicitada")
    private Double cantidadSolicitada;
    @Column(name = "cantidad_recibida")
    private Double cantidadRecibida;
    @Column(name = "existencia")
    private Double existencia;
    @JoinColumn(name = "id_movimiento", referencedColumnName = "id_movimiento")
    @ManyToOne
    private InvMovimientos idMovimiento;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private InvProductos idProducto;

    @Transient
    private Double total;
    @Transient
    private Double cantidadDevolver = 0d;
    public InvMovimientoProductos() {
    }

    public InvMovimientoProductos(Integer idMovimientoProducto) {
        this.idMovimientoProducto = idMovimientoProducto;
    }

    public Integer getIdMovimientoProducto() {
        return idMovimientoProducto;
    }

    public void setIdMovimientoProducto(Integer idMovimientoProducto) {
        this.idMovimientoProducto = idMovimientoProducto;
    }

    public Double getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(Double cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public Double getCantidadRecibida() {
        return cantidadRecibida;
    }

    public void setCantidadRecibida(Double cantidadRecibida) {
        this.cantidadRecibida = cantidadRecibida;
    }

    public InvMovimientos getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(InvMovimientos idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public InvProductos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(InvProductos idProducto) {
        this.idProducto = idProducto;
    }

    public Double getExistencia() {
        return existencia;
    }

    public void setExistencia(Double existencia) {
        this.existencia = existencia;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getCantidadDevolver() {
        return cantidadDevolver;
    }

    public void setCantidadDevolver(Double cantidadDevolver) {
        this.cantidadDevolver = cantidadDevolver;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimientoProducto != null ? idMovimientoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvMovimientoProductos)) {
            return false;
        }
        InvMovimientoProductos other = (InvMovimientoProductos) object;
        if ((this.idMovimientoProducto == null && other.idMovimientoProducto != null) || (this.idMovimientoProducto != null && !this.idMovimientoProducto.equals(other.idMovimientoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvMovimientoProductos[ idMovimientoProducto=" + idMovimientoProducto + " ]";
    }
    
}
