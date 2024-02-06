package estudante;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private Integer numeroSemestres;
	@OneToMany(mappedBy="curso")
	List<Estudante> estudantes;

	
	
	public Curso(Integer id, String nome, Integer numeroSemestres) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroSemestres = numeroSemestres;
	}

	public Curso() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroSemestres() {
		return numeroSemestres;
	}

	public void setNumeroSemestres(Integer numeroSemestres) {
		this.numeroSemestres = numeroSemestres;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", numeroSemestres=" + numeroSemestres + "]";
	}
	
	
	
}
