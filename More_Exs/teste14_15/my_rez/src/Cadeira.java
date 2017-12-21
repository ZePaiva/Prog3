import java.io.*;
import java.util.Objects;

public class Cadeira extends Mobiliario implements Serializable
{
	private static final int serialUID = 1;
	private TipoCadeira tipo;
	private double altura;
	private int apoios;

	public void saveCadeira(String filename) throws IOException
	{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(this);
		out.close();
	}

	public Cadeira rescueCadeira(String filename) throws IOException, ClassNotFoundException
	{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		return (Cadeira) in.readObject();
	}

	public enum TipoCadeira
	{
		Escritorio, Espera, Atendimento;
	}

	public Cadeira(String nome, int id, Mobiliario.TipoCadeira material, TipoCadeira tipo, double altura, int apoios)
	{
		super(nome, id, material);
		this.tipo = tipo;
		this.apoios = apoios;
		this.altura = altura;
	}

	public double getAltura()
	{
		return altura;
	}

	public int getApoios()
	{
		return apoios;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Cadeira cadeira = (Cadeira) o;
		return Double.compare(cadeira.altura, altura) == 0 && apoios == cadeira.apoios && tipo == cadeira.tipo;
	}

	@Override
	public int hashCode()
	{

		return Objects.hash(super.hashCode(), tipo, altura, apoios);
	}

	@Override
	public String toString()
	{
		return "Cadeira{" + "tipo=" + tipo + ", altura=" + altura + ", apoios=" + apoios + '}';
	}
}