package Estudante;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public class Estudante {
	private String nome, cpf;
	private Date dataNasc;
	
	
	
	public Estudante(String nome, String cpf) throws ParseException {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = criarDate();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public void emprimeData(Date data) {
		
		System.out.println(data);
	}
	public static Date criarDate() throws ParseException
	{	
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite a data");
			SimpleDateFormat dt =new  SimpleDateFormat("dd/MM/yyyy");
			Date data = dt.parse(sc.nextLine());
			
		 return data;
	}
		public static int calculaIdade(LocalDate dataNascimento) {
		  LocalDate hoje = LocalDate.now();
		  Period periodo = hoje.until(dataNascimento);
		  return periodo.getYears();
		}

		
	

	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + dataNasc + "]";
	}

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		String nome, cpf;
		
		System.out.println("Digite o nome");
		nome= sc.nextLine();
		

		System.out.println("Digite o cpf");
		cpf= sc.nextLine();
		
		Estudante estudante = new Estudante(nome,cpf);
		
		System.out.println(estudante.toString());
		
//		System.out.println("Digite o data");
//		String data = sc.nextLine();
		
		Instant instant = estudante.getDataNasc().toInstant();
		LocalDate localDate = instant.atStartOfDay().toLocalDate();
	
		LocalDate dataNascimento = LocalDate.of(2000, 01, 01);
		
		int idade = calculaIdade(estudante.getDataNasc());

		System.out.println("A idade do cliente é: " + idade);
		
		
	}	
}
