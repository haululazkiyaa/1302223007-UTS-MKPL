package lib;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	// private int yearJoined;
	// private int monthJoined;
	// private int dayJoined;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	// private boolean gender; //true = Laki-laki, false = Perempuan
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	// private String spouseName;
	// private String spouseIdNumber;

	// private List<String> childNames;
	// private List<String> childIdNumbers;
	
	public enum Gender {
		MALE, FEMALE
	}
	
	private LocalDate joinedDate;
	private PersonalInfo.Gender gender;

	private Spouse spouse;
	private List<Child> children;

	
	public Employee(PersonalInfo info) {
		this.employeeId = info.getEmployeeId();
		this.firstName = info.getFirstName();
		this.lastName = info.getLastName();
		this.idNumber = info.getIdNumber();
		this.address = info.getAddress();
		this.joinedDate = info.getJoinedDate();
		this.isForeigner = info.isForeigner();
		this.gender = info.getGender();

		children = new LinkedList<>();
	}

	
	public void setMonthlySalary(int grade) {
		int baseSalary;
	
		switch (grade) {
			case 1: baseSalary = 3000000; break;
			case 2: baseSalary = 5000000; break;
			case 3: baseSalary = 7000000; break;
			default:
				throw new IllegalArgumentException("Invalid grade: " + grade);
		}
	
		if (isForeigner) {
			baseSalary *= 1.5;
		}
	
		monthlySalary = baseSalary;
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}

	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouse = new Spouse(spouseName, spouseIdNumber);
	}	

	public void addChild(String childName, String childIdNumber) {
		children.add(new Child(childName, childIdNumber));
	}

	public int getAnnualIncomeTax() {
		return TaxCalculator.calculate(this);
	}	

	public int getMonthlySalary() {
		return monthlySalary;
	}
	
	public int getOtherMonthlyIncome() {
		return otherMonthlyIncome;
	}
	
	public int getAnnualDeductible() {
		return annualDeductible;
	}
	
	public int getChildrenCount() {
		return children.size(); // Sudah refactor dari childNames dan childIdNumbers
	}	

	public int calculateMonthsWorkedThisYear() {
		LocalDate now = LocalDate.now();
		if (now.getYear() == joinedDate.getYear()) {
			return now.getMonthValue() - joinedDate.getMonthValue();
		} else {
			return 12;
		}
	}
	
	public boolean isMarried() {
		return spouse != null && spouse.getIdNumber() != null && !spouse.getIdNumber().equals("");
	}	
}
