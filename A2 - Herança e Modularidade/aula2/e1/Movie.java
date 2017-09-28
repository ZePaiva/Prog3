package aula2.e1;

import static java.lang.System.*;

public class Movie
{
  private static int seqID = 1;
  private final int id;
  private int totRating;
  private int screenings;
  private int rating;
  private String title;
  private String category;
  private String idade;
  private boolean available;

  public Movie(String t, String cat, String i)
  {
    id = seqID++;
    title = t;
    if (!cat.equals("Ação") && !cat.equals("Comédia") && !cat.equals("Infantil") && !cat.equals("Drama"))
    	throw new RuntimeException("Categoria não especializada.\n");
    category = cat;
    if (!i.equals("ALL") && !i.equals("M6") && !i.equals("M12") && !i.equals("M16") && !i.equals("M18"))
    	throw new RuntimeException("Padrão etário não aceitável.\n");
    idade = i;
    available = true;
    totRating = 0;
    screenings = 0;
    rating = 0;
  }

  public Movie(int sd,String t, String cat)
  {
    this(t, cat, "ALL");
  }

  public int getId()
  {
    return id;
  }

  public String getTitle()
  {
    return title;
  }

  public String getCategory()
  {
    return category;
  }

  public String getIdade()
  {
    return idade;
  }

  public String toString(){
    return "ID do filme: " + id + " | Título: " + title + " | Categoria: " + category + 
    		" | Faixa etária: " + idade + " | Disponível: " + (available ? "sim" : "não") + " | Rating: " + rating + "\n";
  }

  public boolean available()
  {
	  return available;
  }
  
  public boolean out() {
	  if (!available())
	  {
		  out.println("Filme não pode ser retirado");
		  return false;
	  }
	  available = false;
	  return true;
  }
  
  public void in() {
	  available = true;
  }
  
  public int getRating()
  {
	  return rating;
  }
  
  public void updateRating(int novo)
  {
	  screenings++;
	  totRating += novo;
	  rating = totRating/screenings;
  }
  
  public int compareTo(Movie m)
  {
	  if (this.rating == m.rating)
		  return 0;
	  else if (this.rating < m.rating)
		  return -1;
	  else
		  return 1;
  }
}
