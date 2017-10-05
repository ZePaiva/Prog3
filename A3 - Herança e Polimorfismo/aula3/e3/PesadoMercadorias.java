package aula3.e3;

public class PesadoMercadorias extends Veiculo
{
	public PesadoMercadorias(String carta, double pesoBruto, int cc, int pot, int lot) throws IllegalAccessException
	{
		super(carta, pesoBruto, cc, pot, lot);
		if (carta.equals("A") || carta.equals("B"))
			throw new IllegalAccessException("Carta errada.");
	}
	
	public PesadoMercadorias(PesadoMercadorias m) throws IllegalAccessException
	{
		this(m.getCardNeeded(), m.getPesoBruto(), m.getCilindrada(), m.getPotency(), m.getLotacao());
	}

	@Override
	public String toString()
	{
		return "Pesado de Mercadorias:\n\t-> Potência: " + super.getPotency() + "\n\t-> Cilindrada: " + super.getCilindrada() + "\n\t-> Peso Bruto: " + super.getPesoBruto();
	}
	
	@Override
	public boolean canDrive(Condutor enc)
	{
		return ((enc.getCard()).equals("A") || (enc.getCard()).equals("B"))? false : true;
	}
}
