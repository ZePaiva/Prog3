package aula12.e3;

import aula1.e2.Data;
import aula12.e3.plugins.CSV;
import aula12.e3.plugins.Nokia;
import aula12.e3.plugins.VCard;
import java.util.Arrays;
import java.util.List;

abstract class PluginManager {
	public static Plugin load(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class<?> c = Class.forName(name);
		return (Plugin) c.newInstance();
	}
}

public class Test {
	public static void main(String args[]) throws Exception {
		Agenda agenda = new Agenda();

		System.out.println("Supported plugins:");
		List<Plugin> plgs = agenda.supportedPlugins();
		for (Plugin plg : plgs) {
			System.out.println(plg.getClass().getSimpleName());
		}

		System.out.println();

		//Nokia format
		agenda.loadAgenda("fil1.txt");
		agenda.addContacts(Arrays.asList(
				new Contacto("a",0,new Data(),1),
				new Contacto("b",0,new Data(),2),
				new Contacto("c",0,new Data(),3),
				new Contacto("d",0,new Data(),4)
		));
		agenda.saveFile("fil1.txt", new Nokia());
		System.out.println("A agenda fil1.txt tem " + agenda.size() + " contactos:");
		System.out.println(agenda + "\n");

		//vCard format
		agenda.loadAgenda("fil2.txt");
		agenda.addContacts(Arrays.asList(
				new Contacto("a",0,new Data(),1),
				new Contacto("b",0,new Data(),2),
				new Contacto("c",0,new Data(),3),
				new Contacto("d",0,new Data(),4)
		));
		agenda.saveFile("fil2.txt",new VCard());
		System.out.println("A agenda fil2.txt tem " + agenda.size() + " contactos:");
		System.out.println(agenda + "\n");

		//CSV format
		agenda.loadAgenda("fil3.txt");
		agenda.addContacts(Arrays.asList(
				new Contacto("a",0,new Data(),1),
				new Contacto("b",0,new Data(),2),
				new Contacto("c",0,new Data(),3),
				new Contacto("d",0,new Data(),4)
		));
		agenda.saveFile("fil3.txt", new CSV());
		System.out.println("A agenda fil3.txt tem " + agenda.size() + " contactos:");
		System.out.println(agenda + "\n");
	}
}
