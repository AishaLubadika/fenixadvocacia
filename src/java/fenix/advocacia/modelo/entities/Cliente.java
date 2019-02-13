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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByConstituente", query = "SELECT c FROM Cliente c WHERE c.constituente = :constituente")
    , @NamedQuery(name = "Cliente.findByBiCliente", query = "SELECT c FROM Cliente c WHERE c.biCliente = :biCliente")
    , @NamedQuery(name = "Cliente.findByBairroCliente", query = "SELECT c FROM Cliente c WHERE c.bairroCliente = :bairroCliente")
    , @NamedQuery(name = "Cliente.findByNacionalidade", query = "SELECT c FROM Cliente c WHERE c.nacionalidade = :nacionalidade")
    , @NamedQuery(name = "Cliente.findByLocalDeTrabalho", query = "SELECT c FROM Cliente c WHERE c.localDeTrabalho = :localDeTrabalho")
    , @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Cliente.findByTelefoneAlternativo", query = "SELECT c FROM Cliente c WHERE c.telefoneAlternativo = :telefoneAlternativo")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Size(max = 45)
    @Column(name = "constituente")
    private String constituente;
    @Size(max = 45)
    @Column(name = "bi_cliente")
    private String biCliente;
    @Size(max = 45)
    @Column(name = "bairro_cliente")
    private String bairroCliente;
    @Size(max = 45)
    @Column(name = "nacionalidade")
    private String nacionalidade;
    @Size(max = 45)
    @Column(name = "local_de_trabalho")
    private String localDeTrabalho;
    @Size(max = 45)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 45)
    @Column(name = "telefone_alternativo")
    private String telefoneAlternativo;
    @JoinColumn(name = "id_municicpio", referencedColumnName = "id_municicpio")
    @ManyToOne(optional = false)
    private Municicpio idMunicicpio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Processo> processoCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getConstituente() {
        return constituente;
    }

    public void setConstituente(String constituente) {
        this.constituente = constituente;
    }

    public String getBiCliente() {
        return biCliente;
    }

    public void setBiCliente(String biCliente) {
        this.biCliente = biCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getLocalDeTrabalho() {
        return localDeTrabalho;
    }

    public void setLocalDeTrabalho(String localDeTrabalho) {
        this.localDeTrabalho = localDeTrabalho;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneAlternativo() {
        return telefoneAlternativo;
    }

    public void setTelefoneAlternativo(String telefoneAlternativo) {
        this.telefoneAlternativo = telefoneAlternativo;
    }

    public Municicpio getIdMunicicpio() {
        return idMunicicpio;
    }

    public void setIdMunicicpio(Municicpio idMunicicpio) {
        this.idMunicicpio = idMunicicpio;
    }

    @XmlTransient
    public Collection<Processo> getProcessoCollection() {
        return processoCollection;
    }

    public void setProcessoCollection(Collection<Processo> processoCollection) {
        this.processoCollection = processoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fenixadvocacia.modelo.entities.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
