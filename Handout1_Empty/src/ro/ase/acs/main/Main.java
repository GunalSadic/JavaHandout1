package ro.ase.acs.main;
import ro.ase.acs.models.*;

class Main {

	public static void main(String[] args) {
		//Playground
		//here you can test your code manually
		String[] parts = {"Gunal" , "Gunal2"};
		String test;
		Meeting meet = new Meeting ("Meeting", 2, 5);
		meet.setParticipants(parts);
		test = meet.getName();
		meet.PrintInfo();
		
	
		
		
		
	}

}
