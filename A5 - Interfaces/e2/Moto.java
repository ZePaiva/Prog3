package aula5.e2;

public class Moto extends Motorizado
{
	public Moto(int ano, int rodas, int cc, int pow, int speed, double consumo, double comb, String capacete, String mark, String stamp, String cor)
	{
		super(rodas, mark, cor, ano, cc, pow, speed, comb, consumo, stamp);
	}

	@Override
	public String toString()
	{
		return "Moto -> ano: " + super.getAno()+ ", cc: " + super.getCc() + ", maxSpeed: " + super.getMaxSpeed() + ", matricula: " + super.getMatricula();
	}
	

}
