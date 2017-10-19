package aula5.e3;

import java.io.*;
import java.util.*;
import aula1.e2.*;

public interface AgendaInterface
{
	public void saveAgenda(File file, Contacto[] p) throws IOException;
	public ArrayList<Contacto> loadAgenda(Scanner file) throws IOException;

}
