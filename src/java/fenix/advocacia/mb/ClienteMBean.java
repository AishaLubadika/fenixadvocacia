/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenix.advocacia.mb;

import fenix.advocacia.dao.ejbs.ClienteFacade;
import fenix.advocacia.dao.ejbs.MunicicpioFacade;
import fenix.advocacia.modelo.entities.Cliente;
import fenix.advocacia.modelo.entities.Municicpio;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author LUBADIKA
 */
@Named(value = "clienteMBean")
@SessionScoped
public class ClienteMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Cliente cliente;
    private List<Cliente> clientes;
    private List<Municicpio> municipios;

    @Inject
    ClienteFacade clienteFacade;
    MunicicpioFacade municipioFacade;

    public ClienteMBean() {
    }

    @PostConstruct
    public void inicializar() {
        cliente = new Cliente();

    }

    public List<Cliente> getClientes() {
        clienteFacade.findAll();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Municicpio> getMunicipios() {
        municipioFacade.findAll();
        return municipios;
    }

    public void setMunicipios(List<Municicpio> municipios) {
        this.municipios = municipios;
    }

    public void save(ActionEvent evt) {
        clienteFacade.create(cliente);

        cliente = new Cliente();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "cliente_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        clienteFacade.edit(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        cliente = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cliente_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ClienteMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public String delete(ActionEvent evt) {

        clienteFacade.remove(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        cliente = null;
        return "cliente_listar?faces-redirect=true";
    }

}
