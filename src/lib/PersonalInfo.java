package lib;

import java.time.LocalDate;

public class PersonalInfo {
	public enum Gender {
		MALE, FEMALE
	}

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private LocalDate joinedDate;
    private boolean isForeigner;
    private Gender gender;

    public PersonalInfo(String employeeId, String firstName, String lastName,
                        String idNumber, String address, int yearJoined, int monthJoined, int dayJoined,
                        boolean isForeigner, Gender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.joinedDate = LocalDate.of(yearJoined, monthJoined, dayJoined);
        this.isForeigner = isForeigner;
        this.gender = gender;
    }

    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getIdNumber() { return idNumber; }
    public String getAddress() { return address; }
    public LocalDate getJoinedDate() { return joinedDate; }
    public boolean isForeigner() { return isForeigner; }
    public Gender getGender() { return gender; }
}
