package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless(name="facadeFornitore")
public class FacadeFornitore {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	public Fornitore creaFornitore(String partitaIva, String email, String telefono, Indirizzo indirizzo) {
		Fornitore fornitore = new Fornitore(partitaIva, email, telefono, indirizzo);
		this.em.persist(fornitore);
		return fornitore;
	}
	
	public Fornitore cercaFornitore(String id) {
		return this.em.find(Fornitore.class, id);
	}
	
	public List<Fornitore> listinoFornitori() {
		TypedQuery<Fornitore> query = this.em.createNamedQuery("listinoFornitori", Fornitore.class);
		return query.getResultList();
	}

	public void aggiungiFornitoreProdotto(Long idFornitore, Long idProdotto) {
		Fornitore fornitore = this.em.find(Fornitore.class, idFornitore);
		Prodotto prodotto = this.em.find(Prodotto.class, idProdotto);
		fornitore.aggiungiProdotto(prodotto);
		prodotto.aggiungiFornitore(fornitore);
	}

	public List<Fornitore> listinoFornitoriProdotto(Long id) {
		return this.em.find(Prodotto.class, id).getFornitori();
	}
	
}
