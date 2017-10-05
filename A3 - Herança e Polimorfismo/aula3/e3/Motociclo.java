package aula3.e3;

public class Motociclo extends Veiculo
{
	public Motociclo(String carta, double pesoBruto, int cc, int pot, int lot) throws IllegalAccessException
	{
		super(carta, pesoBruto, cc, pot, lot);
		
	}
	
	public Motociclo(Motociclo m) throws IllegalAccessException
	{
		this(m.getCardNeeded(), m.getPesoBruto(), m.getCilindrada(), m.getPotency(), m.getLotacao());
	}

	@Override
	public String toString()
	{
		return "Motociclo:\n\t-> Potência: " + super.getPotency() + "\n\t-> Cilindrada: " + super.getCilindrada() + "\n\t-> Peso Bruto: " + super.getPesoBruto();
	}
	@Override
	public boolean canDrive(Condutor enc)
	{
		return true;
	}
}
