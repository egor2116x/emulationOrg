package emulationOrg;

import java.util.Date;

public class Designer extends IWorker {
	
	private Director director;
	private Accountant accountant;
	
	public Designer(int id, int number, int sh, Director director, Accountant accountant) {
		super(id, number);
		this.director = director;
		this.accountant = accountant;
		salaryHour = sh; //Salary per hour
		salaryTotal = 0; //Salary per month
		nowFunction = null; //The current job
	}

	@Override
	public void toWork() {
		run();
	}

	@Override
	public void run() {	
		long t = (new Date(System.currentTimeMillis())).getTime();
		time = (new Date(System.currentTimeMillis())).getTime();
		delta = (new Date(System.currentTimeMillis())).getTime();
		while(exitThread){ // main loop
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
					salaryTotal += (salaryHour * nowFunction.getTime());
					System.out.println("desin number : " + number + " func id : " + nowFunction.getId() + " to work ended " + " time " +
								nowFunction.getTime() + " salary : " + salaryTotal + "$");
					nowFunction = null;
					delta = new Date(System.currentTimeMillis()).getTime();
			}
			//The output from the stream at the end of one month and data transmission accountant
			if(((new Date(System.currentTimeMillis())).getTime() - time) / 1000 >= timeMonth){
				exitThread = false;
				System.out.println("Desin number " + number + " Month ended");
				accountant.setEndWork();
				accountant.getDataWorker(this);
			}
		}
	}

}

