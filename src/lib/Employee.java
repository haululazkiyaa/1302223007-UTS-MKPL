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
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	// ======================= START REFACTORING 2 : PrimitiveObsession =======================
	// Class Employee terlalu banyak menggunakan tipe data primitif (int, boolean, String) 
	// untuk menyimpan data yang semestinya bisa dikelompokkan dalam objek atau enum.
	
	public enum Gender {
		MALE, FEMALE
	}
	
	private LocalDate joinedDate;
	private Gender gender;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
                int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, Gender gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.joinedDate = LocalDate.of(yearJoined, monthJoined, dayJoined);
		this.isForeigner = isForeigner;
		this.gender = gender;

		childNames = new LinkedList<>();
		childIdNumbers = new LinkedList<>();
	}

	// ======================= END REFACTORING 2 : PrimitiveObsession =======================
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
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
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	// ======================= START REFACTORING 1 : LongMethod =======================
	// Method getAnnualIncomeTax() terlalu panjang, sebaiknya dipecah menjadi beberapa method kecil

	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		monthWorkingInYear = calculateMonthsWorkedThisYear();

		return TaxFunction.calculateTax(
			monthlySalary,
			otherMonthlyIncome,
			monthWorkingInYear,
			annualDeductible,
			isMarried(),
			childIdNumbers.size()
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
		return spouseIdNumber != null && !spouseIdNumber.equals("");
	}

	// ======================== END REFACTORING 1 : LongMethod ========================
}
