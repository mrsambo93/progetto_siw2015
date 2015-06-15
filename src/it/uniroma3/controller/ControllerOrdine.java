package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.FacadeOrdine;
import it.uniroma3.model.Ordine;

import it.uniroma3.model.Prodotto;
import it.uniroma3.model.RigaOrdine;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "controllerOrdine")
public class ControllerOrdine {

	@EJB
	private FacadeOrdine facadeOrdine;
	
	@ManagedProperty(value="#{controllerCliente}")
	private ControllerCliente controllerCliente;
	@ManagedProperty(value="#{controllerProdotto}")
	private ControllerProdotto controllerProdotto;
	private Ordine ordine;
	private Integer qta;
	private List<RigaOrdine> righeOrdine;
	
	public String creaOrdine() {
		this.ordine=this.facadeOrdine.creaOrdine(controllerCliente.getCliente());
		return controllerProdotto.listinoProdotti();
	}

	public String aggiungiProdotto(){
		Prodotto p = this.controllerProdotto.getProdotto();
		this.facadeOrdine.aggiungiProdottoAOrdine(p, ordine, qta);
		return this.getCarrello();
	}

	public String getCarrello(){
		this.setRigheOrdine(this.facadeOrdine.getRigheOrdine(ordine.getId()));
		return "success";
	}
	
	public String annullaOrdine(){
		this.facadeOrdine.annullati(ordine.getId());
		return "success";
	}
	
	public String terminaOrdine(){
		this.facadeOrdine.tiConcludo(ordine.getId());
		return "success";
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Integer getQta() {
		return qta;
	}

	public void setQta(Integer qta) {
		this.qta = qta;
	}

	public ControllerCliente getControllerCliente() {
		return controllerCliente;
	}

	public void setControllerCliente(ControllerCliente controllerCliente) {
		this.controllerCliente = controllerCliente;
	}

	public ControllerProdotto getControllerProdotto() {
		return controllerProdotto;
	}

	public void setControllerProdotto(ControllerProdotto controllerProdotto) {
		this.controllerProdotto = controllerProdotto;
	}

	public List<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdine(List<RigaOrdine> righeOrdine) {
		this.righeOrdine = righeOrdine;
	}
	
}
