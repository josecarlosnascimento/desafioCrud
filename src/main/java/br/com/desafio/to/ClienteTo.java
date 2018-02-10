package br.com.desafio.to;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class ClienteTo implements Serializable {

	private static final long serialVersionUID = -7466013740116658995L;

	@Id
	@Column(name="cliente_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer clienteId;
	
	@Column(name="cliente_nome")
	private String clienteNome;
	
	@Column(name="cliente_data_nascimento")
	private Date clienteDataNascimento;
	
	@Column(name="cliente_cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name="cliente_tipo")
	private int clienteTipo;
	
	@Column(name="cliente_status")
	private boolean clienteStatus;
	
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}
	public Date getClienteDataNascimento() {
		return clienteDataNascimento;
	}
	public void setClienteDataNascimento(Date clienteDataNascimento) {
		this.clienteDataNascimento = clienteDataNascimento;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public int getClienteTipo() {
		return clienteTipo;
	}
	public void setClienteTipo(int clienteTipo) {
		this.clienteTipo = clienteTipo;
	}
	public boolean isClienteStatus() {
		return clienteStatus;
	}
	public void setClienteStatus(boolean clienteStatus) {
		this.clienteStatus = clienteStatus;
	}
	
	
}
