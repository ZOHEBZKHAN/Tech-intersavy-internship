
package tempratureconversion;


import java.util.Scanner;

public class TemperatureConversionTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Conversion Tool");
        System.out.println("=*==*==*===*==*==*=*===");

        while (true) {
            System.out.println("Please Select an option:");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter temperature in Fahrenheit: ");
                double fahrenheit = scanner.nextDouble();
                double celsius = (fahrenheit - 32) * 5 / 9;
                System.out.printf("%.2f Fahrenheit = %.2f Celsius\n", fahrenheit, celsius);
            } else if (choice == 2) {
                System.out.print("Enter temperature in Celsius: ");
                double celsius = scanner.nextDouble();
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.printf("%.2f Celsius = %.2f Fahrenheit\n", celsius, fahrenheit);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }

        scanner.close();
    }
}

