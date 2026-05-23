/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorphemployeeapp;

/**
 *
 * @author cm
 */
public class Payroll {

    private Employee employee;
    private Attendance attendance;
    private Deductions deductions;

    // CONSTRUCTOR
    public Payroll(Employee employee,
                   Attendance attendance) {

        this.employee = employee;
        this.attendance = attendance;
        this.deductions = new Deductions();
    }

    public double calculateGrossSalary() {

        double grossSalary =
                employee.getBasicSalary()
                + employee.getRiceSubsidy()
                + employee.getPhoneAllowance()
                + employee.getClothingAllowance()
                + attendance.calculateOvertime();

        return grossSalary;
    }

    public double calculateNetSalary() {

        double grossSalary = calculateGrossSalary();

        double totalDeductions =
                deductions.calculateTotalDeductions(grossSalary);

        return grossSalary - totalDeductions;
    }

 public void processPayroll() {

    System.out.println("===== PAYROLL =====");

    double overtimePay = attendance.calculateOvertime();

    double gross = calculateGrossSalary();
    double net = calculateNetSalary();

    System.out.println("Employee: "
            + employee.getFullName());

    System.out.println("Basic Salary: "
            + employee.getBasicSalary());

    System.out.println("Rice Subsidy: "
            + employee.getRiceSubsidy());

    System.out.println("Phone Allowance: "
            + employee.getPhoneAllowance());

    System.out.println("Clothing Allowance: "
            + employee.getClothingAllowance());

    System.out.println("Overtime Pay: "
            + overtimePay);

    System.out.println("Gross Salary: "
            + gross);

    System.out.println("Net Salary: "
            + net);
}
}