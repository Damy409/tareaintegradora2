package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	//Comentario de prueba

	private Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Executable exe = new Executable();
		exe.menu();

	}

	/**
	 * Description:Menu of the program 
	 */
	public void menu() {

		int answer = 1;

		System.out.println("Welcome to GreenSQA");

		do{
			System.out.println("1. Register a Knowledge unit");
			System.out.println("2. Approve Knowledge unit");
			System.out.println("3. Search information of Knowledge unit");
			int option = reader.nextInt();

			switch (option) {
				case 1:
					registerKnowledgeUnit();
					break;
			
				case 2:
					approveKnowledgeUnit();
					break;

				case 3:
					showAllKnowledgeUnits();

					break;
			}

			System.out.println("Would you like to do something else \n 1. Yes \n 2. No");
			answer = reader.nextInt();

		}while(answer == 1);

	}

	/**
	 * Description: method that allows registering capsules of knowledge
	 */
	public void registerKnowledgeUnit() {

		System.out.println("Insert the information of the Knowledge unit");

		//Limpieza de buffer
		reader.nextLine();

		System.out.println("Write the identification, Example: A0000");
		String id = reader.nextLine();

		System.out.println(" A short description of the Knowledge unit");
		String description = reader.nextLine();

		System.out.println("Type of Knowledge unit (Technical-Experiences)");
		String type = reader.nextLine();

		System.out.println("Write a learned lesson or knowledge");
		String learnedLessons = reader.nextLine();

		controller.registerKnowledgeUnit(id, description, type, learnedLessons);


	}

	/**
	 * Description: method that allows to approve knowledge capsules
	 */
	private void approveKnowledgeUnit() {


		String research = controller.searchKnowledgeUnite();

		
		if(research.equals("")){

			System.out.println("There is nothing save");

		}else{


			System.out.println("This are the Knowledge units" +research);
			System.out.println("Select the Knowledge unit that you want");
			int capsule = reader.nextInt();

			System.out.println("Want do you want \n 1. Approve \n 2. Not approve ");
			int choice = reader.nextInt();

			String approbation = "";

			if(choice == 1){

				approbation = "Approve";

			}else{
				
				approbation = "Not approve";
			}

			controller.approveKnowledgeUnit(capsule-1, approbation);
		}

	}


	 /**
	 * Description: method that allows to show capsules of knowledge
	 */
	public void showAllKnowledgeUnits() {

		System.out.println("This is the information that the programm save");

		String research = controller.getAllKnowledgeUnits();

		if(research.equals("")){

			System.out.println("There is nothing save");

		}else{

			System.out.println(research);
		}
		
	}

}