/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenix.advocacia.modelo.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author LUBADIKA
 */
@Entity
@Table(name = "municicpio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municicpio.findAll", query = "SELECT m FROM Municicpio m")
    , @NamedQuery(name = "Municicpio.findByIdMunicicpio", query = "SELECT m FROM Municicpio m WHERE m.idMunicicpio = :idMunicicpio")
    , @NamedQuery(name = "Municicpio.findByNomeMunicicpio", query = "SELECT m FROM Municicpio m WHERE m.nomeMunicicpio = :nomeMunicicpio")})
public class Municicpio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_municicpio")
    private Integer idMunicicpio;
    @Size(max = 45)
    @Column(name = "nome_municicpio")
    private String nomeMunicicpio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMunicicpio")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "provincia_id_provincia", referencedColumnName = "id_provincia")
    @ManyToOne(optional = false)
    private Provincia provinciaIdProvincia;

    public Municicpio() {
    }

    public Municicpio(Integer idMunicicpio) {
        this.idMunicicpio = idMunicicpio;
    }

    public Integer getIdMunicicpio() {
        return idMunicicpio;
    }

    public void setIdMunicicpio(Integer idMunicicpio) {
        this.idMunicicpio = idMunicicpio;
    }

    public String getNomeMunicicpio() {
        return nomeMunicicpio;
    }

    public void setNomeMunicicpio(String nomeMunicicpio) {
        this.nomeMunicicpio = nomeMunicicpio;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Provincia getProvinciaIdProvincia() {
        return provinciaIdProvincia;
    }

    public void setProvinciaIdProvincia(Provincia provinciaIdProvincia) {
        this.provinciaIdProvincia = provinciaIdProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicicpio != null ? idMunicicpio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municicpio)) {
            return false;
        }
        Municicpio other = (Municicpio) object;
        if ((this.idMunicicpio == null && other.idMunicicpio != null) || (this.idMunicicpio != null && !this.idMunicicpio.equals(other.idMunicicpio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fenixadvocacia.modelo.entities.Municicpio[ idMunicicpio=" + idMunicicpio + " ]";
    }
    
}
