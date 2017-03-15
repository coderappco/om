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
@Table(name = "inv_movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvMovimientos.findAll", query = "SELECT i FROM InvMovimientos i")
    , @NamedQuery(name = "InvMovimientos.findByIdMovimiento", query = "SELECT i FROM InvMovimientos i WHERE i.idMovimiento = :idMovimiento")
    , @NamedQuery(name = "InvMovimientos.findByTipoMovimiento", query = "SELECT i FROM InvMovimientos i WHERE i.tipoMovimiento = :tipoMovimiento")
    , @NamedQuery(name = "InvMovimientos.findByNumeroDocumento", query = "SELECT i FROM InvMovimientos i WHERE i.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "InvMovimientos.findByFechaMovimiento", query = "SELECT i FROM InvMovimientos i WHERE i.fechaMovimiento = :fechaMovimiento")
    , @NamedQuery(name = "InvMovimientos.findByNumeroDocumentoProveedor", query = "SELECT i FROM InvMovimientos i WHERE i.numeroDocumentoProveedor = :numeroDocumentoProveedor")
    , @NamedQuery(name = "InvMovimientos.findByObservaciones", query = "SELECT i FROM InvMovimientos i WHERE i.observaciones = :observaciones")
    , @NamedQuery(name = "InvMovimientos.findByFechaAprobacion", query = "SELECT i FROM InvMovimientos i WHERE i.fechaAprobacion = :fechaAprobacion")})
public class InvMovimientos implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;
    @Size(max = 1)
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Column(name = "fecha_movimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    @Size(max = 20)
    @Column(name = "numero_documento_proveedor")
    private String numeroDocumentoProveedor;
    @Size(max = 2000)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 1)
    @Column(name = "estado")
    private String Estado;
    @Column(name = "fecha_aprobacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacion;
    @JoinColumn(name = "usuario_aprueba", referencedColumnName = "id_usuario")
    @ManyToOne
    private CfgUsuarios usuarioAprueba;
    @JoinColumn(name = "id_usuario_crea", referencedColumnName = "id_usuario")
    @ManyToOne
    private CfgUsuarios idUsuarioCrea;
    @JoinColumn(name = "id_bodega_origen", referencedColumnName = "id_bodega")
    @ManyToOne
    private InvBodegas idBodegaOrigen;
    @Column(name = "tipo_proceso")
    private Integer tipoProceso;
    @JoinColumn(name = "id_bodega_destino", referencedColumnName = "id_bodega")
    @ManyToOne
    private InvBodegas idBodegaDestino;
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id_orden_compra")
    @ManyToOne
    private InvOrdenCompra idOrdenCompra;
    @Column(name = "id_movimiento_origen")
    private Integer idMovimientoOrigen;
    @JoinColumn(name = "id_empresa", referencedColumnName = "cod_empresa")
    @ManyToOne
    private CfgEmpresa idEmpresa;
    @OneToMany(mappedBy = "idMovimiento",cascade = CascadeType.PERSIST)
    private List<InvMovimientoProductos> invMovimientoProductosList;

    public InvMovimientos() {
    }

    public InvMovimientos(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getNumeroDocumentoProveedor() {
        return numeroDocumentoProveedor;
    }

    public void setNumeroDocumentoProveedor(String numeroDocumentoProveedor) {
        this.numeroDocumentoProveedor = numeroDocumentoProveedor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public CfgUsuarios getUsuarioAprueba() {
        return usuarioAprueba;
    }

    public void setUsuarioAprueba(CfgUsuarios usuarioAprueba) {
        this.usuarioAprueba = usuarioAprueba;
    }

    public InvBodegas getIdBodegaOrigen() {
        return idBodegaOrigen;
    }

    public void setIdBodegaOrigen(InvBodegas idBodegaOrigen) {
        this.idBodegaOrigen = idBodegaOrigen;
    }

    public InvBodegas getIdBodegaDestino() {
        return idBodegaDestino;
    }

    public void setIdBodegaDestino(InvBodegas idBodegaDestino) {
        this.idBodegaDestino = idBodegaDestino;
    }

    public InvOrdenCompra getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(InvOrdenCompra idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Integer getIdMovimientoOrigen() {
        return idMovimientoOrigen;
    }

    public void setIdMovimientoOrigen(Integer idMovimientoOrigen) {
        this.idMovimientoOrigen = idMovimientoOrigen;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public CfgUsuarios getIdUsuarioCrea() {
        return idUsuarioCrea;
    }

    public void setIdUsuarioCrea(CfgUsuarios idUsuarioCrea) {
        this.idUsuarioCrea = idUsuarioCrea;
    }

    public CfgEmpresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(CfgEmpresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(Integer tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvMovimientos)) {
            return false;
        }
        InvMovimientos other = (InvMovimientos) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvMovimientos[ idMovimiento=" + idMovimiento + " ]";
    }

    @XmlTransient
    public List<InvMovimientoProductos> getInvMovimientoProductosList() {
        return invMovimientoProductosList;
    }

    public void setInvMovimientoProductosList(List<InvMovimientoProductos> invMovimientoProductosList) {
        this.invMovimientoProductosList = invMovimientoProductosList;
    }
    
}
