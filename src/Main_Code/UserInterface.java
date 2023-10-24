package Main_Code;

import Employees.Employee;
import Employees.ID;
import Employees.Rank;
import Employees.SecurityGuard;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    List<Employee> allEmployees = new ArrayList<>();
    List<Rank> allRanks = new ArrayList<>();
    List<ID> allIDs = new ArrayList<>();
    List<SecurityGuard> allSecurity = new ArrayList<>();
    Rank employee = new Rank("Employee", 2000);
    Rank teamLeader = new Rank("Team Leader", 3000);
    Rank groupLeader = new Rank("Group Leader", 5000);
    Rank manager = new Rank("Manager", 7500);

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            addRanks();
            options();
            int uInput = Integer.parseInt(scanner.nextLine());

            if (uInput == 20) {
                saveWarningBeforeExciting(scanner);
                System.out.println("If you really wanna end the program, type 20");
                int Input = Integer.parseInt(scanner.nextLine());
                if (Input == 20) {
                    break;
                }
            }
            if (uInput == 1) {
                creatingEmployee();
            }
            if (uInput == 2) {
                promotingSomeone();
            }
            if (uInput == 3) {
                addingAListThroughAFileTxTAndCSV();
            }
            if (uInput == 4) {
                creatingAFileWithTheExistingListOfEmployees();
            }
            if (uInput == 5) {
                modifyingARank();
            }
            if (uInput == 6) {
                creatingSecurityGuard();
            }
            if (uInput == 13) {
                printSecurityGuard();
            }
            if (uInput == 14) {
                printRanks();
            }
            if (uInput == 15) {
                printEmployees();
            }
        }
    }

    public void addRanks() {
        allRanks.add(employee);
        allRanks.add(teamLeader);
        allRanks.add(groupLeader);
        allRanks.add(manager);
    }

    public void options() {
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

    public void saveWarningBeforeExciting(Scanner scanner) {
        System.out.println("Did you save your progress? if you end the program, you will lose all your progress");
        System.out.println("If you wanna create a TXT or CSV with the existing list of employees, type 4");
        int Input = Integer.parseInt(scanner.nextLine());
        if (Input == 4) {
            creatingAFileWithTheExistingListOfEmployees();
        }
    }

    public void creatingEmployee() {
        System.out.println("What is the name of the Employee?");
        String NameOfNewEmployee = scanner.nextLine();
        Employee newEmployee = new Employee(NameOfNewEmployee, teamLeader);
        System.out.println("Choose a starting Rank!");
        System.out.println("Select between: ");
        for (Rank ranks : allRanks) {
            System.out.println(ranks);
        }
        System.out.println("(Write the Rank you want to select)");
        String userSelectedRank = scanner.nextLine();
        for (Rank rankOfNewEmployee : allRanks) {
            if (rankOfNewEmployee.getNameOfRank().equals(userSelectedRank)) {
                newEmployee.setRank(rankOfNewEmployee);
            }
        }
        allEmployees.add(newEmployee);
        System.out.println(newEmployee.getName() + " was created!");
    }

    public void promotingSomeone() {
        System.out.println("Who do you want to promote?");
        String uName = scanner.nextLine();
        for (Employee promotingEmployee : allEmployees) {
            if (promotingEmployee.getName().equals(uName)) {
                System.out.println("To what do you wanna promote " + promotingEmployee.getName() + "?");
                String promotion = scanner.nextLine();
                for (Rank g : allRanks) {
                    if (g.getNameOfRank().equals(promotion)) {
                        promotingEmployee.setRank(g);
                    }
                }
            }
        }
    }

    public void addingAListThroughAFileTxTAndCSV() {
        System.out.println("Which file do you wanna add? (only .txt and .csv for now and don't forget the .txt or .csv)");
        String fileName = scanner.nextLine();

        try (Scanner filePath = new Scanner(Paths.get(fileName))) {
            while (filePath.hasNextLine()) {
                String row = filePath.nextLine();

                String[] parts = row.split(",");
                String name = parts[0];
                String rank = parts[1];

                for (Rank comparingRank : allRanks) {
                    if (comparingRank.getNameOfRank().equals(rank)) {
                        Employee second = new Employee(name, comparingRank);
                        allEmployees.add(second);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void creatingAFileWithTheExistingListOfEmployees() {
        System.out.println("What do you wanna name the file?");
        String nameOfFile = scanner.nextLine();
        System.out.println("Do you want it to be excel or txt?");
        String endingOfFile = scanner.nextLine();
        try {
            while (true) {
                if (endingOfFile.equals("excel")) {
                    endingOfFile = "csv";
                    break;
                } else if (endingOfFile.equals("txt")) {
                    endingOfFile = "txt";
                    break;
                } else {
                    System.out.println("this file type is not supported yet!");
                }
            }
            File fileOfEmployees = new File(nameOfFile + "." + endingOfFile);
            if (fileOfEmployees.createNewFile()) {
                System.out.println("New file created copying Employees into the file now");
                for (Employee name : allEmployees) {
                    String nameOfName = name.getName();
                    Rank rank = name.getRank();
                    double salary = rank.getSalary();
                    String nameOfRank = rank.getNameOfRank();
                    Files.writeString(Path.of(fileOfEmployees.toURI()), nameOfName + ", Rank: " + nameOfRank + ", Salary: " + salary);
                }
                System.out.println("Finished! file is ready at: " + fileOfEmployees.toURI());
            } else {
                System.out.println("file already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }

    public void modifyingARank() {
        System.out.println("Which Rank do you wanna modify?");
        for (Rank modifyingRank : allRanks) {
            System.out.println(modifyingRank);
        }
        String rankName = scanner.nextLine();
        for (Rank comparingRank : allRanks) {
            if (comparingRank.getNameOfRank().equals(rankName)) {
                System.out.println("What do you want to modify (Name or Salary)");
                String modify = scanner.nextLine();
                if (modify.equals("Salary")) {
                    System.out.println("To what do you wanna change the Salary?");
                    int change = Integer.parseInt(scanner.nextLine());
                    comparingRank.changeSalary(change);
                    break;
                } else if (modify.equals("Name")) {
                    System.out.println("To what do you wanna change the Name?");
                    String name = scanner.nextLine();
                    comparingRank.changeName(name);
                    break;
                }
            } else {
                System.out.println("Please confirm that you wrote the name correct! (Employee, Team Leader, Group Leader and Manager");
            }
        }
    }

    public void creatingSecurityGuard() {
        while (true) {
            if (allIDs.isEmpty()) {
                System.out.println("Give the ID a number");
                String iDNumber = scanner.nextLine();
                System.out.println("Now give it a rank (1-5) this defines in what places the guard can go. 5 is in every even really important places. 1 is only Employee Offices and Security Room");
                int iDRank = Integer.parseInt(scanner.nextLine());
                ID first = new ID(iDRank, iDNumber);
                allIDs.add(first);
                System.out.println("ID created");
            } else {
                System.out.println("Which ID do you want to use? (Type the Number)");
                for (ID first : allIDs) {
                    System.out.println(first);
                }
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

    public void printSecurityGuard() {
        for (SecurityGuard printingSecurityGuard : allSecurity) {
            System.out.println(printingSecurityGuard);
        }
    }

    public void printEmployees() {
        for (Employee printingEmployee : allEmployees) {
            System.out.println(printingEmployee);
        }
    }

    public void printRanks() {
        for (Rank printingRank : allRanks) {
            System.out.println(printingRank);
        }
    }
}
