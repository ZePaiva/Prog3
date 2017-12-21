package aula12.e3;
import java.util.*;

import java.io.*;

public class Agenda {

	private List<Contacto> agenda = new ArrayList<>();
	private List<Plugin> plugins = new ArrayList<>();

	/* Loads teh plugins */
	public Agenda() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
		loadPlugins("bin/aula12/e3/plugins");
	}

	public void loadPlugins(String directoryName) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		for(File pluginFile : (new File(directoryName)).listFiles()) {
			String pluginName = "aula12.e3.plugins." + pluginFile.getName().split("\\.")[0];
			plugins.add(PluginManager.load(pluginName));
		}
	}

	public void loadAgenda(String filename) throws Exception {
		Scanner read = new Scanner(new File(filename));
		Plugin pluginProxy = (Plugin)Class.forName("aula12.e3.plugins." + read.nextLine()).newInstance();
		addContacts(pluginProxy.loadFile(read));
		read.close();
	}

	public void saveFile(String filename, Plugin format) throws IOException{
		format.saveFile(filename, agenda);
	}

	public void addContacts(List<Contacto> conts) {
		for(Contacto c : conts) {
			addContact(c);
		}
	}

	private void addContact(Contacto c) {
		if (!agenda.contains(c))
			agenda.add(c);
	}

	public void removeContact(Contacto cont) throws Exception{
		if(!agenda.contains(cont)) throw new Exception("Pessoa given doesn't exist in list");
		agenda.remove(cont);
	}

	public int size() {
		return agenda.size();
	}

	public List<Plugin> supportedPlugins(){
		return plugins;
	}

	@Override
	public String toString() {
		return agenda.toString();
	}

}