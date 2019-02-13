/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenix.advocacia.mb;

import fenix.advocacia.dao.ejbs.EstadoProcessoFacade;
import fenix.advocacia.modelo.entities.EstadoProcesso;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author LUBADIKA
 */
@Named(value = "estadoProcessoMBean")
@SessionScoped
public class EstadoProcessoMBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private EstadoProcesso estadoProcesso;
    private List<EstadoProcesso> estadosProcesso;
    
    @Inject
    EstadoProcessoFacade estadoProcessoFacade;
    
    public EstadoProcessoMBean() {
    }
    
     @PostConstruct
    public void inicializar() {
    estadoProcesso= new EstadoProcesso();
    
    }

    public EstadoProcesso getEstadoProcesso() {
        return estadoProcesso;
    }

    public void setEstadoProcesso(EstadoProcesso estadoProcesso) {
        this.estadoProcesso = estadoProcesso;
    }

    public List<EstadoProcesso> getEstadosProcesso() {
        estadoProcessoFacade.findAll();
        return estadosProcesso;
    }

    public void setEstadosProcesso(List<EstadoProcesso> estadosProcesso) {
        this.estadosProcesso = estadosProcesso;
    }
    
     public void save(ActionEvent evt) {
        estadoProcessoFacade.create(estadoProcesso);

        estadoProcesso = new EstadoProcesso();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "estadoProcesso_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        estadoProcessoFacade.edit(estadoProcesso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        estadoProcesso = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("estado_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(EstadoProcessoMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        estadoProcessoFacade.remove(estadoProcesso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        estadoProcesso = null;
        return "estado_listar?faces-redirect=true";
    }
    
    
    
}
