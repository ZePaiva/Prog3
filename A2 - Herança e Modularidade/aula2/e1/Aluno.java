package aula2.e1;

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
}
