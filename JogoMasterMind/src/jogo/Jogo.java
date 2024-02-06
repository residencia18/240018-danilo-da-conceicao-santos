package jogo;

import java.util.ArrayList;
import java.util.Scanner;

import configuracoes.Configuracao;
import configuracoes.ListaConfiguracoes;
import utils.StringManager;


public class Jogo {
	
	private Configuracao configuracao;
	private String senha;
	private int quantasTentativas;
	
	private ArrayList<String> tentativas, veredictos;

	public Jogo(Configuracao configuracao) {
		super();
		this.configuracao = configuracao;
		tentativas = new ArrayList<String>();
		veredictos = new ArrayList<String>();

	}

	public String getSenha() {
		return senha;
	}
	
	public Configuracao getConfiguracao() {
		return configuracao;
	}
	
	/**
	 * Not tested
	 * @return
	 */
	protected boolean perdeu() {
		return (!venceu()) && (tentativas.size()>=configuracao.getMaxTentativas());
	}
	
	/**
	 * Not tested
	 * @return
	 */
	protected boolean venceu() {
		return tentativas.get(tentativas.size()-1).equals(senha);
	}

	public void setSenha(String senha) throws Exception {
		if (senha.length() != configuracao.getTamanhoSenha()) {
			Exception e = new Exception("A senha deve ter "+ configuracao.getTamanhoSenha() +" caracteres");
			throw e;
		}
		if (StringManager.checaRepetido(senha)) {
			Exception e = new Exception("A senha não pode ter caracteres repetidos");
			throw e;
		}
		if (!StringManager.contem(configuracao.getAlfabeto(), senha)) {
			Exception e = new Exception("A senha precisa ser composta apenas pelos caracteres "+configuracao.getAlfabeto());
			throw e;
		}
		this.senha = senha;
	}
	
	protected String recebeTentativa(String tentativa) throws Exception {
		if (tentativa.length()!=configuracao.getTamanhoSenha()) {
			Exception e = new Exception("Senha deve ter "+configuracao.getTamanhoSenha()+" caracteres");
			throw e;
		}
		if (!StringManager.contem(configuracao.getAlfabeto(), tentativa)) {
			Exception e = new Exception("A senha deve respeitar os caractares válidos da configuração: "+configuracao.getAlfabeto());
			throw e;
		}
		if (StringManager.checaRepetido(tentativa)) {
			Exception e = new Exception("A senha não pode ter caracteres repetidos");
			throw e;
		}
		tentativas.add(tentativa);
		String veredicto = calculaVeredicto(tentativa);
		veredictos.add(veredicto);
		return veredicto;
	}

	
	protected String calculaVeredicto(String tentativa) {
		String veredicto = "";
		for (int i=0;i<tentativa.length(); i++) {
			char c = tentativa.charAt(i);
			if (c==senha.charAt(i)) //caracter na psição certa
				veredicto = veredicto+"X";
			else
				if (senha.indexOf(c)==-1) //não existe o caracter
					veredicto = veredicto+"_";
				else
					veredicto = veredicto+"O";
		}
		return veredicto;
	}

	/**
	 * Não testado!
	 */
	public void jogar() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("-----------------COMEÇAR O JOGO-------------");
		boolean jogando = false;
		do {
			jogando = true;
			System.out.println("\n\n\nTotal de tentativas: "+configuracao.getMaxTentativas());
			System.out.println("Usadas até o momento: "+tentativas.size());
			System.out.println("Tamanho da senha: "+configuracao.getTamanhoSenha());
			System.out.println("Alfabeto: "+configuracao.getAlfabeto());
			String tentando = new String();
			String veredicto = new String();
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite sua tentativa =====> ");
			tentando = sc.next();
			try {
				veredicto = recebeTentativa(tentando);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			for (int i=0;i<tentativas.size();i++) {
				System.out.println("Tentativa: "+tentativas.get(i)+" - resposta: "+veredictos.get(i));
			}
			if (venceu()) {
				System.out.println("Parabéns! Descobriu a senha!!!!");
				System.out.println("Senha Secreta: "+senha);
				System.out.println("Tecle qualquer coisa para voltar ao menu pricipal");
				sc.next();
				jogando = false;
			}
			if (perdeu()) {
				System.out.println("Perdeu! Estourou o limite de tentativas!");
				System.out.println("Tecle qualquer coisa para voltar ao menu pricipal");
				sc.next();
				jogando = false;
			}
		} while (jogando);
	}
	


}
