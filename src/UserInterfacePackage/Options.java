package UserInterfacePackage;

import Employees.Employee;

import java.util.List;
import java.util.Scanner;

public class Options {
    public static void ShowOptions() {
        System.out.println("What do you wanna do?");
        System.out.println("Type 1 to create one new Employee");
        System.out.println("Type 2 to promote someone");
        System.out.println("Type 3 to add a list of Employees from a file (please follow: name,rank example: Hans,Team Leader in the TxT or CSV)");
        System.out.println("Type 4 to create a txt file with the existing list of employees");
        System.out.println("Type 5 to Modify a Rank");
        System.out.println("Type 6 to create a new Security Guard");
        System.out.println("Type 13 to see all Security Guards and their Security Number");
        System.out.println("Type 14 to see all Ranks and their default Salary's");
        System.out.println("Type 15 to see a list of all Employees");
        System.out.println("Type 20 to end the Program");
    }

    public static void saveWarningBeforeExciting(Scanner scanner, List<Employee> allEmployees) {
        System.out.println("Did you save your progress? if you end the program, you will lose all your progress");
        System.out.println("If you wanna create a TXT or CSV with the existing list of employees, type 4");
        int Input = Integer.parseInt(scanner.nextLine());
        if (Input == 4) {
            FileMethods.creatingAFileWithTheExistingListOfEmployees(scanner, allEmployees);
        }
    }
}
