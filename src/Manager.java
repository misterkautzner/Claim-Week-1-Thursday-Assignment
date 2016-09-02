
public class Manager extends Employee {
	private static final Class<? extends Employee> Manager = null;
	Employee[] employees;
	int monthly_budget;

	public Manager(String name, int start_month, int start_year, Employee[] employees, int monthly_budget) {
		this.name = name;
		this.start_month = start_month;
		this.start_year = start_year;
		this.employees = employees;
		this.monthly_budget = monthly_budget;
		
		CalculateTenure();
		CalculatePayrate();
	}
	
	public void CalculatePayrate() {
		payrate = 20000 + year_total * 2000 + employees.length * 1500;

	}
	
	public int CalculateBonus() {
		int bonus;
		bonus = (int) (.1*(monthly_budget - Math.ceil(EmployeePay())));
		return bonus;
	}
	
	public double EmployeePay() {
		double total_pay = 0;
		for(Employee emp: employees) {
			total_pay += emp.PayThisMonth();
			
			if(emp.getClass() == Manager) {
				total_pay += ((Manager) emp).EmployeePay();
			}
		}

		
		return total_pay;
	}
	
	// Add Method to notice if an employee under the manager is a manager
	// If so, figure out that manager's EmployeePay and add it to this one's

	@Override
	public double PayThisMonth() {
		return this.payrate/12 + CalculateBonus();
	}
}

