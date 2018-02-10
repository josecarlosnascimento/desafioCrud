package br.com.desafio.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import br.com.desafio.dao.UsuarioDao;
import br.com.desafio.to.UsuarioTo;
import br.com.desafio.utils.DialogUtil;

@ManagedBean
@SessionScoped
public class LoginMb {
	
	private UsuarioTo usuario;
	private UsuarioDao usuarioDao;
	
	@PostConstruct
	public void init(){
		usuario = new UsuarioTo();
		usuarioDao = new UsuarioDao();
	}
	
	public String loginUsuario(){
		
		try {
			
			usuario	= usuarioDao.loginUsuario(usuario);
			
			
			if(usuario != null){
				FacesContext faces = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) faces.getExternalContext().getSession(true);
				
				session.setAttribute("usuarioIdParam", usuario.getUsuarioId());
				session.setAttribute("usuarioNomeParam", usuario.getUsuarioNome());
				session.setAttribute("usuarioEmailParam", usuario.getUsuarioEmail());
				session.setAttribute("usuarioLoginParam", usuario.getUsuarioLogin());
				DialogUtil.showMessageInfo("Cadastro efetuado com sucesso");
				return "listaClientes.xhtml";
			}else {
				DialogUtil.showMessageError("Login errado");
			}
		} catch (NoResultException e) {
			DialogUtil.showMessageError("Login errado");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "login.xhtml";
		
	}

	public UsuarioTo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioTo usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public String sair(){
		FacesContext faces = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) faces.getExternalContext().getSession(true);
		
		session.invalidate();
		
		return "login.html";
		
	}
	

}
