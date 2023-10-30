package UserInterfacePackage;

import Employees.Employee;
import Employees.Rank;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileMethods {
    public static void addingAListThroughAFileTxTAndCSV(Scanner scanner, List<Rank> allRanks, List<Employee> allEmployees) {
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
                        System.out.println("Employees added");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void creatingAFileWithTheExistingListOfEmployees(Scanner scanner, List<Employee> allEmployees) {
        System.out.println("What do you wanna name the file?");
        String nameOfFile = scanner.nextLine();
        System.out.println("Do you want it to be excel or txt?");
        String endingOfFile = scanner.nextLine();
        try {
            while (true) {
                if (endingOfFile.equals("excel")) {
                    endingOfFile = "csv";
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
}
