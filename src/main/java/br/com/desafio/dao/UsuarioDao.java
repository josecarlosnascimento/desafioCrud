package br.com.desafio.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.desafio.to.UsuarioTo;

public class UsuarioDao {
	
	private EntityManager em;
	
	
	public void inserirUsuario(UsuarioTo usuario){
		em = ConnectionManager.open().createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
	}
	
	
	public UsuarioTo loginUsuario(UsuarioTo usuario) throws NoResultException{
		em = ConnectionManager.open().createEntityManager();
		Query query = em.createQuery("SELECT usu FROM UsuarioTo usu WHERE usu.usuarioLogin = :login AND usu.usuarioSenha = :senha");
		query.setParameter("login", usuario.getUsuarioLogin());
		query.setParameter("senha", usuario.getUsuarioSenha());
		return (UsuarioTo) query.getSingleResult();
	}
	

}
