package teste;

public class CadeiraRodas extends Cadeira implements Transporte {
	private int rodas;
	private TipoTransporte tipo;
	
	public CadeiraRodas(String n, int i, Mobiliario.TipoCadeira m, Cadeira.TipoCadeira t, double h, int a, int r, boolean e) {
		super(n,i,m,t,h,a);
		rodas = r;
		if (e)
			tipo = TipoTransporte.MobilidadeReduzida;
	}

	public TipoTransporte getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransporte tipo) {
		this.tipo = tipo;
	}

	public int getRodas() {
		return rodas;
	}

	@Override
	public String toString() {
		return super.toString() + "CadeiraRodas [rodas=" + rodas + ", tipo=" + tipo + "]";
	}
	
}
