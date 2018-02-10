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
public class UsuarioMb {
	
	
	private UsuarioTo usuario;
	private UsuarioDao usuarioDao;
	
	@PostConstruct
	public void init(){
		usuario = new UsuarioTo();
		usuarioDao = new UsuarioDao();
	}
	
	public String inserirUsuario(){
		String loginRetorno = null;
		
		usuarioDao.inserirUsuario(usuario);
		DialogUtil.showMessageInfo("Cadastro efetuado com sucesso");
		
		loginRetorno = obterUsuario();
		
		if(loginRetorno != null){
			DialogUtil.showMessageInfo("Cadastro efetuado com sucesso.");
			return loginRetorno;
		}else {
			DialogUtil.showMessageErrorFatal();
			return "login.xhtml";
		}
	}
	
	public String obterUsuario(){
	try {
			
			usuario	= usuarioDao.loginUsuario(usuario);
			
			
			if(usuario != null){
				FacesContext faces = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) faces.getExternalContext().getSession(true);
				
				session.setAttribute("usuarioIdParam", usuario.getUsuarioId());
				session.setAttribute("usuarioNomeParam", usuario.getUsuarioNome());
				session.setAttribute("usuarioEmailParam", usuario.getUsuarioEmail());
				session.setAttribute("usuarioLoginParam", usuario.getUsuarioLogin());
				return "listaClientes.xhtml";
			}else {
				DialogUtil.showMessageError("Login errado");
			}
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	usuario = new UsuarioTo();
	return null;
	}
	

	public UsuarioTo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioTo usuario) {
		this.usuario = usuario;
	}

}
