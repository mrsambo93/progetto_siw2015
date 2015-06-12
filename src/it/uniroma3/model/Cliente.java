package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="Tabella_Cliente")
@NamedQuery(name = "findAllClienti", query = "SELECT c FROM Cliente c")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private String cognome;

	@Column(nullable=false)
	private String email;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDiRegistrazione;
	
	@Column(nullable=false)
	private Indirizzo indirizzo;
	
	@Column(nullable=false)
	private String password;

	public Cliente(String nome, String cognome,Indirizzo indirizzo, String email, String password){
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public Indirizzo getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Date getDataDiRegistrazione() {
		return dataDiRegistrazione;
	}

	public void setDataDiRegistrazione(Date dataDiRegistrazione) {
		this.dataDiRegistrazione = dataDiRegistrazione;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public boolean verificaCredenziali(String password){
		return this.password.equals(password);
	}
}

