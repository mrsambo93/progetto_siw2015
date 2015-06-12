package it.uniroma3.model;
	
import javax.persistence.*;
import java.util.*;
import java.util.Date;

@Entity
@NamedQuery(name = "findAllOrdini", query = "SELECT o FROM Ordine o")
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataApertura;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataChiusura;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEvasione;
	
	@ManyToOne
	private Cliente cliente;

	@OneToMany(mappedBy = "ordine", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<RigaOrdine> righeOrdine;

	public Ordine(Cliente cliente) {
		this.dataApertura = new Date();
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date creationTime) {
		this.dataApertura = creationTime;
	}

	public Date getDataChiusura() {
		return dataChiusura;
	}

	public void setDataChiusura(Date dataChiusura) {
		this.dataChiusura = dataChiusura;
	}
	
	public Date getDataEvasione() {
		return dataEvasione;
	}

	public void setDataEvasione(Date dataEvasione) {
		this.dataEvasione = dataEvasione;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<RigaOrdine> getRigaOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdini(List<RigaOrdine> righeOrdine) {
		this.righeOrdine = righeOrdine;
	}



}
