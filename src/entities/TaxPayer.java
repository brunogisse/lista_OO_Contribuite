package entities;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer() {

	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	@Override
	public String toString() {
		return "TaxPayer [salaryIncome=" + salaryIncome + ", servicesIncome=" + servicesIncome + ", capitalIncome="
				+ capitalIncome + ", healthSpending=" + healthSpending + ", educationSpending=" + educationSpending
				+ "]";
	}

	public double salaryTax() {
		double monthlySalary = salaryIncome / 12;
		double imposto = 0;

		if (monthlySalary < 3000.0) {
			imposto = 0;
		} else if (monthlySalary < 5000.0) {
			imposto = salaryIncome * 10 / 100;
		} else {
			imposto = salaryIncome * 20 / 100;
		}
		return imposto;

	}

	public double servicesTax() {
		double servTax = 0.0;
		if (servicesIncome > 0.0) {
			servTax = servicesIncome * 15 / 100;
		}
		return servTax;
	}

	public double capitalTax() {
		double capTax = 0;

		if (capitalIncome > 0.0) {
			capTax = capitalIncome * 20 / 100;
		}
		return capTax;

	}

	public double grossTax() {

		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double rabateCondition = grossTax() * 30 / 100;
		double rebate = 0;

		if (rabateCondition > healthSpending + educationSpending) {
			rebate = healthSpending + educationSpending;
		} else {
			rebate = grossTax() * 30 / 100;
		}

		return rebate;
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}

}
