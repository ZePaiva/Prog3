package teste;
import java.io.Serializable;

public class Dimensao implements Serializable{
	private static final long serialVersionUID = 75264722956L; 
	private double comprimento;
	private double largura;
	
	public Dimensao(double c, double l) {
		comprimento = c;
		largura = l;
	}

	public double getComprimento() {
		return comprimento;
	}

	public double getLargura() {
		return largura;
	}

	@Override
	public String toString() {
		return "Dimensao [comprimento=" + comprimento + ", largura=" + largura + "]";
	}
	
	
}
