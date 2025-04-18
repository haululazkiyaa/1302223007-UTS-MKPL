package lib;

public class TaxData {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int monthsWorked;
    private int annualDeductible;
    private boolean isMarried;
    private int numberOfChildren;

    public TaxData(int monthlySalary, int otherMonthlyIncome, int monthsWorked,
                   int annualDeductible, boolean isMarried, int numberOfChildren) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.monthsWorked = monthsWorked;
        this.annualDeductible = annualDeductible;
        this.isMarried = isMarried;
        this.numberOfChildren = Math.min(numberOfChildren, 3); // max 3 anak
    }

    // Getters
    public int getMonthlySalary() { return monthlySalary; }
    public int getOtherMonthlyIncome() { return otherMonthlyIncome; }
    public int getMonthsWorked() { return monthsWorked; }
    public int getAnnualDeductible() { return annualDeductible; }
    public boolean isMarried() { return isMarried; }
    public int getNumberOfChildren() { return numberOfChildren; }
}
