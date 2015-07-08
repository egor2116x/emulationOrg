package emulationOrg;

/*
 	04.07.2015 Olekhnovich Y.V. Test task from QATestLab
	The main application class.
	The entry point to the application.
	Create all existing objects.
	Modeling of the company to scale 1hour: 1sec
*/

public class emulationOrg {

	public static void main(String args[])
	{
		// Creation of the company's employees
	   Director director = new Director(4, 0, 20000);
	   Accountant accountant = new Accountant(4, 11, 7500, director, 10);
	   
	   IWorker p1 = new Programmer(0, 1, 50, director, accountant);
	   IWorker p2 = new Programmer(0, 2, 50, director, accountant);
	   IWorker p3 = new Programmer(0, 3, 50, director, accountant);
	   
	   IWorker d1 = new Designer(1, 4, 40, director, accountant);
	   IWorker d2 = new Designer(1, 5, 40, director, accountant);
	   IWorker d3 = new Designer(1, 6, 40, director, accountant);
	   
	   IWorker t1 = new Tester(2, 7, 35, director, accountant);
	   IWorker t2 = new Tester(2, 8, 35, director, accountant);
	   IWorker t3 = new Tester(2, 9, 35, director, accountant);
	   
	   IWorker m1 = new Manager(3, 10, 7000, director, accountant);
	   
	   //Adding functional responsibilities
	   
	   p1.addFunction(new Function(0, "programming", 3));
	   p2.addFunction(new Function(0, "programming", 3));
	   p3.addFunction(new Function(0, "programming", 3));
	   
	   d1.addFunction(new Function(1, "desing", 3));
	   d2.addFunction(new Function(1, "desing", 3));
	   d3.addFunction(new Function(1, "desing", 3));
	   
	   t1.addFunction(new Function(2, "testing", 3));
	   t2.addFunction(new Function(2, "testing", 3));
	   t3.addFunction(new Function(2, "testing", 3));
	   
	   m1.addFunction(new Function(3, "managment", 3));
	   
	   accountant.addFunction(new Function(4, "accounting", 3));
	   
	   Company com = new Company(director);
	   
	   //Adding employees
	   com.addWorker(p1);
	   com.addWorker(p2);
	   com.addWorker(p3);
	   
	   com.addWorker(d1);
	   com.addWorker(d2);
	   com.addWorker(d3);
	   
	   com.addWorker(t1);
	   com.addWorker(t2);
	   com.addWorker(t3);
	   
	   com.addWorker(m1);
	   
	   com.addWorker(accountant);
	   
	   //The launch of the company.
	   com.toWork();
	}

}
