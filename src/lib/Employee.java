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
		if (grade == 1) {
			monthlySalary = 3000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}else if (grade == 2) {
			monthlySalary = 5000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}else if (grade == 3) {
			monthlySalary = 7000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}
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
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		monthWorkingInYear = calculateMonthsWorkedThisYear();

		return TaxFunction.calculateTax(
			monthlySalary,
			otherMonthlyIncome,
			monthWorkingInYear,
			annualDeductible,
			isMarried(),
			children.size()
		);
	}

	private int calculateMonthsWorkedThisYear() {
		LocalDate now = LocalDate.now();
		if (now.getYear() == joinedDate.getYear()) {
			return now.getMonthValue() - joinedDate.getMonthValue();
		} else {
			return 12;
		}
	}
	
	private boolean isMarried() {
		return spouse != null && spouse.getIdNumber() != null && !spouse.getIdNumber().equals("");
	}	
}
