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
	private ControllerProdotto controllerProdotto;
	private Integer qta;
	
	public String creaOrdine(){
		this.ordine=this.facadeOrdine.creaOrdine(controllerCliente.getCliente());
		return "success";
	}

	public String aggiungiProdotto(){
		this.facadeOrdine.aggiungiProdottoAOrdine(controllerProdotto.getProdotto(), ordine, qta);
		return "listinoProdottiPerOrdine";
	}
}
