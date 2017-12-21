package teste;
import java.io.Serializable;

public class Mobiliario implements Serializable{
	private static final long serialVersionUID = 75264722956L; 
	private String nome;
	private int id;
	
	public Mobiliario(String n, int i) {
		nome = n;
		id = i;
	}
	
	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}
	
	public enum TipoCadeira {
		Madeira, Plastico, Metal, Sintetico
	}
}