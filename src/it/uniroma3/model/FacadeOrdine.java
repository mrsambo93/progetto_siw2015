package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "facadeOrdine")
public class FacadeOrdine {
	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;

}	
