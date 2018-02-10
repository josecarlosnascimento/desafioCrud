package br.com.desafio.to;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USUARIO")
public class UsuarioTo implements Serializable {

	private static final long serialVersionUID = 6016009164191823114L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="usuario_id")
	private Integer usuarioId;
	
	@Column(name="usuario_nome")
	private String usuarioNome;
	
	@Column(name="usuario_data_nascimento")
	private Date usuarioDataNascimento;
	
	@Column(name="usuario_email")
	private String usuarioEmail;
	
	@Column(name="usuario_login")
	private String usuarioLogin;
	
	@Column(name="usuario_senha")
	private String usuarioSenha;
	
	@Transient
	private String usuarioConfirmacaoSenha;
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getUsuarioNome() {
		return usuarioNome;
	}
	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}
	public Date getUsuarioDataNascimento() {
		return usuarioDataNascimento;
	}
	public void setUsuarioDataNascimento(Date usuarioDataNascimento) {
		this.usuarioDataNascimento = usuarioDataNascimento;
	}
	public String getUsuarioEmail() {
		return usuarioEmail;
	}
	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}
	public String getUsuarioLogin() {
		return usuarioLogin;
	}
	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
	public String getUsuarioSenha() {
		return usuarioSenha;
	}
	public void setUsuarioSenha(String usuarioSenha) {
		this.usuarioSenha = usuarioSenha;
	}
	public String getUsuarioConfirmacaoSenha() {
		return usuarioConfirmacaoSenha;
	}
	public void setUsuarioConfirmacaoSenha(String usuarioConfirmacaoSenha) {
		this.usuarioConfirmacaoSenha = usuarioConfirmacaoSenha;
	}
	
	
}
