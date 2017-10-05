package aula3.e3;

import aula1.e2.*;

public class Condutor extends Pessoa
{
	private String cardType;
	
	public Condutor(String card, String name, int cc, Data d)
	{
		super(name, cc, d);
		if (!card.equals("A") && !card.equals("B") && !card.equals("C") && !card.equals("D"))
			throw new IllegalArgumentException("Carta não válida");
		cardType = card;
	}
	
	public Condutor(String card, Pessoa p)
	{
		this(card, p.getName(), p.getCC(), p.getDateOfBirth());
	}
	
	public Condutor(Condutor c)
	{
		this(c.cardType, c.getName(), c.getCC(), c.getDateOfBirth());
	}
	public String getCard()
	{
		return cardType;
	}
	
	@Override
	public String toString()
	{
		return "Condutor: " + super.getName() + " | Carta : " + cardType;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		/*if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;*/
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condutor other = (Condutor) obj;
		if (cardType == null)
		{
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		return true;
	}
}