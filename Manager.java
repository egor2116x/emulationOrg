package emulationOrg;

import java.util.Date;

public class Manager extends IWorker {
	
	private Director director;
	private Accountant accountant;
	
	public Manager(int id, int number, int salaryMonth, Director director, Accountant accountant) {
		super(id, number);
		this.director = director;
		this.accountant = accountant;
		salaryHour = 0; 
		salaryTotal = salaryMonth; //Salary per month.  Fixed rate
		nowFunction = null;
	}

	@Override
	public void run() {
		long t = (new Date(System.currentTimeMillis())).getTime();
		time = (new Date(System.currentTimeMillis())).getTime();
		delta = (new Date(System.currentTimeMillis())).getTime();
		while(exitThread){ //main loop
			//At any time after receipt of the new job of director
			if(nowFunction == null && !functionality.isEmpty()){
				nowFunction = functionality.peek();
				functionality.remove(nowFunction);
			}
			else{
				if(((new Date(System.currentTimeMillis())).getTime() - t) / 1000 > 2){
					functionality.add(director.getFunction(id));
					t = (new Date(System.currentTimeMillis())).getTime();
				}
			}
			//mission complete	
			if(nowFunction != null && ((new Date(System.currentTimeMillis())).getTime() - delta) / 1000 > nowFunction.getTime()){
				++countWork;
				System.out.println("manager number : " + number + " func id : " + nowFunction.getId() + " to work ended " + " time :" +
								nowFunction.getTime() + " salary : " + salaryTotal + "$");
				nowFunction = null;
				delta = new Date(System.currentTimeMillis()).getTime();
			}
			//The output from the stream at the end of one month and data transmission accountant
			if(((new Date(System.currentTimeMillis())).getTime() - time) / 1000 >= timeMonth){
				exitThread = false;
				System.out.println("Manag number " + number + " Month ended");
				accountant.setEndWork();
				accountant.getDataWorker(this);
			}
		}
	}

	@Override
	public void toWork() {
		run();
	}

}
