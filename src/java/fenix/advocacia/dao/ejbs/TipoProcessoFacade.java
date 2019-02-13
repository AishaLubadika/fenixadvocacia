/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenix.advocacia.dao.ejbs;

import fenix.advocacia.modelo.entities.TipoProcesso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LUBADIKA
 */
@Stateless
public class TipoProcessoFacade extends AbstractFacade<TipoProcesso> {

    @PersistenceContext(unitName = "fenixadvocaciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProcessoFacade() {
        super(TipoProcesso.class);
    }
    
}
