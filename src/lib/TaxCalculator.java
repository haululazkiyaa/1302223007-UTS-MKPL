package lib;

public class TaxCalculator {

    public static int calculate(Employee employee) {
        int monthsWorked = employee.calculateMonthsWorkedThisYear();
        boolean married = employee.isMarried();
        int numberOfChildren = employee.getChildrenCount();

        return TaxFunction.calculateTax(
            employee.getMonthlySalary(),
            employee.getOtherMonthlyIncome(),
            monthsWorked,
            employee.getAnnualDeductible(),
            married,
            numberOfChildren
        );
    }
}
