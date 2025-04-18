package lib;

public class TaxCalculator {
    public static int calculate(Employee employee) {
        TaxData data = new TaxData(
            employee.getMonthlySalary(),
            employee.getOtherMonthlyIncome(),
            employee.calculateMonthsWorkedThisYear(),
            employee.getAnnualDeductible(),
            employee.isMarried(),
            employee.getChildrenCount()
        );
    
        return TaxFunction.calculateTax(data);
    }
}
