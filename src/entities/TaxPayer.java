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
		super();
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
		double salarioMensal = salaryIncome / 12;
		double imposto = 0;

		if (salarioMensal < 3000.0) {
			imposto = 0;
		} else if (salarioMensal < 5000.0) {
			imposto = salaryIncome * 10 / 100;
		} else {
			imposto = salaryIncome * 20 / 100;
		}
		return imposto;

	}

	public double servicesTax() {
		double impostoServicos = 0.0;
		if (servicesIncome > 0.0) {
			impostoServicos = servicesIncome * 15 / 100;
		}
		return impostoServicos;
	}

	public double capitalTax() {
		double impostoCapital = 0;

		if (capitalIncome > 0.0) {
			impostoCapital = capitalIncome * 20 / 100;
		}
		return impostoCapital;

	}
	
	public double grossTax() {
		
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double condicaoAbatimento = grossTax() * 30 / 100;
		double abatimento = 0;
		
		if (condicaoAbatimento > healthSpending + educationSpending) {
			abatimento = healthSpending + educationSpending;
		} else {
			abatimento = grossTax() * 30 / 100;
		}
				
		return abatimento;
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}

}













