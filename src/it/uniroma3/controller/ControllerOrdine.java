package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.Cliente;
import it.uniroma3.model.FacadeOrdine;
import it.uniroma3.model.Ordine;
import it.uniroma3.model.RigaOrdine;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "controllerOrdine")
public class ControllerOrdine {

	@EJB
	private FacadeOrdine facadeOrdine;
	
	private Long id;
	private Cliente cliente;
	private List<RigaOrdine> righeOrdine;
	private Ordine ordine;
	private ControllerCliente controllerCliente;
	
	public String creaOrdine(){
		this.ordine=this.facadeOrdine.creaOrdine(controllerCliente.getCliente());
		return "success";
	}

	public aggiungiProdotto(String quantita){
		this.facadeOrdine.aggiungiProdottoAOrdine(ordine, Prodotto, qtaProdotto);
	}
}
