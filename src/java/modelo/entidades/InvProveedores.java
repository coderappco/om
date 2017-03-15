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
@Table(name = "inv_proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvProveedores.findAll", query = "SELECT i FROM InvProveedores i")
    , @NamedQuery(name = "InvProveedores.findByIdProveedor", query = "SELECT i FROM InvProveedores i WHERE i.idProveedor = :idProveedor")
    , @NamedQuery(name = "InvProveedores.findByCodigoProveedor", query = "SELECT i FROM InvProveedores i WHERE i.codigoProveedor = :codigoProveedor")
    , @NamedQuery(name = "InvProveedores.findByNumeroDocumento", query = "SELECT i FROM InvProveedores i WHERE i.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "InvProveedores.findByRazonSocial", query = "SELECT i FROM InvProveedores i WHERE i.razonSocial = :razonSocial")
    , @NamedQuery(name = "InvProveedores.findByContacto", query = "SELECT i FROM InvProveedores i WHERE i.contacto = :contacto")
    , @NamedQuery(name = "InvProveedores.findByDireccion", query = "SELECT i FROM InvProveedores i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "InvProveedores.findByTelefono", query = "SELECT i FROM InvProveedores i WHERE i.telefono = :telefono")
    , @NamedQuery(name = "InvProveedores.findByCelular", query = "SELECT i FROM InvProveedores i WHERE i.celular = :celular")
    , @NamedQuery(name = "InvProveedores.findByEmail", query = "SELECT i FROM InvProveedores i WHERE i.email = :email")
    , @NamedQuery(name = "InvProveedores.findByWeb", query = "SELECT i FROM InvProveedores i WHERE i.web = :web")
    , @NamedQuery(name = "InvProveedores.findByCupoCredito", query = "SELECT i FROM InvProveedores i WHERE i.cupoCredito = :cupoCredito")
    , @NamedQuery(name = "InvProveedores.findByFormaPago", query = "SELECT i FROM InvProveedores i WHERE i.formaPago = :formaPago")})
public class InvProveedores implements Serializable {

    @OneToMany(mappedBy = "idProveedor")
    private List<InvOrdenCompra> invOrdenCompraList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    @Basic(optional = false)
    @Column(name = "codigo_proveedor")
    private String codigoProveedor;
    @Basic(optional = false)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "razon_social")
    private String razonSocial;
    @Size(max = 30)
    @Column(name = "contacto")
    private String contacto;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 10)
    @Column(name = "celular")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    @Size(max = 40)
    @Column(name = "web")
    private String web;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cupo_credito")
    private Double cupoCredito;
    @Column(name = "forma_pago")
    private Integer formaPago;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CfgClasificaciones idDepartamento;
    @JoinColumn(name = "id_municipio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CfgClasificaciones idMunicipio;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CfgClasificaciones tipoDocumento;
    @OneToMany(mappedBy = "idProveedor")
    private List<InvProveedorProductos> invProveedorProductosList;

    
    public InvProveedores() {
    }

    public InvProveedores(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public InvProveedores(Integer idProveedor, String codigoProveedor, String numeroDocumento, String razonSocial, String direccion, String telefono) {
        this.idProveedor = idProveedor;
        this.codigoProveedor = codigoProveedor;
        this.numeroDocumento = numeroDocumento;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Double getCupoCredito() {
        return cupoCredito;
    }

    public void setCupoCredito(Double cupoCredito) {
        this.cupoCredito = cupoCredito;
    }

    public Integer getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Integer formaPago) {
        this.formaPago = formaPago;
    }

    public CfgClasificaciones getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(CfgClasificaciones idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public CfgClasificaciones getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(CfgClasificaciones idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public CfgClasificaciones getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(CfgClasificaciones tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProveedores)) {
            return false;
        }
        InvProveedores other = (InvProveedores) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InvProveedores[ idProveedor=" + idProveedor + " ]";
    }

    @XmlTransient
    public List<InvProveedorProductos> getInvProveedorProductosList() {
        return invProveedorProductosList;
    }

    public void setInvProveedorProductosList(List<InvProveedorProductos> invProveedorProductosList) {
        this.invProveedorProductosList = invProveedorProductosList;
    }

    @XmlTransient
    public List<InvOrdenCompra> getInvOrdenCompraList() {
        return invOrdenCompraList;
    }

    public void setInvOrdenCompraList(List<InvOrdenCompra> invOrdenCompraList) {
        this.invOrdenCompraList = invOrdenCompraList;
    }
    
}
