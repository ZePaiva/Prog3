/*
 * Main file made by: Andre Mourato (github: https://github.com/andremourato)
 */

package aula13.e3;

import java.util.Arrays;

public class BrincBeir {
	public static void main(String args[]) {
		System.out.println("------ Testing NameList ------");

		/* These string[] are used for testing purposes */
		String[] workers = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"};
		String[] toys = {"Carro", "Comboio a vapor", "Darth Vader - Boneco de Ação"};
		EmpReg names = new EmpReg();

		//Adds workers
		Arrays.stream(workers).forEach(x -> names.add(x));

		//Prints the names of all the workers
		System.out.println(names);

		System.out.println("\n------ Testing WorkerGifts (Worker,Gift) ------");
		EmpGifts gifts = new EmpGifts();
		//Simulates giving a gift to an employee every month for a year
		System.out.println("\nGiving gifts...\n");
		for(int i = 0; i < 12; i++) {
			int randWorkerIndex = (int)(Math.random() * workers.length);
			int randGiftIndex = (int)(Math.random() * toys.length);
			gifts.give(toys[randGiftIndex],workers[randWorkerIndex]);
			System.out.println("'"+ toys[randGiftIndex] +"' given to "+workers[randWorkerIndex]);
		}
		System.out.println("\nPrinting lists of gifts...\n");
		System.out.println(gifts);
		System.out.println("\nTaking back gifts...\n");

		//Removes 1 gift from each workers. Workers can have more than 1 gift
		for(String worker : workers)
			gifts.get(worker);

		System.out.println("\nPrinting lists of gifts...\n");
		System.out.println(gifts);

		System.out.println("\n------ Testing ToyList ------");
		String randomWorker = workers[(int)(Math.random() * workers.length)];
		Toys toyList = new Toys(randomWorker);

		//Adds all toys
		Arrays.stream(toys).forEach(x -> toyList.add(x));
		System.out.println(toyList);
		System.out.println(toyList);
		toyList.remove("Carro");
		toyList.remove("Barbie");

		System.out.println("\n------ Testing Name Counter ------");
		EmpReg counter = new EmpReg();

		//Counts names
		Arrays.stream(workers).forEach(x -> counter.add(x));
		System.out.println(counter);
		counter.remove("Andre"); //decrements by 1 the number of names Andre
		counter.remove("Joana"); //and so on...
		counter.remove("Joana");
		System.out.println(counter);

		System.out.println("\n------ Testing Ticket Manager ------\n");

		SeasonPasses manager = new SeasonPasses(workers);
		System.out.println("Given tickets to: \n");
		manager.give(4).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		manager.give(3).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		manager.give(1).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");

		//Will rotate and give a ticket to the first worker
		manager.give(10).forEach(System.out::println);
	}
}
