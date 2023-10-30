package UserInterfacePackage;

import Employees.Employee;
import Employees.ID;
import Employees.Rank;
import Employees.SecurityGuard;

import javax.naming.Name;
import java.util.List;
import java.util.Scanner;

public class EmployeeRelated {
    public static void addEmployeeNames(List<String> namesOfEmployees, List<Employee> allEmployees) {
        for (Employee employee : allEmployees) {
            namesOfEmployees.add(employee.getName());
        }
    }

    public static void creatingEmployee(Scanner scanner, List<Employee> employees, List<Rank> allRanks, List<String> namesOfRanks, List<String> namesOfEmployees, List<Employee> allEmployees) {
        System.out.println("What is the name of the Employee?");
        String nameOfNewEmployee = scanner.nextLine();
        while (true) {
            if (nameOfNewEmployee.isEmpty()) {
                System.out.println("Please enter a name!");
                nameOfNewEmployee = scanner.nextLine();
                if (!(nameOfNewEmployee.isEmpty())) {
                    namesOfEmployees.add(nameOfNewEmployee);
                }
            } else {
                System.out.println("Choose a starting Rank!");
                System.out.println("Select between: ");
                PrintMethods.printRanks(allRanks);
                while (true) {
                    if (namesOfEmployees.contains(nameOfNewEmployee)) {}
                    String userSelectedRank = scanner.nextLine();
                    if (namesOfRanks.contains(userSelectedRank)) {
                        for (Rank rankOfNewEmployee : allRanks) {
                            if (rankOfNewEmployee.getNameOfRank().equals(userSelectedRank)) {
                                Employee newEmployee = new Employee(nameOfNewEmployee, rankOfNewEmployee);
                                employees.add(newEmployee);
                                System.out.println(newEmployee.getName() + " was created!");
                                if (allEmployees.contains(newEmployee)) {
                                    break;
                                }
                            }
                        }
                        break;
                    } else {
                        System.out.println("(Write the Rank you want to select!)");
                    }
                }
                break;
            }
        }
    }


    public static void promotingSomeone(Scanner scanner, List<Employee> allEmployees, List<Rank> allRanks) {
        System.out.println("Who do you want to promote?");
        String uName = scanner.nextLine();
        for (Employee promotingEmployee : allEmployees) {
            if (promotingEmployee.getName().equals(uName)) {
                System.out.println("To what do you wanna promote " + promotingEmployee.getName() + "?");
                PrintMethods.printRanks(allRanks);
                String promotion = scanner.nextLine();
                for (Rank g : allRanks) {
                    if (g.getNameOfRank().equals(promotion)) {
                        promotingEmployee.setRank(g);
                    }
                }
            }
        }
    }

    public static void creatingID(Scanner scanner, List<ID> allIDs) {
        System.out.println("Give the ID a number");
        String iDNumber = scanner.nextLine();
        System.out.println("Now give it a rank (1-5) this defines in what places the guard can go. 5 is in every even really important places. 1 is only Employee Offices and Security Room");
        int iDRank = Integer.parseInt(scanner.nextLine());
        ID first = new ID(iDRank, iDNumber);
        allIDs.add(first);
        System.out.println("ID created");
    }

    public static void creatingSecurityGuard(Scanner scanner, List<ID> allIDs, List<SecurityGuard> allSecurity) {
        while (true) {
            if (allIDs.isEmpty()) {
                creatingID(scanner, allIDs);
            } else {
                System.out.println("Which ID do you want to use? (Type the Number)");
                PrintMethods.printIDs(allIDs);
                String iD = scanner.nextLine();
                for (ID first : allIDs) {
                    if (first.getNumberOfID().equals(iD)) {
                        int rank = first.getRankOfID();
                        ID second = new ID(rank, iD);
                        allIDs.add(second);
                        System.out.println("Give a name for the Guard");
                        String name = scanner.nextLine();
                        System.out.println("Give the Guard a salary");
                        double salary = Integer.parseInt(scanner.nextLine());
                        SecurityGuard third = new SecurityGuard(name, salary, second);
                        allSecurity.add(third);
                        System.out.println("Guard created!");
                    } else {
                        System.out.println("Incorrect number");
                    }
                }
                break;
            }
        }
    }
}
