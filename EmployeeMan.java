import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No command provided!");
            return;
        }

        String command = args[0];

        // Command: l  (Load and list all employees)
        if (command.equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                String[] employees = line.split(",");

                for (String emp : employees) {
                    System.out.println(emp.trim());
                }

                reader.close();
            } catch (Exception e) {
                System.out.println("Error loading data.");
            }
            System.out.println("Data Loaded.");

        }
        // Command: s (Show raw string of all employees)
        else if (command.equals("s")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                System.out.println(line);

                reader.close();
            } catch (Exception e) {
                System.out.println("Error loading data.");
            }
            System.out.println("Data Loaded.");

        }
        // Command: +name  (Add new employee)
        else if (command.startsWith("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt", true)
                );

                String name = command.substring(1);
                writer.write(", " + name);

                writer.close();
            } catch (Exception e) {
                System.out.println("Error adding employee.");
            }
            System.out.println("Data Loaded.");

        }
        // Command: ?name  (Search employee)
        else if (command.startsWith("?")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                String[] employees = line.split(",");

                String search = command.substring(1);
                boolean found = false;

                for (String emp : employees) {
                    if (emp.trim().equals(search)) {
                        System.out.println("Employee found!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Employee NOT found!");
                }

                reader.close();
            } catch (Exception e) {
                System.out.println("Error searching employee.");
            }
            System.out.println("Data Loaded.");

        }
        // Command: c (count words and characters)
        else if (command.equals("c")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                int wordCount = line.split(",").length;
                int charCount = line.length();

                System.out.println(wordCount + " word(s) found, " + charCount + " characters.");

                reader.close();
            } catch (Exception e) {
                System.out.println("Error counting data.");
            }
            System.out.println("Data Loaded.");

        }
        // Command: uName (Update employee name to "Updated")
        else if (command.startsWith("u")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                String[] employees = line.split(",");
                String search = command.substring(1);

                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].trim().equals(search)) {
                        employees[i] = "Updated";
                    }
                }

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt")
                );

                writer.write(String.join(",", employees));

                writer.close();
                reader.close();
            } catch (Exception e) {
                System.out.println("Error updating employee.");
            }

            System.out.println("Data Updated.");

        }
        // Command: dName (delete employee)
        else if (command.startsWith("d")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                List<String> list = new ArrayList<>(Arrays.asList(line.split(",")));

                String name = command.substring(1);
                list.removeIf(emp -> emp.trim().equals(name));

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt")
                );

                writer.write(String.join(",", list));

                writer.close();
                reader.close();
            } catch (Exception e) {
                System.out.println("Error deleting employee.");
            }

            System.out.println("Data Deleted.");

        } else {
            System.out.println("Invalid command!");
        }
    }
}
