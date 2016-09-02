
public class Salaried extends Employee {

	public Salaried(String name, int start_month, int start_year) {
		this.name = name;
		this.start_month = start_month;
		this.start_year = start_year;
		
		CalculateTenure();
		CalculatePayrate();
	}
	
	public void CalculatePayrate() {
		payrate = 20000 + 2000 * year_total;
		
	}

	@Override
	public double PayThisMonth() {
		return this.payrate/12;
	}

}
