package motorphemployeeapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cm
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    public static void main(String[] args) {

        // CREATE FRAME
        JFrame frame =
                new JFrame("MotorPH Employee App");

        // TITLE
        JLabel titleLabel =
                new JLabel("MotorPH Employee System");

        // BUTTONS
        JButton employeeButton =
                new JButton("Employee Data");

        JButton attendanceButton =
                new JButton("Attendance");

        JButton payrollButton =
                new JButton("Payroll");

        JButton payslipButton =
                new JButton("Payslip");

        JButton clearButton =
                new JButton("Clear");

        // TEXT AREA
        JTextArea outputArea =
                new JTextArea(15, 30);

        outputArea.setEditable(false);

        JScrollPane scrollPane =
                new JScrollPane(outputArea);

        // LAYOUT
        frame.setLayout(new FlowLayout());

        frame.add(titleLabel);

        frame.add(employeeButton);
        frame.add(attendanceButton);
        frame.add(payrollButton);
        frame.add(payslipButton);
        frame.add(clearButton);

        frame.add(scrollPane);

        // FRAME SETTINGS
        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        // SAMPLE OBJECTS
        Employee employee =
                new Employee(
                        10001,
                        "Juan Dela Cruz",
                        "Software Developer",
                        25000,
                        1500,
                        1000,
                        1000
                );

        Attendance attendance =
                new Attendance(22, 5, 12);

        Payroll payroll =
                new Payroll(employee, attendance);

        Payslip payslip =
                new Payslip(employee, attendance);

        // EMPLOYEE BUTTON
        employeeButton.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                outputArea.setText(
                        "===== EMPLOYEE DATA =====\n"
                        + "ID: "
                        + employee.getEmployeeId()
                        + "\nName: "
                        + employee.getFullName()
                        + "\nPosition: "
                        + employee.getPosition()
                        + "\nBasic Salary: "
                        + employee.getBasicSalary()
                );
            }
        });

        // ATTENDANCE BUTTON
        attendanceButton.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                outputArea.setText(
                        "===== ATTENDANCE =====\n"
                        + "Hours Worked: "
                        + attendance.calculateHoursWorked()
                        + "\nOvertime Hours: "
                        + attendance.getOvertimeHours()
                        + "\nOvertime Pay: "
                        + attendance.calculateOvertimepay()
                        + "\nHours Remaining: "
                        + attendance.gethoursRemaining()
                );
            }
        });

        // PAYROLL BUTTON
        payrollButton.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    double gross =
                            payroll.calculateGrossSalary();

                    double net =
                            payroll.calculateNetSalary();

                    outputArea.setText(
                            "===== PAYROLL =====\n"
                            + "Gross Salary: "
                            + gross
                            + "\nNet Salary: "
                            + net
                    );

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Payroll Error!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // PAYSLIP BUTTON
        payslipButton.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                outputArea.setText(
                        "===== PAYSLIP =====\n"
                        + "Employee: "
                        + employee.getFullName()
                        + "\nGross Salary: "
                        + payroll.calculateGrossSalary()
                        + "\nNet Salary: "
                        + payroll.calculateNetSalary()
                );
            }
        });

        // CLEAR BUTTON
        clearButton.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                outputArea.setText("");
            }
        });
    }
}
