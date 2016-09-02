
public class Hourly extends Employee {
	int hours;

	public Hourly(String name, int start_month, int start_year, int hours) {
		this.name = name;
		this.start_month = start_month;
		this.start_year = start_year;
		this.hours = hours;
		
		CalculateTenure();
		CalculatePayrate();
	}
	
	public void CalculatePayrate() {
		int six_months = 0;
		if(month_total >= 6) {
			six_months = 1;
		}
		payrate = 10 + 1 * year_total + six_months * .5;

	}

	@Override
	public double PayThisMonth() {
		return this.payrate * this.hours;
	}

}
