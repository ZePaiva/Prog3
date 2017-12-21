package teste;
import java.io.Serializable;
import java.io.*;
import java.util.*;

public class Cadeira extends Mobiliario implements Serializable {
	private static final long serialVersionUID = 75264722956L; 
	private Mobiliario.TipoCadeira material;
	private Cadeira.TipoCadeira tipoCadeira;
	private int apoios;
	private double altura;
	
	public Cadeira(String n, int i, Mobiliario.TipoCadeira m, Cadeira.TipoCadeira t, double h, int a) {
		super(n,i);
		material = m;
		tipoCadeira = t;
		apoios = a;
		altura = h;
	}
	
	public enum TipoCadeira {
		Escritorio, Espera, Atendimento
	}

	public Mobiliario.TipoCadeira getMaterial() {
		return material;
	}

	public Cadeira.TipoCadeira getTipoCadeira() {
		return tipoCadeira;
	}

	public int getApoios() {
		return apoios;
	}

	public double getAltura() {
		return altura;
	}
	
	public void saveCadeira(String file) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(this);
		out.close();
	}
	
	public Cadeira rescueCadeira(String file) throws IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		return (Cadeira) in.readObject();
	}

	@Override
	public String toString() {
		return "Cadeira [material=" + material + ", tipoCadeira=" + tipoCadeira + ", apoios=" + apoios + ", altura="
				+ altura + "]";
	}

	
}
