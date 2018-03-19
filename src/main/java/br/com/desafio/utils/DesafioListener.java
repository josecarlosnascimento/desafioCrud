package br.com.desafio.utils;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class DesafioListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		FacesContext faces = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) faces.getExternalContext().getSession(true);
		
		if(faces.getViewRoot().getViewId().contains("login") 
		|| faces.getViewRoot().getViewId().contains("usuario")){
			return;
		}
		
		if(session.getAttribute("usuarioIdParam") == null){
			redirectToLogin();
		}
	
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
	public void redirectToLogin(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
