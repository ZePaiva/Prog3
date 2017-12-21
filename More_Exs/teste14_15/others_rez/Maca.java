package teste;

public class Maca extends Marquesa implements Transporte {
	private TipoTransporte tipo;
	private int grades;		

	public Maca(String n, int i, Mobiliario.TipoCadeira m, double c, double l, boolean col, int g) {
		super(n, i, m, c, l, col, false);
		tipo = TipoTransporte.Urgente;
		grades = g;
	}
	
	public TipoTransporte getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransporte tipo) {
		this.tipo = tipo;
	}

	public int getGrades() {
		return grades;
	}

	@Override
	public String toString() {
		return super.toString() + "Maca [tipo=" + tipo + ", grades=" + grades + "]";
	}
	
	
}
