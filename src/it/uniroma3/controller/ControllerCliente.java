package it.uniroma3.controller;

import it.uniroma3.model.Cliente;
import it.uniroma3.model.FacadeCliente;
import it.uniroma3.model.Indirizzo;

import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "controllerCliente")
public class ControllerCliente {

	@EJB
	private FacadeCliente facadeCliente;

	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String giorno;
	private String mese;
	private String anno;
	private GregorianCalendar dataDiNascita;
	private String via;
	private String citta;
	private String regione;
	private String codicePostale;
	private String stato;
	private Indirizzo indirizzo;
	private String password;
	private Cliente cliente;

	public String creaCliente() {
		this.indirizzo = this.creaIndirizzo(via, citta, regione, codicePostale, stato);
		this.dataDiNascita = new GregorianCalendar(Integer.parseInt(anno),Integer.parseInt(giorno),Integer.parseInt(mese));
		this.cliente = this.facadeCliente.creaCliente(nome, cognome, indirizzo, dataDiNascita, email, password);
		if(this.cliente==null)
			return "failure";
		return "loginCliente";
	}

	public String autenticaCliente() {
		if(this.facadeCliente.autenticaAutente(email, password))
			return "success";
		return "failure";
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public GregorianCalendar getDataDiNascita() {
		return dataDiNascita;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataDiNascita(GregorianCalendar dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public Indirizzo creaIndirizzo(String via, String citta, String regione, String codicePostale, String stato) {
		return new Indirizzo(via, citta, regione, codicePostale, stato);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cliente getCliente(){
		return this.cliente;
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

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}

	public String getMese() {
		return mese;
	}

	public void setMese(String mese) {
		this.mese = mese;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

}
