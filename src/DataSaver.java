import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean continueEntering = true;
        while (continueEntering) {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter ID Number (6 digits): ");
            String idNumber = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Year of Birth: ");
            String yearOfBirth = scanner.nextLine();

            String record = String.format("%s, %s, %s, %s, %s", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);

            System.out.print("Add another record? (yes/no): ");
            String response = scanner.nextLine();
            continueEntering = response.equalsIgnoreCase("yes");
        }

        System.out.print("Enter the filename to save records (.csv will be added): ");
        String fileName = scanner.nextLine() + ".csv";

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data saved to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
