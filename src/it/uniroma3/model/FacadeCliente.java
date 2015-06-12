package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless(name = "facadeCliente")
public class FacadeCliente {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	public FacadeCliente(){}
	
	public Cliente creaCliente(String nome, String cognome,Indirizzo indirizzo, String email, String password){
		Cliente cliente = new Cliente(nome, cognome, indirizzo, email, password);
		this.em.persist(cliente);
		return cliente;
	}
	
	public boolean autenticaAutente(String email, String password){
		TypedQuery<Cliente> query = this.em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", Cliente.class)
		.setParameter("email", email);
		Cliente cliente = query.getSingleResult();
		return cliente.verificaCredenziali(password);
	}
}
