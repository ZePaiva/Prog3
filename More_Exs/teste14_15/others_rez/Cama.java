package teste;
import java.io.Serializable;

public class Cama extends Mobiliario implements Serializable{
	private static final long serialVersionUID = 75264722956L; 
	private Mobiliario.TipoCadeira material;
	private Dimensao dim;
	private boolean colchao;
	
	public Cama(String n, int i, Mobiliario.TipoCadeira m, double c, double l, boolean col) {
		super(n,i);
		material = m;
		dim = new Dimensao(c,l);
		colchao = col;
	}

	public boolean isColchao() {
		return colchao;
	}

	public void setColchao(boolean colchao) {
		this.colchao = colchao;
	}

	public Mobiliario.TipoCadeira getMaterial() {
		return material;
	}

	public Dimensao getDim() {
		return dim;
	}

	@Override
	public String toString() {
		return "Cama [material=" + material + ", dim=" + dim + ", colchao=" + colchao + "]";
	}
	
	
}
