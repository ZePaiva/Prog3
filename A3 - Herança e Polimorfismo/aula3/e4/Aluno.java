package aula3.e4;

public class Aluno extends Socio
{
  private int nmec;
  private String course;

  public Aluno(Data insc, Data dof, String n, String cors, int c, int nm, int l)
  {
    super(insc, dof, n, c, l);
    nmec = nm;
    course = cors;
  }

  public String getCourse()
  {
    return course;
  }

  public int getNMec()
  {
    return nmec;
  }
  
  @Override
  public String toString()
  {
	  return " Sócio nº: " + super.getnSoc() + " -> Aluno nº: " + nmec + ", Nome: " + super.getNome() + " Curso: " + course;
  }

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + nmec;
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (course == null)
		{
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (nmec != other.nmec)
			return false;
		return true;
	}
}
