package aula12.e3.plugins;

import aula1.e2.Data;
import aula12.e3.Contacto;
import aula12.e3.Plugin;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VCard implements Plugin {
	@Override
	public ArrayList<Contacto> loadFile(Scanner file) throws IOException {
		ArrayList<Contacto> contactos = new ArrayList<>();
		int i = 0;
		String linha[];
		String nome = "nome";
	int num = 0;
	String dof[];
	while (file.hasNextLine())
	{
		linha = file.nextLine().split("#");
		dof = linha[linha.length-1].split("/");
		contactos.add(new Contacto(linha[1], 0, new Data(Integer.parseInt(dof[0]), Integer.parseInt(dof[1]), Integer.parseInt(dof[2])), Integer.parseInt(linha[2])));
	}

		return contactos;

}

	@Override
	public void saveFile(String file, List<Contacto> contactos) throws FileNotFoundException {
		PrintStream fix = new PrintStream(file);
		fix.println("VCard");
		contactos.stream()
				.forEach(f -> fix.printf("#%s#%s#%s\n", f.getName(), f.getNumb(), f.getDateOfBirth()));
	}
}
