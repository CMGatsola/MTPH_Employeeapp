/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motorphemployeeapp;

/**
 *
 * @author cm
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // ex: EMPLOYEE
        try (Scanner scanner = new Scanner(System.in)) {            
            Employee employee = new Employee(
                    10001,
                    "Juan Dela Cruz",
                    "Software Developer",
                    25000,
                    1500,
                    1000,
                    1000
            );
            
            // ATTENDANCE
            Attendance attendance =
                new Attendance(22, 5, 12);
            
            // PAYROLL
            Payroll payroll =
                    new Payroll(employee, attendance);
            
            // PAYSLIP
            Payslip payslip =
                    new Payslip(employee, attendance);
            
            // LOGIN
            System.out.println("===== MOTORPH EMPLOYEE APP =====");
            
            System.out.print("Username: ");
            String username = scanner.nextLine();
            
            System.out.print("Password: ");
            String password = scanner.nextLine();
            
            if (username.equals("Juan_10001")
                    && password.equals("12345")) {
                
                int choice;
                
                do {
                    
                    System.out.println("\n===== HOME PAGE =====");
                    
                    System.out.println("1. Employee Data");
                    System.out.println("2. Attendance");
                    System.out.println("3. Payroll");
                    System.out.println("4. Payslip");
                    System.out.println("5. Exit");
                    
                    System.out.print("Enter Choice: ");
                    
                    choice = scanner.nextInt();
                    
                    switch (choice) {
                        
                        case 1 -> employee.displayEmployeeInfo();
                        
                        case 2 -> {
                            System.out.println("\n===== ATTENDANCE =====");
                            
                            System.out.println("Hours Remaing: " 
                                    + attendance.getHoursRemaining());
                            
                            System.out.println("Hours Worked: "
                                    + attendance.calculateHoursWorked());
                            
                            System.out.println("Overtime Pay: "
                                    + attendance.calculateOvertime());
                            
                            System.out.println("Overtime Hours: "
                                    + attendance.getOvertimeHours());
                        }
                        
                        case 3 -> payroll.processPayroll();
                        
                        case 4 -> payslip.processPayslip();                       
                        
                        case 5 -> System.out.println("Logging out...");
                        
                        default -> System.out.println("Invalid choice.");
                    }
                    
                } while (choice != 5);
                
            } else {
                
                System.out.println("Invalid login.");
            }
        }
    }
}
