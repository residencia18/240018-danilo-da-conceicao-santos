package dao;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Cliente;
import model.Imovel;
public class CoelhoDAO {
	private EntityManager entityManager;

    public CoelhoDAO() {
        this.entityManager = Persistence.createEntityManagerFactory("unit_academico").createEntityManager();
      
    }
	
	 public void menuCoelho() {
	    	
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
	        		menuFatura();
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

	private void menuPagamento() {
		// TODO Auto-generated method stub
		
	}

	private void menuFatura() {
		// TODO Auto-generated method stub
		
	}

	private void menuImovel() {
		// TODO Auto-generated method stub
		
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
	        		menuCoelho();
	            	break;
	            	
	        	case "1":
	        		incluirCliente();
	            	break;
	            	
	        	case "2":
	        	//	consultarCliente();
	            	break;
	            	
	        	case "3":
	        	//	listarCliente();
	            	break;
	            	
	        	case "4":
	        	//	excluirCliente();
	            	break;
	            	
	        	case "5":
	        	//	alterarCliente();
	            	break;

	        	default:
	            	System.out.println("Opcao invalida, insira novamente");
	            	break;
	        	}
	    	}
	    }
	 
	 public void incluirCliente() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("-----Incluindo novo cliente-----");

	        System.out.println("Nome: ");
	        String nome = sc.nextLine();

	        System.out.println("CPF: ");
	        String cpf = sc.nextLine();

	        // Validação do CPF antes de criar o cliente
	        if (!Cliente.validarCPF(cpf)) {
	            System.out.println("CPF inválido. Não foi possível cadastrar o cliente.");
	            return;
	        }

	        System.out.println("Possui imóvel cadastrado? (sim / nao): ");
	        String resposta = sc.nextLine();

	        Cliente cliente = new Cliente(nome, cpf);

	        if (resposta.equalsIgnoreCase("sim")) {
	            System.out.println("Matrícula do imóvel: ");
	            String matricula = sc.nextLine();

	            Imovel imovel = entityManager.find(Imovel.class, matricula);
	            if (imovel != null) {
	                cliente.setImovel(imovel);
	            } else {
	                System.out.println("Imóvel não encontrado, cadastrando cliente sem imóvel");
	            }
	        }

	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.persist(cliente);
	            transaction.commit();
	            System.out.println("Cliente cadastrado com sucesso");
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
	        }
	    }
}
