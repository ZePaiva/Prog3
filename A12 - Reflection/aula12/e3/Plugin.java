package aula12.e3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Plugin {
	public ArrayList<Contacto> loadFile(Scanner file) throws IOException;
	public void saveFile(String file, List<Contacto> contactos) throws FileNotFoundException;
}
