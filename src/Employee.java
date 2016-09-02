import java.util.Calendar;

//Hourly, Manager, and Salaried classes inherit from Employee
public abstract class Employee {
	static int id = 1;
	int empid;
	String name;
	int start_month;
	int start_year;
	double payrate;
	int month_total;
	int year_total;
	
	// Each employee has a unique employee id
	public Employee() {
		this.empid = id;
		id += 1;
	}
	
	// An employee's payrate is determined by their employee type and their tenure. 
	public abstract void CalculatePayrate();
	
	// Calculates how much an employee gets paid this month.
	public abstract double PayThisMonth();
	
	// Calculates number of years and months the employee has been with the company
	public void CalculateTenure() {
		Calendar cal = Calendar.getInstance();
		int today_month = cal.get(Calendar.MONTH) + 1;
		int today_year = cal.get(Calendar.YEAR);
		
		int partial_year = 0;
		
		// If the current month is less than their starting month, they're in a "partial year"
		if(today_month < start_month) {
			partial_year = 1;
		}
		
		int year_total = today_year - start_year - partial_year;
		int month_total = today_month - start_month + (12*partial_year);
		this.month_total = month_total;
		this.year_total = year_total;
		
	}
	
	public void PrintTenure() {
		System.out.println("Year total: " + year_total + "      Month total: " + month_total);
	}
	
	public static void main(String[] args) {
		
		// Mark, John, and Craig are employees under manager Bob
		Hourly mark = new Hourly("Mark Brunner", 5, 2015, 40);
		Hourly john = new Hourly("John Kautzner", 9, 2015, 15);
		Salaried craig = new Salaried("Craig Graves", 7, 2012);
		
		Employee[] bobs = new Employee[] {mark, john, craig};
	
		Manager bob = new Manager("Bob Bluedorn", 2, 2010, bobs, 5000);
		
		
		// Nick, Josh, and manager Bob are employees under manager Jerry
		Salaried nick = new Salaried("Nick Dee", 11, 2009);
		Salaried josh = new Salaried("Josh Trbovich", 3, 2011);
		
		Employee[] jerrys = new Employee[] {bob, nick, josh};
		
		Manager jerry = new Manager("Jerry Sanchez", 10, 2006, jerrys, 15000);
		
		
		System.out.println("$" + bob.CalculateBonus());
		//System.out.println(bob.EmployeePay());
		
		//System.out.println(3348 + 3516 + 3083 + 2833);
		
		System.out.println("$" + jerry.CalculateBonus());

	}

}


/*
Employee Types:  Managers, Hourly, Salary

Managers
	id
	name
	date of hire
	underlings
	payrate
	
	method: calculate pay
	method: change underling hours/payrate?

Hourly/Salary
	id
	name
	date of hire
	payrate
	
	method: calculate pay

*/