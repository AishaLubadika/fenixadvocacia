/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenix.advocacia.mb;

import fenix.advocacia.dao.ejbs.AdvogadoFacade;
import fenix.advocacia.modelo.entities.Advogado;
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
@Named(value = "advogadoMBean")
@SessionScoped
public class AdvogadoMBean implements Serializable{

  private static final long serialVersionUID = 1L;
  private Advogado advogado;
  private List <Advogado> advogados;
  
  @Inject
  AdvogadoFacade advogadoFacade;
  
    public AdvogadoMBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        advogado = new Advogado();
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public List<Advogado> getAdvogados() {
        advogadoFacade.findAll();
        return advogados;
    }

    public void setAdvogados(List<Advogado> advogados) {
        this.advogados = advogados;
    }
    
    public void save(ActionEvent evt) {
        advogadoFacade.create(advogado);

        advogado = new Advogado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao guardar os dados"));

    }

    public String startEdit() {
        return "advogado_listar?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {
        advogadoFacade.edit(advogado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao editar os dados"));

        advogado = null;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("advogado_listar.jsf");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(AdvogadoMBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String delete(ActionEvent evt) {

        advogadoFacade.remove(advogado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar\t", "\tSucesso ao deletar os dados"));
        advogado = null;
        return "advogado_listar?faces-redirect=true";
    }
}
