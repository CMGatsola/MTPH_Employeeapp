package motorphemployeeapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    private static boolean loggedIn = false;

    public static void main(String[] args) {

        // LOGIN PANEL
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        JPanel loginPanel = new JPanel(new GridLayout(2, 2));

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);

        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(
                null,
                loginPanel,
                "MotorPH Login",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // SIMPLE LOGIN
            if (username.equals("Juan_10001")
                    && password.equals("12345")) {

                loggedIn = true;

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Invalid username or password!",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );

                System.exit(0);
            }

        } else {

            System.exit(0);
        }

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

        JButton logoutButton =
                new JButton("Logout");

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
        frame.add(logoutButton);

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

        // LOGOUT BUTTON
        logoutButton.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to logout?",
                        "Logout",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    loggedIn = false;

                    JOptionPane.showMessageDialog(
                            frame,
                            "Logged out successfully."
                    );

                    frame.dispose();

                    main(null);
                }
            }
        });
    }
}
