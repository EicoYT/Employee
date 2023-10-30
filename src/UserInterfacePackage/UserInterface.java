package UserInterfacePackage;

import Employees.Employee;
import Employees.ID;
import Employees.Rank;
import Employees.SecurityGuard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    List<Employee> allEmployees = new ArrayList<>();
    List<String> namesOfEmployees = new ArrayList<>();
    List<Rank> allRanks = new ArrayList<>();
    List<String> namesOfRanks = new ArrayList<>();
    List<ID> allIDs = new ArrayList<>();
    List<SecurityGuard> allSecurity = new ArrayList<>();
    Rank employee = new Rank("Employee", 2000, 1);
    Rank teamLeader = new Rank("Team Leader", 3000, 2);
    Rank groupLeader = new Rank("Group Leader", 5000, 3);
    Rank manager = new Rank("Manager", 7500, 4);

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        RankRelated.addRanks(allRanks, teamLeader, groupLeader, manager, employee);
        RankRelated.addRankNames(namesOfRanks, teamLeader, groupLeader, employee, manager);
        while (true) {
            Options.ShowOptions();
            int uInput = Integer.parseInt(scanner.nextLine());

            if (uInput == 20) {
                EmployeeRelated.addEmployeeNames(namesOfEmployees, allEmployees);
                Options.saveWarningBeforeExciting(scanner, allEmployees);
                System.out.println("If you really wanna end the program, type 20");
                int Input = Integer.parseInt(scanner.nextLine());
                if (Input == 20) {//exits the program
                    break;
                }
            }
            if (uInput == 1) {//creating new employee
                EmployeeRelated.creatingEmployee(scanner, allRanks, namesOfRanks, namesOfEmployees, allEmployees);

            }
            if (uInput == 2) {//promoting someone
                while (true) {
                    if (!(allEmployees.isEmpty())) {
                        EmployeeRelated.promotingSomeone(scanner, allEmployees, allRanks, namesOfRanks, namesOfEmployees);
                        break;
                    }
                    if (allEmployees.isEmpty()) {
                        System.out.println("You have to create at least one Employee!");
                        System.out.println("Type 1 to create an Employee");
                        System.out.println("Type 2 to show options");
                        uInput = Integer.parseInt(scanner.nextLine());
                        if (uInput == 2) {
                            break;
                        }
                        if (uInput == 1) {
                            EmployeeRelated.creatingEmployee(scanner, allRanks, namesOfRanks, namesOfEmployees, allEmployees);
                        }
                    }
                }
            }
            if (uInput == 3) {//Adding a List through a File, TxT and CSV
                FileMethods.addingAListThroughAFileTxTAndCSV(scanner, allRanks, allEmployees);
            }
            if (uInput == 4) {//Creating a File with the existing list of employees
                FileMethods.creatingAFileWithTheExistingListOfEmployees(scanner, allEmployees);
            }
            if (uInput == 5) {//Modify a Rank
                RankRelated.modifyingARank(scanner, allRanks);
            }
            if (uInput == 6) {//Creating Security Guard
                EmployeeRelated.creatingSecurityGuard(scanner, allIDs, allSecurity);
            }
            if (uInput == 13) {//Prints Security Guard
                PrintMethods.printSecurityGuard(allSecurity);
            }
            if (uInput == 14) {//Prints all Ranks
                PrintMethods.printRanks(allRanks);
            }
            if (uInput == 15) {//Prints all Employees
                PrintMethods.printEmployees(allEmployees);
            }
        }
    }
}