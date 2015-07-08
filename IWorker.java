package emulationOrg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//The abstract base class for all employees.

public abstract class IWorker implements Runnable {
	protected List<Function> functions; //functional responsibilities
	protected Queue<Function> functionality; //The queue of tasks to perform
	protected int id; //id profession
	protected int number; //id employee
	protected Function nowFunction; //the current task to perform
	protected int salaryHour;
	protected int salaryTotal;
	protected boolean exitThread; //output from the stream
	protected long time;
	protected long timeMonth; //number of hours per month
	protected long delta;
	protected int countWork; //amount of work done
	protected static int npp = 0; //Number of employees in order to print the report.
	
	public IWorker(int id, int number) {
		functions = new ArrayList<Function>();
		functionality = new LinkedList<Function>();
		this.id = id;
		this.number = number;
		exitThread = true;
		timeMonth = 160;
		countWork = 0;
	}
	
	public void addFunction(Function f){
		functions.add(f);
	}
	
	public void addFunctionality(Function f){
		functionality.add(f);
	}
	
	public Queue<Function> getFunctionality() {
		return functionality;
	}
	
	public List<Function> getFunctions() {
		return functions;
	}
	
	public int getId() {
		return id;
	}
	
	public int getNumber() {
		return number;
	}
	
	public Function getNowFunction() {
		return nowFunction;
	}
	
	
	public void setSalaryHour(int salaryHour) {
		this.salaryHour = salaryHour;
	}
	
	public void setSalaryTotal(int salaryTotal) {
		this.salaryTotal = salaryTotal;
	}
	
	public int getSalaryHour() {
		return salaryHour;
	}
	
	public int getSalaryTotal() {
		return salaryTotal;
	}
	
	public void setExitThread(boolean exitThread) {
		this.exitThread = exitThread;
	}
	
	public boolean isExitThread() {
		return exitThread;
	}
	
	@Override
	public String toString(){
		++npp;
		return Integer.toString(npp)+ "\t" + Integer.toString(number) + "\t\t" + Integer.toString(id) + "\t\t" +
				Integer.toString(countWork) + "\t\t\t" + Integer.toString(salaryTotal) + "\n";
	}
	
	public abstract void toWork();
}
