package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.FacadeFornitore;
import it.uniroma3.model.Fornitore;
import it.uniroma3.model.Indirizzo;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "controllerFornitore")
public class ControllerFornitore {

	@EJB
	private FacadeFornitore facadeFornitore;
	@ManagedProperty(value="#{controllerProdotto}")
	private ControllerProdotto controllerProdotto;
	private Long id;
	private String partitaIva;
	private String via;
	private String citta;
	private String regione;
	private String codicePostale;
	private String stato;
	private Indirizzo indirizzo;
	private String telefono;
	private String email;
	private Fornitore fornitore;
	private List<Fornitore> fornitori;
	
	public String creaFornitore() {
		this.indirizzo = new Indirizzo(via,citta,regione,codicePostale,stato);
		this.fornitore = this.facadeFornitore.creaFornitore(partitaIva, email, telefono, indirizzo);
		return this.listinoFornitori();
	}
	
	public String cercaFornitore(String id) {
		this.fornitore = this.facadeFornitore.cercaFornitore(id);
		return "success";
	}
	
	public String listinoFornitori() {
		this.fornitori = this.facadeFornitore.listinoFornitori();
		return "listinoFornitori";
	}
	
	public String listinoFornitoriProdotto() {
		this.fornitori = this.facadeFornitore.listinoFornitoriProdotto(this.controllerProdotto.getProdotto().getId());
		return "listinoFornitoriProdotto";
	}
	
	public String aggiungiFornitoreProdotto(String id) {
		this.facadeFornitore.aggiungiFornitoreProdotto(Long.parseLong(id),this.controllerProdotto.getProdotto().getId());
		return this.listinoFornitoriProdotto();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPartitaIva() {
		return partitaIva;
	}
	
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}

	public List<Fornitore> getFornitori() {
		return fornitori;
	}

	public void setFornitori(List<Fornitore> listinoFornitori) {
		this.fornitori = listinoFornitori;
	}

	public ControllerProdotto getControllerProdotto() {
		return controllerProdotto;
	}

	public void setControllerProdotto(ControllerProdotto controllerProdotto) {
		this.controllerProdotto = controllerProdotto;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getCodicePostale() {
		return codicePostale;
	}

	public void setCodicePostale(String codicePostale) {
		this.codicePostale = codicePostale;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
}
