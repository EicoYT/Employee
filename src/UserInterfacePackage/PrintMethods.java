package UserInterfacePackage;

import Employees.Employee;
import Employees.ID;
import Employees.Rank;
import Employees.SecurityGuard;

import java.util.List;

public class PrintMethods {
    public static void printSecurityGuard(List<SecurityGuard> list) {
        for (SecurityGuard printingSecurityGuard : list) {
            System.out.println(printingSecurityGuard);
        }
    }

    public static void printEmployees(List<Employee> list) {
        for (Employee printingEmployee : list) {
            System.out.println(printingEmployee);
        }
    }

    public static void printRanks(List<Rank> list) {
        for (Rank printingRank : list) {
            System.out.println(printingRank);
        }
    }

    public static void printIDs(List<ID> allIDs) {
        for (ID first : allIDs) {
            System.out.println(first);
        }
    }
}
