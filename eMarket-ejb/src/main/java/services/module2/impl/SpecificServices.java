package services.module2.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.module2.interfaces.SpecificServicesLocal;
import services.module2.interfaces.SpecificServicesRemote;

/**
 * Session Bean implementation class SpecificServices
 */
@Stateless
public class SpecificServices implements SpecificServicesRemote, SpecificServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public SpecificServices() {
        // TODO Auto-generated constructor stub
    }

}
