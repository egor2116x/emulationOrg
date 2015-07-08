package emulationOrg;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Accountant extends IWorker {

	private Director director;
	private String report; // line for reporting
	private File file; // the object file for the report
	private PrintWriter out;
	private int countWorkersTotal; //contains the total number of employees in addition to the director and accountant
	private int countWorkersNow; //It contains a number of employees who have worked one month
	
	public Accountant(int id, int number, int salaryMonth, Director director, int countWorkers) {
		super(id, number);
		this.director = director;
		salaryTotal = salaryMonth; //Salary per month. Fixed rate
		nowFunction = null;
		this.countWorkersTotal = countWorkers;
		countWorkersNow = 0;

		report = "# ID worker\tID prof\tAmount work\tSalary\n"; // The header of the report
	}
	//the employee receives the data for the formation of rows of the report
	public void getDataWorker(IWorker w){
		report += w.toString();
	}
	
	public void setEndWork(){
		++countWorkersNow;
	}
	//Formation of the file name, and print a report
	public void printReport(){
		System.out.println("Print report");
		Date d = new Date();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("rep");
		stringBuilder.append(d.getDay());
		stringBuilder.append(d.getMonth());
		stringBuilder.append(d.getYear());
		stringBuilder.append(d.getHours());
		stringBuilder.append(d.getMinutes());
		stringBuilder.append(d.getSeconds());
		file = new File(stringBuilder.toString() + ".rep");
		try{
			if(!file.exists())
				file.createNewFile();
			
			out = new PrintWriter(file.getAbsoluteFile());
			out.print(report);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
		finally {
			out.close();
		}
	}

	@SuppressWarnings("deprecation")
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
				++countWork; //Amount of work done
				System.out.println("accountant number : " + number + " func id : " + nowFunction.getId() + " to work ended " + " time :" +
								nowFunction.getTime() + " salary : " + salaryTotal + "$");
				nowFunction = null;
				delta = new Date(System.currentTimeMillis()).getTime();
			}
			//The output from the stream after all the employees have completed their work
			if(countWorkersTotal == countWorkersNow){
				exitThread = false;
				System.out.println("Accoun number " + number + " Month ended");
				printReport(); //printing report
			}
		}
	}

	@Override
	public void toWork() {
		run();
	}

}
