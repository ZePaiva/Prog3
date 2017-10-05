package aula3.e4;

public class Loan
{
  private Data checkOut;
  private Data checkIn;
  private int loaned;
  private Movie picked;
  
  public Loan(Data out, int loan, Movie p)
  {
	  checkOut = out;
	  loaned = loan;
	  picked = p;
  }

  
  public void deposit(Data in)
  {
	  checkIn = in;
	  picked.in();
  }

  public Data getCheckOut() 
  {
	return checkOut;
  }
	
  public Data getCheckIn() 
  {
	  return checkIn;
  }
	
  public int getLoaned() 
  {
	  return loaned;
  }
	
  public Movie getPicked() 
  {
	  return picked;
  }

  @Override
  public String toString() 
  {
	  if (checkIn == null)
		  return "Loan [checkOut=" + checkOut.toString() + ", loaned=" + loaned + ", picked=" + picked.getTitle() + "]";
	  else
		  return "Loan [checkOut=" + checkOut.toString() + ", loaned=" + loaned + ", picked=" + picked.getTitle() + ", checkIn=" + checkIn.toString() + "]";
  }
}
