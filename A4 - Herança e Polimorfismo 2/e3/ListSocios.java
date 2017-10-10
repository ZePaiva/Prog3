package aula4.e3;

import java.util.*;

public class ListSocios {
	private ArrayList<Socio> list;
	
	public ListSocios()
	{
		list = new ArrayList<Socio>();
	}
	
	
	public boolean putSoc(Socio s)
	{
		return list.add(s);
	}
	
	public void remSoc(int s)
	{	
		list.set(s, null);
	}
	
	public Socio getSoc(int s)
	{
		return list.get(s);
	}
	
	public boolean hasSoc(int s)
	{
		return list.get(s) != null;
	}
	
	public int lastSocNumb()
	{
		return list.size();
	}
}
