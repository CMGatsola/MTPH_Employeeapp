/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorphemployeeapp;

/**
 *
 * @author cm
 */
public class Employee {

    private int employeeId;
    private String fullName;
    private String position;

    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;

    // CONSTRUCTOR
    public Employee(int employeeId,
                    String fullName,
                    String position,
                    double basicSalary,
                    double riceSubsidy,
                    double phoneAllowance,
                    double clothingAllowance) {

        this.employeeId = employeeId;
        this.fullName = fullName;
        this.position = position;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
    }

    public void displayEmployeeInfo() {

        System.out.println("===== EMPLOYEE INFO =====");
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + fullName);
        System.out.println("Position: " + position);
        System.out.println("Basic Salary: " + basicSalary);
    }

    // getter
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }
}