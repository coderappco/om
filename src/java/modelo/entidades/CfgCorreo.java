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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "cfg_correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgCorreo.findAll", query = "SELECT c FROM CfgCorreo c")
    , @NamedQuery(name = "CfgCorreo.findById", query = "SELECT c FROM CfgCorreo c WHERE c.id = :id")
    , @NamedQuery(name = "CfgCorreo.findByHost", query = "SELECT c FROM CfgCorreo c WHERE c.host = :host")
    , @NamedQuery(name = "CfgCorreo.findByPort", query = "SELECT c FROM CfgCorreo c WHERE c.port = :port")
    , @NamedQuery(name = "CfgCorreo.findByEmail", query = "SELECT c FROM CfgCorreo c WHERE c.email = :email")
    , @NamedQuery(name = "CfgCorreo.findByPassword", query = "SELECT c FROM CfgCorreo c WHERE c.password = :password")})
public class CfgCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "host")
    private String host;
    @Size(max = 50)
    @Column(name = "port")
    private String port;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "password")
    private String password;

    public CfgCorreo() {
    }

    public CfgCorreo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgCorreo)) {
            return false;
        }
        CfgCorreo other = (CfgCorreo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.CfgCorreo[ id=" + id + " ]";
    }
    
}
