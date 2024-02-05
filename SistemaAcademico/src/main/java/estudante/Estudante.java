package estudante;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Estudante {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String email;
	private String matricula;
	public Estudante(Integer id, String nome, String email, String matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
	}
	public Estudante() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + ", email=" + email + ", matricula=" + matricula + "]";
	}
	
	public static void main(String[] args) {
		
////Create////
//		Estudante estudante = new Estudante(null, "Jucão", "jucão@jucão", "111111");
//		Estudante estudante2 = new Estudante(null, "João", "joão@joão", "222222");
//		Estudante estudante3 = new Estudante(null, "Maria", "maria@maria", "333333");
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(estudante);
//		em.persist(estudante2);
//		em.persist(estudante3);
//		em.getTransaction().commit();
//		em.close();
//		emf.close();

		
////Read////
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();	
//		Estudante estudante = em.find(Estudante.class, 2);
//		System.out.println(estudante);
//		em.close();
//		emf.close();
		
////Delete////
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		Estudante estudante = em.find(Estudante.class, 1);
//		em.remove(estudante);
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
		
////Update////
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Estudante estudante = em.find(Estudante.class, 2);
		estudante.setNome("Chico");
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	
}
