package br.com.desafio.mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.desafio.dao.ClienteDao;
import br.com.desafio.to.ClienteTo;
import br.com.desafio.utils.DialogUtil;

@ManagedBean
@SessionScoped
public class ClienteMb {
	
	private ClienteTo cliente;
	private List<ClienteTo> listaCliente;
	private ClienteDao clienteDao;
	private String nomeCliente;
	
	public String inserirCliente(){
		Integer count = null;
		listaCliente.clear();

		if(cliente.getClienteId() != null && cliente.getClienteId() >0){
			clienteDao.atualizarCliente(cliente);
			
			DialogUtil.showMessageInfo("Cliente atualizado com sucesso.");
			cliente = new ClienteTo();
		}else {
			count = clienteDao.verificaCPFCNPJ(cliente.getCpfCnpj());
			
			if(count == null || count == 0){
				
				clienteDao.inserirCliente(cliente);
				
				DialogUtil.showMessageInfo("Cliente cadastrado com sucesso.");
				cliente = new ClienteTo();
				listaCliente.addAll(clienteDao.listaClientes());
				return "listaClientes.xhtml";
			}else {
				DialogUtil.showMessageAlerta("Este CPF/CNPJ já foi cadastrado.");
			}
			
			
		}
		return null;
		
		
	}
	
	public void listaClientes(){
		listaCliente.clear();
		
		if(nomeCliente != null){
			listaCliente = clienteDao.listaClientePorNome(nomeCliente);
		}else {
			listaCliente.addAll(clienteDao.listaClientes());
		}
		
		if(listaCliente.size() == 0){
			DialogUtil.showMessageAlerta("Não há registros para esta pesquisa.");
		}
		
	}
	
	public void removerCliente(){
		clienteDao.removerCliente(cliente.getClienteId());
		listaCliente = clienteDao.listaClientePorNome(nomeCliente);
	}
	
	
	public void setPreUpdate(ClienteTo cliente){
		this.cliente = cliente;
	}
	
	public void setPreRemoveCliente(Integer id){
		this.cliente.setClienteId(id);
	}
	
	@PostConstruct
	public void init(){
		clienteDao= new ClienteDao();
		cliente =new ClienteTo();
		listaCliente = new ArrayList<ClienteTo>();
	}

	public ClienteTo getCliente() {
		return cliente;
	}

	public void setCliente(ClienteTo cliente) {
		this.cliente = cliente;
	}


	public List<ClienteTo> getListaCliente() {
		return listaCliente;
	}


	public void setListaCliente(List<ClienteTo> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	

}
