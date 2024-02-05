package testes;

import java.time.LocalDate;
import java.util.Scanner;

import model.Cliente;
import model.Fatura;
import model.Imovel;
import model.Pagamento;
import model.Reembolso;
import model.Reparo;

public class Empresa {

	
    
    //MENUS
    public void menuEmpresa() {
    	
    	String acao = "";
    	Scanner sc = new Scanner(System.in);
    	 while (!acao.equals("0")) {
    		System.out.println("-----Menu Geral-----");
        	System.out.println("1 - Menu de Clientes");
        	System.out.println("2 - Menu de Imoveis");
        	System.out.println("3 - Menu de Faturas");
        	System.out.println("4 - Menu de Pagamentos");
        	System.out.println("5 - Menu de Falhas");
        	System.out.println("0 - Sair");
        	System.out.println("Digite uma opcao: ");
        	
        	acao = sc.nextLine();
        	System.out.println();

        	switch(acao) {
        	case "0":
        		System.out.println("Finalizando operacao...");
        		System.exit(0);
            	break;
            	
        	case "1":
        		menuCliente();
            	break;
            	
        	case "2":
        		menuImovel();
            	break;
            	
        	case "3":
        		menuFatura();
            	break;
            	
        	case "4":
        		menuPagamento();
            	break;
            	
        	case "5":
        		menuFalha();
            	break;
           case "6":
        	   //preencherListasComValoresIniciais();
				break;
        	default:
            	System.out.println("Opcao invalida, insira novamente");
            	break;
        	}
			
    	}
    }
    
    
    public void menuCliente() {
    	String acao = "";
    	Scanner sc = new Scanner(System.in);
    	 while (!acao.equals("0")) {
    		System.out.println("-----Menu de Clientes-----");
        	System.out.println("1 - Incluir cliente");
        	System.out.println("2 - Consultar cliente");
        	System.out.println("3 - Listar clientes");
        	System.out.println("4 - Excluir cliente");
        	System.out.println("5 - Alterar cliente");
        	System.out.println("0 - Voltar");
        	System.out.println("Digite uma opcao: ");
        	
        	acao = sc.nextLine();
        	System.out.println();
         
        	switch(acao) {
        	case "0":
        		System.out.println("Voltando...");
        		menuEmpresa();
            	break;
            	
        	case "1":
        		incluirCliente();
            	break;
            	
        	case "2":
        		consultarCliente();
            	break;
            	
        	case "3":
        		listarCliente();
            	break;
            	
        	case "4":
        		excluirCliente();
            	break;
            	
        	case "5":
        		alterarCliente();
            	break;

        	default:
            	System.out.println("Opcao invalida, insira novamente");
            	break;
        	}
    	}
    }
    
    
    public void menuImovel() {
    	String acao = "";
    	Scanner sc = new Scanner(System.in);
    	while(acao != "0") {
    		System.out.println("-----Menu de Imoveis-----");
        	System.out.println("1 - Incluir imovel");
        	System.out.println("2 - Consultar imovel");
        	System.out.println("3 - Listar imovel");
        	System.out.println("4 - Excluir imovel");
        	System.out.println("5 - Alterar imovel");
        	System.out.println("0 - Voltar");
        	System.out.println("Digite uma opcao: ");
        	
        	acao = sc.nextLine();
        	System.out.println();
        
        	switch(acao) {
        	case "0":
        		System.out.println("Voltando...");
        		menuEmpresa();
            	break;
            	
        	case "1":
        		incluirImovel();
            	break;
            	
        	case "2":
        		consultarImovel();
            	break;
            	
        	case "3":
        		listarImovel();
            	break;
            	
        	case "4":
        		excluirImovel();
            	break;
            	
        	case "5":
        		alterarImovel();
            	break;
            
        	default:
            	System.out.println("Opcao invalida, insira novamente");
            	break;
        	}
    	}
    }
    
    
    public void menuFatura() {
    	String acao = "";
    	Scanner sc = new Scanner(System.in);
    	while(acao != "0") {
    		System.out.println("-----Menu de Faturas-----");
        	System.out.println("1 - Incluir fatura");
        	System.out.println("2 - Listar todas as faturas");
        	System.out.println("3 - Listar todas as faturas em aberto");
        	System.out.println("0 - Voltar");
        	System.out.println("Digite uma opcao: ");
        	
        	acao = sc.nextLine();
        	System.out.println();
        
        	switch(acao) {
        	case "0":
        		System.out.println("Voltando...");
        		menuEmpresa();
            	break;
            	
        	case "1":
        		incluirFatura();
            	break;
            	
        	case "2":
        		listarTodasFaturas();
            	break;
            	
        	case "3":
        		listarFaturasAbertas();
            	break;
            
        	default:
            	System.out.println("Opcao invalida, insira novamente");
            	break;
        	}
    	}
    }
    
    
    public void menuPagamento() {
    	String acao = "";
    	Scanner sc = new Scanner(System.in);
    	while(acao != "0") {
    		System.out.println("-----Menu de Pagamentos-----");
        	System.out.println("1 - Incluir pagamentos");
        	System.out.println("2 - Listar todos os pagamentos");
        	System.out.println("3 - Listar todos os pagamentos de uma fatura");
        	System.out.println("4 - Listar todos os reembolsos");
        	System.out.println("5 - Consultar reembolso de uma fatura");
        	System.out.println("0 - Voltar");
        	System.out.println("Digite uma opcao: ");
        	
        	acao = sc.nextLine();
        	System.out.println();
        
        	switch(acao) {
        	case "0":
        		System.out.println("Voltando...");
        		menuEmpresa();
            	break;
            	
        	case "1":
        		incluirPagamento();
            	break;
            	
        	case "2":
        		listarTodosPagamentos();
            	break;
            	
        	case "3":
        		listarPagamentosFatura();
            	break;
            	
        	case "4":
        		ListarReembolsos();
            	break;
            	
        	case "5":
        		consultarReembolsoFatura();
            	break;
            
        	default:
            	System.out.println("Opcao invalida, insira novamente");
            	break;
        	}
    	}
    }
    
    
    public void menuFalha() {
    	String acao = "";
    	Scanner sc = new Scanner(System.in);
    	while(acao != "0") {
    		System.out.println("-----Menu de Falhas-----");
        	System.out.println("1 - Incluir falha (com matricula)");
        	System.out.println("2 - Incluir falha (sem matricula)");
        	System.out.println("3 - Sub-menu de Reparos");
        	System.out.println("0 - Voltar");
        	System.out.println("Digite uma opcao: ");
        	
        	acao = sc.nextLine();
        	System.out.println();
        
        	switch(acao) {
        	case "0":
        		System.out.println("Voltando...");
        		menuEmpresa();
            	break;
            	
        	case "1":
        		incluirFalhaComMatricula();
            	break;
            	
        	case "2":
        		incluirFalhaSemMatricula();
            	break;
            	
        	case "3":
        		menuReparo();
            	break;
            	
        	default:
            	System.out.println("Opcao invalida, insira novamente");
            	break;
        	}
    	}
    }
    
    
    public void menuReparo() {
    	String acao = "";
    	Scanner sc = new Scanner(System.in);
    	while(acao != "0") {
    		System.out.println("-----Sub-Menu de Reparos-----");
        	System.out.println("1 - Listar todos os reparos abertos");
        	System.out.println("2 - Encerrar um reparo");
        	System.out.println("0 - Voltar");
        	System.out.println("Digite uma opcao: ");
        	
        	acao = sc.nextLine();
        	System.out.println();
			
        	switch(acao) {
        	case "0":
        		System.out.println("Voltando...");
        		menuEmpresa();
            	break;
            	
        	case "1":
        		listarReparosAbertos();
            	break;
            	
        	case "2":
        		encerrarReparo();
            	break;
            	
        	default:
            	System.out.println("Opcao invalida, insira novamente");
            	break;
        	}
    	}
    }
    
    public void incluirCliente() {
       
    }

    
    public void consultarCliente() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("-----Consultando cliente-----");
    	
    	System.out.println("CPF: ");
    	String cpf= sc.nextLine();
    	
    	
    }
    
    public void listarCliente() {
        
    }
    
    public void excluirCliente() {
    
 
    }
    
    public void alterarCliente() {
      
}
    
    
   	public void incluirImovel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Incluindo novo imóvel-----");

		System.out.println("Matrícula do imóvel: ");
		String matricula = sc.nextLine();

		System.out.println("Endereço do imóvel: ");
		String endereco = sc.nextLine();

		System.out.println("Última leitura: ");
		float ultimaLeitura = Float.parseFloat(sc.nextLine());

		System.out.println("Penúltima leitura: ");
		float penultimaLeitura = Float.parseFloat(sc.nextLine());

		


		System.out.println("Imóvel cadastrado com sucesso");
	}

	public void consultarImovel() {
	
	}

	public void listarImovel() {

	}

	public void excluirImovel() {
		
	}

	public void alterarImovel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Alterando imóvel-----");

		System.out.println("Matrícula do imóvel: ");
		String matricula = sc.nextLine();

		
	}

    public void incluirFatura() {
  
    }

    public void listarTodasFaturas() {
		
    }
    
    public void listarFaturasAbertas() {
    
    }
    
    
    public void incluirPagamento() {
        
       
    }
    
    public void listarTodosPagamentos() {
    	
      
    }
    
    public void listarPagamentosFatura() {
       
    }
    
    
    public void ListarReembolsos() {
 

   }
   
    public void consultarReembolsoFatura() {
       
    }
    
    
    public void incluirFalhaComMatricula() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Incluindo falha com matrícula-----");
	
		System.out.println("Descrição da falha: ");
		String descricao = sc.nextLine();
	
		System.out.println("Previsão de início (AAAA-MM-DD): ");
		LocalDate previsaoInicio = LocalDate.parse(sc.nextLine());
	
		System.out.println("Data de início (AAAA-MM-DD): ");
		LocalDate dataInicio = LocalDate.parse(sc.nextLine());
	
		System.out.println("Data de fim (AAAA-MM-DD): ");
		LocalDate dataFim = LocalDate.parse(sc.nextLine());
	
		System.out.println("Tipo de falha: ");
		String tipoFalha = sc.nextLine();

		
	
		System.out.println("Falha com matrícula incluída com sucesso!");
	}
	
	public void incluirFalhaSemMatricula() {

	}

    public void listarReparosAbertos() {
 
    }

    public void encerrarReparo() {

    }

//    public void preencherListasComValoresIniciais() {
//        // Adicionando clientes à listaClientes
//        Cliente cliente1 = new Cliente("Ana", "12345678901");
//        Cliente cliente2 = new Cliente("João", "98765432109");
//        Cliente cliente3 = new Cliente("Maria", "11122233344");
//        listaClientes.add(cliente1);
//        listaClientes.add(cliente2);
//        listaClientes.add(cliente3);
//
//        // Adicionando imóveis à listaImoveis
//        Imovel imovel1 = new Imovel("01", "rua dos bobos", 100.0f, 80.0f);
//        Imovel imovel2 = new Imovel("02", "rua dos carros", 150.0f, 120.0f);
//        Imovel imovel3 = new Imovel("03", "rua dos cachorros", 200.0f, 180.0f);
//        listaImoveis.add(imovel1);
//        listaImoveis.add(imovel2);
//        listaImoveis.add(imovel3);
//
//        // Adicionando faturas à listaFaturas
//        Fatura fatura1 = new Fatura("ID1", LocalDate.now(), 100.0f, 80.0f, 100.0f);
//        Fatura fatura2 = new Fatura("ID2", LocalDate.now(), 150.0f, 120.0f, 150.0f);
//        Fatura fatura3 = new Fatura("ID3", LocalDate.now(), 200.0f, 180.0f, 200.0f);
//
//        listaFaturas.add(fatura1);
//        listaFaturas.add(fatura2);
//        listaFaturas.add(fatura3);
//
//        // Adicionando reparos à listaReparos
//        Reparo reparo1 = new Reparo("Reparo1", LocalDate.now().plusDays(5), LocalDate.now(), LocalDate.now().plusDays(5));
//        Reparo reparo2 = new Reparo("Reparo2", LocalDate.now().plusDays(7), LocalDate.now(), LocalDate.now().plusDays(7));
//        Reparo reparo3 = new Reparo("Reparo3", LocalDate.now().plusDays(10), LocalDate.now(), LocalDate.now().plusDays(10));
//
//        listaReparos.add(reparo1);
//        listaReparos.add(reparo2);
//        listaReparos.add(reparo3);
//
//        // Adicionando falhas à listaFalhas
//        Falha falha1 = new Falha("Falha1", LocalDate.now().plusDays(1), LocalDate.now(), LocalDate.now().plusDays(2), "Tipo1");
//        Falha falha2 = new Falha("Falha2", LocalDate.now().plusDays(3), LocalDate.now(), LocalDate.now().plusDays(5), "Tipo2");
//        Falha falha3 = new Falha("Falha3", LocalDate.now().plusDays(5), LocalDate.now(), LocalDate.now().plusDays(7), "Tipo3");
//        listaFalhas.add(falha1);
//        listaFalhas.add(falha2);
//        listaFalhas.add(falha3);
//    }
}
