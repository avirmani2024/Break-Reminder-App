import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter break length in minutes: ");
        int breakLength = scanner.nextInt();
        System.out.print("Enter break frequency in minutes: ");
        int breakFrequency = scanner.nextInt();

        BreakReminderApp app = new BreakReminderApp(breakLength, breakFrequency);
        app.startSchedule();

        System.out.println("Press 's' to stop the schedule or 'q' to quit.");
        while (true) {
            String input = scanner.next();
            if (input.equals("s")) {
                app.stopSchedule();
            } 
            else if (input.equals("q")) {
                if (app.isRunning()) {
                    app.stopSchedule();
                }
                break;
            }
        }

        scanner.close();
    }
}
