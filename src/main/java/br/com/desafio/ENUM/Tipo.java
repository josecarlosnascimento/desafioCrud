package br.com.desafio.ENUM;

public enum Tipo {
	
	JURIDICO(1,"Juridico"),
	FISICO(2,"Fisico");
	
	
	private Tipo(Integer tipoId, String tipoNome) {
		this.tipoId = tipoId;
		this.tipoNome = tipoNome;
	}
	private Integer tipoId;
	private String tipoNome;
	public Integer getTipoId() {
		return tipoId;
	}
	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}
	public String getTipoNome() {
		return tipoNome;
	}
	public void setTipoNome(String tipoNome) {
		this.tipoNome = tipoNome;
	}

}
