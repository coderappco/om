/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "inv_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvProductos.findAll", query = "SELECT i FROM InvProductos i")
    , @NamedQuery(name = "InvProductos.findByIdProducto", query = "SELECT i FROM InvProductos i WHERE i.idProducto = :idProducto")
    , @NamedQuery(name = "InvProductos.findByCodigo", query = "SELECT i FROM InvProductos i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "InvProductos.findByCodigoCums", query = "SELECT i FROM InvProductos i WHERE i.codigoCums = :codigoCums")
    , @NamedQuery(name = "InvProductos.findByNombre", query = "SELECT i FROM InvProductos i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "InvProductos.findByNombreGenerico", query = "SELECT i FROM InvProductos i WHERE i.nombreGenerico = :nombreGenerico")
    , @NamedQuery(name = "InvProductos.findByRegistroSanitario", query = "SELECT i FROM InvProductos i WHERE i.registroSanitario = :registroSanitario")
    , @NamedQuery(name = "InvProductos.findByCosto", query = "SELECT i FROM InvProductos i WHERE i.costo = :costo")
    , @NamedQuery(name = "InvProductos.findByStockMinimo", query = "SELECT i FROM InvProductos i WHERE i.stockMinimo = :stockMinimo")
    , @NamedQuery(name = "InvProductos.findByLote", query = "SELECT i FROM InvProductos i WHERE i.lote = :lote")
    , @NamedQuery(name = "InvProductos.findByProductoPos", query = "SELECT i FROM InvProductos i WHERE i.productoPos = :productoPos")
    , @NamedQuery(name = "InvProductos.findByActivo", query = "SELECT i FROM InvProductos i WHERE i.activo = :activo")})
public class InvProductos implements Serializable {

    @OneToMany(mappedBy = "idProducto")
    private List<InvMovimientoProductos> invMovimientoProductosList;

    @OneToMany(mappedBy = "idProducto")
    private List<InvBodegaProductos> invBodegaProductosList;

    @OneToMany(mappedBy = "idProducto")
    private List<InvOrdenCompraProductos> invOrdenCompraProductosList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 20)
    @Column(name = "codigo_cums")
    private String codigoCums;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "nombre_generico")
    private String nombreGenerico;
    @Size(max = 30)
    @Column(name = "registro_sanitario")
    private String registroSanitario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private Double costo;
    @Column(name = "stock_minimo")
    private Integer stockMinimo;
    @Column(name = "lote")
    private Boolean lote;
    @Column(name = "producto_pos")
    private Boolean productoPos;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_via_administracion", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones idViaAdministracion;
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id")
    @ManyToOne
    private CfgUnidad idUnidadMedida;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private InvCategorias idCategoria;
    @OneToMany(mappedBy = "idProducto")
    private List<InvLoteProductos> invLoteProductosList;
    @OneToMany(mappedBy = "idProducto")
    private List<InvProveedorProductos> invProveedorProductosList;
    @JoinColumn(name = "id_presentacion", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones idPresentacion;

    public InvProductos() {
    }

    public InvProductos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public InvProductos(Integer idProducto, String codigo, String nombre) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoCums() {
        return codigoCums;
    }

    public void setCodigoCums(String codigoCums) {
        this.codigoCums = codigoCums;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public String getRegistroSanitario() {
        return registroSanitario;
    }

    public void setRegistroSanitario(String registroSanitario) {
        this.registroSanitario = registroSanitario;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Boolean getLote() {
        return lote;
    }

    public void setLote(Boolean lote) {
        this.lote = lote;
    }

    public Boolean getProductoPos() {
        return productoPos;
    }

    public void setProductoPos(Boolean productoPos) {
        this.productoPos = productoPos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public CfgClasificaciones getIdViaAdministracion() {
        return idViaAdministracion;
    }

    public void setIdViaAdministracion(CfgClasificaciones idViaAdministracion) {
        this.idViaAdministracion = idViaAdministracion;
    }

    public CfgUnidad getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(CfgUnidad idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public InvCategorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(InvCategorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductos)) {
            return false;
        }
        InvProductos other = (InvProductos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvProductos[ idProducto=" + idProducto + " ]";
    }

    @XmlTransient
    public List<InvLoteProductos> getInvLoteProductosList() {
        return invLoteProductosList;
    }

    public void setInvLoteProductosList(List<InvLoteProductos> invLoteProductosList) {
        this.invLoteProductosList = invLoteProductosList;
    }

    @XmlTransient
    public List<InvProveedorProductos> getInvProveedorProductosList() {
        return invProveedorProductosList;
    }

    public void setInvProveedorProductosList(List<InvProveedorProductos> invProveedorProductosList) {
        this.invProveedorProductosList = invProveedorProductosList;
    }

    public CfgClasificaciones getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(CfgClasificaciones idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    @XmlTransient
    public List<InvOrdenCompraProductos> getInvOrdenCompraProductosList() {
        return invOrdenCompraProductosList;
    }

    public void setInvOrdenCompraProductosList(List<InvOrdenCompraProductos> invOrdenCompraProductosList) {
        this.invOrdenCompraProductosList = invOrdenCompraProductosList;
    }

    @XmlTransient
    public List<InvBodegaProductos> getInvBodegaProductosList() {
        return invBodegaProductosList;
    }

    public void setInvBodegaProductosList(List<InvBodegaProductos> invBodegaProductosList) {
        this.invBodegaProductosList = invBodegaProductosList;
    }

    @XmlTransient
    public List<InvMovimientoProductos> getInvMovimientoProductosList() {
        return invMovimientoProductosList;
    }

    public void setInvMovimientoProductosList(List<InvMovimientoProductos> invMovimientoProductosList) {
        this.invMovimientoProductosList = invMovimientoProductosList;
    }
    
}
