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
@Table(name = "inv_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvOrdenCompra.findAll", query = "SELECT i FROM InvOrdenCompra i")
    , @NamedQuery(name = "InvOrdenCompra.findByIdOrdenCompra", query = "SELECT i FROM InvOrdenCompra i WHERE i.idOrdenCompra = :idOrdenCompra")
    , @NamedQuery(name = "InvOrdenCompra.findByFecha", query = "SELECT i FROM InvOrdenCompra i WHERE i.fecha = :fecha")
    , @NamedQuery(name = "InvOrdenCompra.findByNroDocumento", query = "SELECT i FROM InvOrdenCompra i WHERE i.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "InvOrdenCompra.findByObservaciones", query = "SELECT i FROM InvOrdenCompra i WHERE i.observaciones = :observaciones")
    , @NamedQuery(name = "InvOrdenCompra.findBySubtotal", query = "SELECT i FROM InvOrdenCompra i WHERE i.subtotal = :subtotal")
    , @NamedQuery(name = "InvOrdenCompra.findByDescuento", query = "SELECT i FROM InvOrdenCompra i WHERE i.descuento = :descuento")
    , @NamedQuery(name = "InvOrdenCompra.findByIva", query = "SELECT i FROM InvOrdenCompra i WHERE i.iva = :iva")
    , @NamedQuery(name = "InvOrdenCompra.findByTotal", query = "SELECT i FROM InvOrdenCompra i WHERE i.total = :total")
    , @NamedQuery(name = "InvOrdenCompra.findByEstado", query = "SELECT i FROM InvOrdenCompra i WHERE i.estado = :estado")
    , @NamedQuery(name = "InvOrdenCompra.findByFechaCreacion", query = "SELECT i FROM InvOrdenCompra i WHERE i.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "InvOrdenCompra.findByFechaActualizacion", query = "SELECT i FROM InvOrdenCompra i WHERE i.fechaActualizacion = :fechaActualizacion")})
public class InvOrdenCompra implements Serializable {

    @OneToMany(mappedBy = "idOrdenCompra")
    private List<InvMovimientos> invMovimientosList;

    @JoinColumn(name = "id_empresa", referencedColumnName = "cod_empresa")
    @ManyToOne
    private CfgEmpresa idEmpresa;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_compra")
    private Integer idOrdenCompra;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 15)
    @Column(name = "nro_documento")
    private String nroDocumento;
    @Size(max = 2000)
    @Column(name = "observaciones")
    private String observaciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "descuento")
    private Double descuento;
    @Column(name = "iva")
    private Double iva;
    @Column(name = "total")
    private Double total;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @OneToMany(mappedBy = "idOrdenCompra",cascade = CascadeType.PERSIST)
    private List<InvOrdenCompraProductos> invOrdenCompraProductosList;
    @JoinColumn(name = "usuario_actualiza", referencedColumnName = "id_usuario")
    @ManyToOne
    private CfgUsuarios usuarioActualiza;
    @JoinColumn(name = "usuario_crea", referencedColumnName = "id_usuario")
    @ManyToOne
    private CfgUsuarios usuarioCrea;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne
    private InvProveedores idProveedor;

    public InvOrdenCompra() {
    }

    public InvOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @XmlTransient
    public List<InvOrdenCompraProductos> getInvOrdenCompraProductosList() {
        return invOrdenCompraProductosList;
    }

    public void setInvOrdenCompraProductosList(List<InvOrdenCompraProductos> invOrdenCompraProductosList) {
        this.invOrdenCompraProductosList = invOrdenCompraProductosList;
    }

    public CfgUsuarios getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(CfgUsuarios usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public CfgUsuarios getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(CfgUsuarios usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
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
        hash += (idOrdenCompra != null ? idOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvOrdenCompra)) {
            return false;
        }
        InvOrdenCompra other = (InvOrdenCompra) object;
        if ((this.idOrdenCompra == null && other.idOrdenCompra != null) || (this.idOrdenCompra != null && !this.idOrdenCompra.equals(other.idOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvOrdenCompra[ idOrdenCompra=" + idOrdenCompra + " ]";
    }

    public CfgEmpresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(CfgEmpresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @XmlTransient
    public List<InvMovimientos> getInvMovimientosList() {
        return invMovimientosList;
    }

    public void setInvMovimientosList(List<InvMovimientos> invMovimientosList) {
        this.invMovimientosList = invMovimientosList;
    }
    
}
