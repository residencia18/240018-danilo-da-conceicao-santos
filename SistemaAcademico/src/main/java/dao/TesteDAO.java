package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dto.EstudanteDTO;
import estudante.Curso;
import estudante.Estudante;

public class TesteDAO {
	public static void preparaBD(EntityManager em) {
		Curso curso1 = new Curso(null, "Java", 10);
		Curso curso2 = new Curso(null, "C#", 8);
		Curso curso3 = new Curso(null, "C++", 10);
		
		Estudante estudante1 = new Estudante(null, "João", "joão@joão", "111111", curso1);
		Estudante estudante2 = new Estudante(null, "Maria", "maria@maria", "222222", curso2);
		Estudante estudante3 = new Estudante(null, "Pedro", "pedro@pedro", "333333", curso3);
		Estudante estudante4 = new Estudante(null, "Ana", "ana@ana", "444444", curso1);
		Estudante estudante5 = new Estudante(null, "Paulo", "paulo@paulo", "555555", curso2);
		Estudante estudante6 = new Estudante(null, "Lucas", "lucas@lucas", "666666", curso3);
		
		em.getTransaction().begin();
		em.persist(curso1);
		em.persist(curso2);
		em.persist(curso3);
		em.persist(estudante1);
		em.persist(estudante2);
		em.persist(estudante3);
		em.persist(estudante4);
		em.persist(estudante5);
		em.persist(estudante6);
		em.getTransaction().commit();
	}
	public static void listarTodosEstudante(EntityManager em) {
		String jpql = "select e from Estudante e";
		TypedQuery<Estudante> typedquery = em.createQuery(jpql, Estudante.class);
		List<Estudante> lista = typedquery.getResultList();
		for (Estudante e : lista) {
			System.out.println(e);
		}
	}
	
	public static void listarEstudante(EntityManager em) {
		String jpql = "select e from Estudante e where e.id = 1";
		TypedQuery<Estudante> typedquery = em.createQuery(jpql, Estudante.class);
		System.out.println(typedquery.getSingleResult());
	}
	
	public static void alterarEstudante(EntityManager em) {
		String jpql = "select e from Estudante e where id = 1";
		TypedQuery<Estudante> typedquery = em.createQuery(jpql, Estudante.class);
		Estudante estudante = typedquery.getSingleResult();
		System.out.println(estudante);
		em.getTransaction().begin();
		estudante.setEmail("joão@bedeu");
		em.persist(estudante);
		em.getTransaction().commit();
		
		
	}
	
	public static void listarTodosEstudantePorNome(EntityManager em) {
		String jpql = "select e.nome from Estudante e ";
		TypedQuery<Estudante> typedquery = em.createQuery(jpql, Estudante.class);
		List<Estudante> lista = typedquery.getResultList();
		for (Estudante e : lista) {
			System.out.println(e);
		}
	}
	
	//testar dto
	public static void gerarEstudanteDTO(EntityManager em) {
		String jpql = "select new dto.EstudanteDTO(e.nome, e.matricula, e.curso.nomeCurso) from Estudante e";
		TypedQuery<EstudanteDTO> typedquery = em.createQuery(jpql, EstudanteDTO.class);
		List<EstudanteDTO> lista = typedquery.getResultList();
		for (EstudanteDTO e : lista) {
			System.out.println(e);
		}
		
	}
	public static void listarCursoMenorNoveSemestres(EntityManager em) {
		String jpql = "select c from Curso c where c.numeroSemestres < 9";
		TypedQuery<Curso> typedquery = em.createQuery(jpql, Curso.class);
		List<Curso> lista = typedquery.getResultList();
		for (Curso c : lista) {
			System.out.println(c);
		}
	}
	
	public static void mostrarEstudantePorCurso(EntityManager em) {
		String jpql = "select c from Curso c where c.id = 1";
		
		TypedQuery<Curso> typedquery = em.createQuery(jpql, Curso.class);
		
		Curso c = typedquery.getSingleResult();
		
		String jpqlEstudante = "select e from Estudante e where e.curso = :curso";
		
		TypedQuery<Estudante> typedqueryEstudante = em.createQuery(jpqlEstudante, Estudante.class);
		typedqueryEstudante.setParameter("curso", c);
		List<Estudante> lista = typedqueryEstudante.getResultList();
		for (Estudante e : lista) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		TesteDAO.preparaBD(em);
//		System.out.println("Dados Criados com sucesso!");
//		em.close();
//		emf.close();
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		TesteDAO.listarTodosEstudante(em);

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		TesteDAO.listarEstudante(em);
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		TesteDAO.listarTodosEstudantePorNome(em);
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		TesteDAO.alterarEstudante(em);
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		TesteDAO.gerarEstudanteDTO(em);
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
//		EntityManager em = emf.createEntityManager();
//		TesteDAO.listarCursoMenorNoveSemestres(em);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		TesteDAO.mostrarEstudantePorCurso(em);
	}
	
}
