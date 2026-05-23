/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorphemployeeapp;

/**
 *
 * @author cm
 */
public class Payslip {

    private Employee employee;
    private Attendance attendance;
    private Deductions deductions;

    // CONSTRUCTOR
    public Payslip(Employee employee,
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

    public void processPayslip() {

        System.out.println("===== PAYSLIP =====");

        double gross = calculateGrossSalary();
        double net = calculateNetSalary();

        System.out.println("Employee: "
                + employee.getFullName());

        System.out.println("Gross Salary: " + gross);

        System.out.println("Net Salary: " + net);
    }
}
