package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless(name = "facadeProdotto")
@NamedQuery(name = "trovaProdotti", query = "SELECT p FROM Prodotto p")
public class FacadeProdotto {
	
	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	//UC4
	public Prodotto creaProdotto(String nome, String codice, String descrizione, Float prezzo) {
		Prodotto prodotto = new Prodotto(nome,codice,descrizione,prezzo);	
//		Prodotto temp = this.em.find(Prodotto.class, prodotto.getCodice());
//		if(temp != null) {
		this.em.persist(prodotto);
		return prodotto;
//		}
//		return null;
	}
	
	//UC1,UC2
	public List<Prodotto> cercaCatalogoProdotti() {
		List<Prodotto> catalogo = new ArrayList<>();
		TypedQuery<Prodotto> query = this.em.createNamedQuery("trovaProdotti", Prodotto.class);
		catalogo = query.getResultList();
		return catalogo;
	}
	
	public Prodotto cercaProdotto(Long idProdotto) {
		return this.em.find(Prodotto.class, idProdotto);
	}
	
}