package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		RigaOrdine rigaOrdine = new RigaOrdine(prodotto,ord,qtaProdotto);
		ord.aggiungiRigaOrdine(rigaOrdine);
	}
	
	public List<Ordine> listinoOrdini() {
		TypedQuery<Ordine> query = this.em.createNamedQuery("listinoOrdini", Ordine.class);
		return query.getResultList();
	}
	
	public List<Ordine> listinoOrdiniCliente(String email){
		this.pulisciOrdini();
		return this.em.find(Cliente.class, email).getOrdini();
	}
	
	private void pulisciOrdini() {
		TypedQuery<Ordine> query = this.em.createNamedQuery("listinoOrdini", Ordine.class);
		for(Ordine ord : query.getResultList()) {
			if(ord.getDataChiusura() == null) {
				Cliente c = ord.getCliente();
				c.rimuoviOrdine(ord);
				this.em.remove(ord);
			}
		}
	}

	public List<RigaOrdine> getRigheOrdine(Long idOrdine){
		Ordine ord = this.em.find(Ordine.class, idOrdine);
		return ord.getRigheOrdine();
	}
	
	public Ordine cercaOrdine(Long id) {
		return this.em.find(Ordine.class, id);
	}

	public void annullati(Long idOrdine){
		Ordine ord = this.em.find(Ordine.class, idOrdine);
		this.em.remove(ord);
	}

	public void tiConcludo(Long idOrdine) {
		Ordine ord = this.em.find(Ordine.class, idOrdine);
		ord.setDataChiusura();
	}
	
	public void tiEvado(Long idOrdine) {
		Ordine ord = this.em.find(Ordine.class, idOrdine);
		this.decrementaQtaMagazzino(ord);
		ord.setDataEvasione();
	}
	
	private boolean decrementaQtaMagazzino(Ordine ordine){
		List<RigaOrdine> righeOrdine = ordine.getRigheOrdine();
		for(RigaOrdine rigaOrdine : righeOrdine){
			if(rigaOrdine.getQtaOrdinata()>rigaOrdine.getProdotto().getQtaMagazzino()){
				return false;
			}
			Integer qtaTemp = rigaOrdine.getQtaOrdinata();
			rigaOrdine.getProdotto().riduciQtaMagazzino(qtaTemp);
		}
		return true;
	}
}	