package configuracao;

public class Jogo {
	private Configuracao config;
	private String senha;
	private int qtdTentativa;
	
	
	public Jogo( Configuracao config) {
		super();
		this.config = config;
		this.qtdTentativa = 0;
	}
	
	
	public Configuracao getConfig() {
		return config;
	}
	public void setConfig(Configuracao config) {
		this.config = config;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
		
	}
	public int getQtdTentativa() {
		return qtdTentativa;
	}
	public void setQtdTentativa(int qtdTentativa) {
		this.qtdTentativa = qtdTentativa;
	}
	
	
	
}
