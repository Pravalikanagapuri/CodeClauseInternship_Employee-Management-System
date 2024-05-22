import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        System.out.println("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Employee Position: ");
        String position = scanner.nextLine();
        System.out.println("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(id, name, position, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void updateEmployee() {
        System.out.println("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
        System.out.println("Enter new Employee Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new Employee Position: ");
        String position = scanner.nextLine();
        System.out.println("Enter new Employee Salary: ");
        double salary = scanner.nextDouble();
        employee.setName(name);
        employee.setPosition(position);
        employee.setSalary(salary);
        System.out.println("Employee updated successfully!");
    }

    public void deleteEmployee() {
        System.out.println("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
        employees.remove(employee);
        System.out.println("Employee deleted successfully!");
    }

    public void markAttendance() {
        System.out.println("Enter Employee ID to mark attendance: ");
        int id = scanner.nextInt();
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
        employee.incrementAttendance();
        System.out.println("Attendance marked for " + employee.getName());
    }

    public void calculatePayroll() {
        for (Employee employee : employees) {
            double totalPay = employee.getSalary() * employee.getAttendance();
            System.out.println("Total pay for " + employee.getName() + " is: " + totalPay);
        }
    }

    private Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Mark Attendance");
            System.out.println("6. Calculate Payroll");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    markAttendance();
                    break;
                case 6:
                    calculatePayroll();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.menu();
    }
}
