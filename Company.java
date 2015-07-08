package emulationOrg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Company {
	private Director director;
	private List<IWorker> programmers;
	private List<IWorker> designer;
	private List<IWorker> testers;
	private List<IWorker> managers;
	private List<IWorker> accountants;
	private List<Thread> threads;
	
	public Company(Director d) {
		programmers = new ArrayList<IWorker>();
		designer = new ArrayList<IWorker>();
		testers = new ArrayList<IWorker>();
		managers = new ArrayList<IWorker>();
		accountants = new ArrayList<IWorker>();
		threads = new ArrayList<Thread>();
		director = d;
	}
	
	public void addWorker(IWorker w){
		switch(w.getId()){
		case 0 : 
			programmers.add(w);
			break;
		case 1 :
			designer.add(w);
			break;
		case 2 : 
			testers.add(w);
			break;
		case 3 : 
			managers.add(w);
			break;
		case 4 : 
			accountants.add(w);
			break;
		default : System.err.println("Unknow proffesion id : " + w.getId());
		}
	}
	
	/*
	 The work of each employee of the company is carried out in a separate thread.
	 It is created and run threads.
	*/
	public void toWork() {
		Thread t;
		for(IWorker w : programmers){
			t = new Thread(w);
			t.start();
			threads.add(t);
		}
		
		for(IWorker w : designer){
			t = new Thread(w);
			t.start();
			threads.add(t);
		}
		
		for(IWorker w : testers){
			t = new Thread(w);
			t.start();
			threads.add(t);
		}
		
		for(IWorker w : managers){
			t = new Thread(w);
			t.start();
			threads.add(t);
		}
		
		for(IWorker w : accountants){
			t = new Thread(w);
			t.start();
			threads.add(t);
		}

	}

}
