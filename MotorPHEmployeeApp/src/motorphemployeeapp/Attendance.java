/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorphemployeeapp;

/**
 *
 * @author cm
 */
public class Attendance {

    private int daysWorked;
    private double overtimeHours;
    private double hoursRemaining;

    public Attendance(int daysWorked,
                      double overtimeHours,
                      double hoursRemaining) {

        this.daysWorked = daysWorked;
        this.overtimeHours = overtimeHours;
        this.hoursRemaining = hoursRemaining;
    }

    public double calculateHoursWorked() {

        return daysWorked * 8;
    }

    public double calculateOvertimepay() {

        return overtimeHours * 200;
    }

    public double gethoursRemaining() {

        return hoursRemaining;
    }
    
    public double getOvertimeHours() {

    return overtimeHours;
    }
}
