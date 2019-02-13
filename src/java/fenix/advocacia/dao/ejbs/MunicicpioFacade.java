/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenix.advocacia.dao.ejbs;

import fenix.advocacia.modelo.entities.Municicpio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LUBADIKA
 */
@Stateless
public class MunicicpioFacade extends AbstractFacade<Municicpio> {

    @PersistenceContext(unitName = "fenixadvocaciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicicpioFacade() {
        super(Municicpio.class);
    }
    
}
