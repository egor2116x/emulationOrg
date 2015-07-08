package emulationOrg;

import java.util.Random;

public class Director extends IWorker {
	private Random rand;
	
	public Director(int id, int namber, int salaryMonth) {
		super(id, namber);
		rand = new Random();
		salaryTotal = salaryMonth; //Salary per month. Fixed rate
	}
	//Issuance of jobs depending on the profession
	public Function getFunction(int id){
		int timeRand = rand.nextInt(3) + 1;
		String s = "unknow";
		if(id == 0)
			s = "programming";
		else if(id == 1)
			s = "desing";
		else if(id == 2)
			s = "testing";
		else if(id == 3)
			s = "managment";
		else if(id == 4)
			s = "accounting";
		
		return new Function(id, s, timeRand);
	}
	
	@Override
	public void toWork(){
		run();
	}

	@Override
	public void run() {}

}
