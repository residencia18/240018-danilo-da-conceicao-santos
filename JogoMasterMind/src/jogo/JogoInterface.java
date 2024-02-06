package jogo;

import java.util.Scanner;

import org.json.JSONException;

import configuracoes.Configuracao;
import configuracoes.ListaConfiguracoes;

public class JogoInterface {
	
	public Configuracao selecionaConfiguracao() {
		ListaConfiguracoes listaConfiguracoes = new ListaConfiguracoes();
		try {
			listaConfiguracoes.leDados();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (listaConfiguracoes.getLista()!=null) {
			System.out.println("Selecione uma configuracao válida!");
			int i=1;
			for (Configuracao c:listaConfiguracoes.getLista()) {
				System.out.println(i+" - "+ c.toString());
			}
			System.out.println("Escolha uma configuração");
			Scanner sc = new Scanner(System.in);
			int op = sc.nextInt();
			return listaConfiguracoes.getLista().get(i);
		}
		else
			System.out.println("Não há configurações salvas. Crie uma primeiro.");
		return null;
	}
	
	private static void criarConfiguracao() {
		System.out.println("\n\n\n---------Criar uma nova cofiguração");
		ListaConfiguracoes listaConfiguracoes = new ListaConfiguracoes();
		boolean configuracaoValida;
		do {
			configuracaoValida = true;
			Configuracao configuracao = new Configuracao();
			try {
				listaConfiguracoes.leDados();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				configuracaoValida = false;
			}
			System.out.println("--------Dados da nova configuracao");
			System.out.println();
			try {
				leConfiguracao(configuracao, listaConfiguracoes);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Configuracao Invalida!");
				System.out.println(e.getMessage());
				configuracaoValida = false;
			}
System.out.println("Saindo do while"+configuracaoValida);
		} while (!configuracaoValida);
	}
	
	private static void leConfiguracao(Configuracao configuracao, ListaConfiguracoes listaConfiguracoes) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome da Configuracao: ");
		String nome = sc.next();
		configuracao.setNome(nome);
		System.out.println("Digite o Alfabeto da Configuracao: ");
		String alfabeto = sc.next();
		configuracao.setAlfabeto(alfabeto);
		System.out.println("Digite o tamanho da senha: ");
		int tamanhoSenha = sc.nextInt();
		configuracao.setTamanhoSenha(tamanhoSenha);
		System.out.println("Digite o máximo de tentativas: ");
		int maxTentativas = sc.nextInt();
		configuracao.setMaxTentativas(maxTentativas);
		try {
			listaConfiguracoes.novaConfiguracao(configuracao);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	private static Configuracao selecionarConfiguracao() {
		ListaConfiguracoes listaConfiguracoes = new ListaConfiguracoes();
		try {
			listaConfiguracoes.leDados();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao ler arquivo de configuracoes");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Erro: "+e.getMessage());
		}
		return selecaoLista(listaConfiguracoes);
	}


	private static Configuracao selecaoLista(ListaConfiguracoes listaConfiguracoes) {
		int op;
		do {
			System.out.println("---Lista de configuracoes armazenadas----");
			int i=0;
			for (Configuracao c:listaConfiguracoes.getLista()) {
				System.out.println(i+1+" : "+c.toString());
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite número da configuracao desejada");
			System.out.println("Numero entre 1 e "+listaConfiguracoes.getLista().size());
			op = sc.nextInt();
		} while ( (op<1) || (op > listaConfiguracoes.getLista().size()) );
		Configuracao selecionada = listaConfiguracoes.getLista().get(op-1);
		System.out.println("Selecionada: "+selecionada.toString());
		return selecionada;
	}
	
	private static void preparaJogo(Jogo jogo) {
		boolean jogoValido = false;
		do {
			jogoValido = true;
			System.out.println("---Preparando o Jogo!---");
			System.out.println("Atencao à configuração selecionadas");
			System.out.println("Configuracoes: "+jogo.getConfiguracao().toString());
			String senha = new String();
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite a senha secreta (respeite o alfabeto e o tamanho da senha)");
			System.out.println("Senha : ");
			senha = sc.next();
			try {
				jogo.setSenha(senha);
			} catch (Exception e) {
				System.out.println("\n\n\n===>"+e.getMessage());
				System.out.println("Observe a configuração selecionada!");// TODO Auto-generated catch block
				jogoValido = false;
			}
		} while (!jogoValido);
	}
	
	public static void main(String[] args) {
		JogoInterface jogoInt = new JogoInterface();
		Configuracao configuracao=null;;
		int op;
		do {
			System.out.println("\n\n\nMenu Principal");
			System.out.println("1. Configurações");
			System.out.println("2. Jogar");
			System.out.println("0. Sair");
			System.out.print("Selecione opção: ");
			Scanner sc = new Scanner(System.in);
			op = sc.nextInt();
			if (op==1) {
				int op1;
				do {
					System.out.println("\n\n\n---Menu Configurações");
					System.out.println("1. Criar configuracao");
					System.out.println("2. Selecionar configuracao");
					System.out.println("0. Menu Principal");
					System.out.print("Selecione opção: ");
					op1 = sc.nextInt();
					if (op1==1)
						criarConfiguracao();
					if (op1==2)
						configuracao = selecionarConfiguracao();
				} while (op1!=0);
			}
			if (op==2) {
				if (configuracao==null) {
					System.out.println("Não é possível iniciar um jogo sem selecionar a configuração");
				}
				else {
					System.out.println("--------Iniciando um Jogo------");
					Jogo jogo = new Jogo(configuracao);
					preparaJogo(jogo);
					jogo.jogar();
				}
			}
		} while (op!=0);
		System.out.println("\n\n--------OBRIGADO POR JOGAR MASTERMIND!-------");
	}





}
