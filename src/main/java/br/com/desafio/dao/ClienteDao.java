package br.com.desafio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.desafio.to.ClienteTo;

public class ClienteDao {
	
	
	private EntityManager em;
	
	public void inserirCliente(ClienteTo cliente){
		em = ConnectionManager.open().createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}
	
	public List<ClienteTo> listaClientes(){
		em = ConnectionManager.open().createEntityManager();
		Query query = em.createQuery("FROM ClienteTo", ClienteTo.class);
		return query.getResultList();
	}
	
	public List<ClienteTo> listaClientePorNome(String nome){
		em = ConnectionManager.open().createEntityManager();
		Query query = em.createQuery("SELECT cliente FROM ClienteTo cliente WHERE cliente.clienteNome LIKE :nome");
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
	
	public Integer removerCliente(Integer clienteId){
		em = ConnectionManager.open().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM ClienteTo cliente WHERE cliente.clienteId = :idCliente");
		int id = query.setParameter("idCliente",clienteId).executeUpdate();
		em.getTransaction().commit();
		return id;
	}
	
	public void atualizarCliente(ClienteTo cliente){
		em = ConnectionManager.open().createEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
	}
	
	public Integer verificaCPFCNPJ(String cpfCnpj){
		em = ConnectionManager.open().createEntityManager();
		Query query = em.createQuery("SELECT cliente FROM ClienteTo cliente WHERE cliente.cpfCnpj = :cpfCnpj");
		query.setParameter("cpfCnpj", cpfCnpj);
		return query.getResultList().size();
	}

}
