package teste;

public class CamaArticulada extends Cama{
	private TipoCama tipo;
	
	public CamaArticulada(String n, int i, Mobiliario.TipoCadeira m, double c, double l, boolean col, boolean t) {
		super(n,i,m,c,l,col);
		if(t)
			tipo = TipoCama.Eletrica;
		else
			tipo = TipoCama.Manual;
	}

	public TipoCama getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return super.toString() + "CamaArticulada [tipo=" + tipo + "]";
	}
	
	
}



