package model;

public class Controller {

	private KnowledgeUnit[] units;

	public Controller() {

		units = new KnowledgeUnit[25];
		testCases();

	}
	
	public void testCases() {
		
		units[0] = new KnowledgeUnit("A001", "Gestion de repositorios", "Tecnico", "GitHub es una herramienta util");
		units[1] = new KnowledgeUnit("A002", "Gestion de equipos", "Experiencias", "Es importante definir responsabilidades claras");
		
	}


	public boolean registerKnowledgeUnit(String id, String description, String type, String learnedLesson) {

		KnowledgeUnit newKnowledgeUnit = new KnowledgeUnit(id, description, type, learnedLesson);

		for(int i=0; i < units.length; i++){

			if(units[i] == null){

				units[i] = newKnowledgeUnit;
				return true;
			}
		}
		return false;
	}


	public void approveKnowledgeUnit(int id, String approbation) {

		units[id].setStatus(approbation);

	}

	public String searchKnowledgeUnite(){

		String msg = "";

		for(int i = 0; i < units.length; i++ ){

			if(units[i]!=null){
                msg += "\n"+ (i+1) + ". " + units[i].getId();
            }
		}

		return msg;
	}


	public String getAllKnowledgeUnits() {

		String msg = "";

		for(int i = 0; i < units.length; i++ ){

			if(units[i]!=null){
                msg += "\n" + units[i].toString();
            }
		}

		return msg;

	}

}
