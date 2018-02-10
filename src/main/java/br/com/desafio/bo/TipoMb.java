package br.com.desafio.bo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.desafio.ENUM.Tipo;

@ManagedBean
@RequestScoped
public class TipoMb {
	
	
	public List<SelectItem> getListaTipo(){
		
		List<SelectItem> listaMenu = new ArrayList<SelectItem>();
		Tipo[] a = Tipo.values();

		for (int i = 0; i < a.length; i++) {
			listaMenu.add(new SelectItem(a[i].getTipoId(), a[i].getTipoNome()));
		}
		return listaMenu;
	}

}
