package filmes;
import org.json.*;

public class Filmes {
	private String titulo;
	private String ano;
	private String genero;
	
	public Filmes(String titulo, String ano) {
		JSONObject obj = new JSONObject();
		obj.put("titulo", titulo);
		obj.put("ano", ano);
		setTitulo(obj.get("titulo").toString());
		setAno(obj.get("ano").toString());
			
	}
	
	
	@Override
	public String toString() {
		
		return "Filmes [titulo=" + titulo + ", ano=" + ano + "]";
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	
	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public static void main(String[] args) {
		Filmes filme1 = new Filmes("Os Arquivos JSON", "1998");	
		
		Filmes filme2 = new Filmes("Os Barbaros", "2015");	
		//System.out.println(filme1);
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(filme1);
		jsonArray.put(filme2);
		for(int i= 0; i< jsonArray.length(); i++) {
			System.out.println(jsonArray.getString(i));
		}
	}
	
}
