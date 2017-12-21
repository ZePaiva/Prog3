public interface Transporte
{
	public default TipoTransporte getTipo() {return null;}
	public default void setTipo(TipoTransporte tipo){}
}

enum TipoTransporte
{
	Urgente, MobilidadeReduzida, Manual;
}
