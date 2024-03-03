import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter file name: ");
        Scanner scnr = new Scanner(System.in);
        String file = scnr.nextLine();

        Map<String, Integer> nameCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                nameCount.put(line.toLowerCase(), nameCount.getOrDefault(line.toLowerCase(), 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("Error in opening file");
        }

        scnr.close();
    }
}
