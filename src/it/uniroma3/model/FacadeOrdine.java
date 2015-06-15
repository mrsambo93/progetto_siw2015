package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "facadeOrdine")
public class FacadeOrdine {
	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	
	public Ordine creaOrdine(Cliente cliente){
		Ordine ordine = new Ordine(cliente);
		Cliente cl = this.em.find(Cliente.class, cliente.getEmail());
		cl.aggiungiOrdine(ordine);
		this.em.persist(ordine);
		return ordine;
	}
	
	public void aggiungiProdottoAOrdine(Prodotto prodotto, Ordine ordine, Integer qtaProdotto){
		Ordine ord = this.em.find(Ordine.class, ordine.getId());
		RigaOrdine rigaOrdine = new RigaOrdine(prodotto, ord, qtaProdotto);
		ord.aggiungiRigaOrdine(rigaOrdine);
	}
	
	public List<RigaOrdine> getRigheOrdine(Long idOrdine){
		Ordine ord = this.em.find(Ordine.class, idOrdine);
		return ord.getRigheOrdine();
	}
}	