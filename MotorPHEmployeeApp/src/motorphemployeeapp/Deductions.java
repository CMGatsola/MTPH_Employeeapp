/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorphemployeeapp;

/**
 *
 * @author cm
 */
public class Deductions {

    public double calculateSSS(double grossSalary) {

        return grossSalary * 0.05;
    }

    public double calculatePhilHealth(double grossSalary) {

        return grossSalary * 0.03;
    }

    public double calculatePagIbig(double grossSalary) {

        return 100;
    }

    public double calculateTax(double grossSalary) {

        return grossSalary * 0.10;
    }

    public double calculateTotalDeductions(double grossSalary) {

        double total =
                calculateSSS(grossSalary)
                + calculatePhilHealth(grossSalary)
                + calculatePagIbig(grossSalary)
                + calculateTax(grossSalary);

        return total;
    }
}