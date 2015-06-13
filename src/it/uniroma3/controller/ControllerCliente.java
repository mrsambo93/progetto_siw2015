package it.uniroma3.controller;

import it.uniroma3.model.Cliente;
import it.uniroma3.model.FacadeCliente;
import it.uniroma3.model.Indirizzo;
import java.util.Date;
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
	private Date dataDiNascita;	
	private Indirizzo indirizzo;
	private String password;
	private Cliente cliente;
		
	public String creaCliente() {
		this.cliente = this.facadeCliente.creaCliente(nome, cognome, indirizzo, email, password);
		if(this.cliente==null)
			return "failure";
		return "success";
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
	public Date getDataDiNascita() {
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
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Cliente getCliente(){
		return this.cliente;
	}
	
}
