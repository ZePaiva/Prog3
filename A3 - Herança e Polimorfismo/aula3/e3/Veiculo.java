package aula3.e3;

public class Veiculo
{
	private int cilindrada;
	private int potency;
	private int lotacao;
	private String cardNeeded;
	private double pesoBruto;
	
	public Veiculo(String card, double peso, int cc, int pot, int lot)
	{
		if (!card.equals("A") && !card.equals("B") && !card.equals("C") && !card.equals("D"))
			throw new IllegalArgumentException("Carta não válida");
		cardNeeded = card;
		pesoBruto = peso;
		cilindrada = cc;
		potency = pot;
		lotacao = lot;
	}
	
	public int getCilindrada()
	{
		return cilindrada;
	}

	public int getPotency()
	{
		return potency;
	}

	public int getLotacao()
	{
		return lotacao;
	}

	public String getCardNeeded()
	{
		return cardNeeded;
	}

	public double getPesoBruto()
	{
		return pesoBruto;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNeeded == null) ? 0 : cardNeeded.hashCode());
		result = prime * result + cilindrada;
		result = prime * result + lotacao;
		result = prime * result + potency;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (cardNeeded == null)
		{
			if (other.cardNeeded != null)
				return false;
		} else if (!cardNeeded.equals(other.cardNeeded))
			return false;
		if (cilindrada != other.cilindrada)
			return false;
		if (lotacao != other.lotacao)
			return false;
		if (potency != other.potency)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Veiculo [cilindrada=" + cilindrada + ", potency=" + potency + ", lotacao=" + lotacao + ", cardNeeded="
				+ cardNeeded + ", pesoBruto=" + pesoBruto + "]";
	}
	
	public boolean canDrive(Condutor r)
	{
		return (r.getCard()).equals("A");
	}
}
