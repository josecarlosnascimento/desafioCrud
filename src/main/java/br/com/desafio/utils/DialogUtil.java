package br.com.desafio.utils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

@ManagedBean
public class DialogUtil {
 
    public static void showMessageInfo(String mensagem) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem", mensagem));
    }
    
    public static void showMessageError(String mensagem){
    	RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensagem",mensagem));
    }
    
    public static void showMessageAlerta(String mensagem){
    	RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_WARN,"Mensagem",mensagem));
    }
    
    public static void showMessageErrorFatal(){
    	RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_FATAL,"Mensagem","Erro ao executar esta operação."));
    }
}