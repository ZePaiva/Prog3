package teste;

public class Marquesa extends Cama{
	private boolean inclin;
	
	public Marquesa(String n, int i, Mobiliario.TipoCadeira m, double c, double l, boolean col, boolean in) {
		super(n,i,m,c,l,col);
		inclin = in;
	}

	public boolean isInclin() {
		return inclin;
	}

	@Override
	public String toString() {
		return super.toString() + "Marquesa [inclin=" + inclin + "]";
	}
	
}
