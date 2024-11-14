import java.util.*;
import java.text.*;

public class TravelItineraryPlanner {
    
    // Inner class to represent a travel destination
    static class Destination {
        String name;
        Date startDate;
        Date endDate;
        String activity;
        double budget;

        public Destination(String name, Date startDate, Date endDate, String activity, double budget) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
            this.activity = activity;
            this.budget = budget;
        }

        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return "Destination: " + name + "\n" +
                   "Dates: " + dateFormat.format(startDate) + " to " + dateFormat.format(endDate) + "\n" +
                   "Activity: " + activity + "\n" +
                   "Budget: $" + budget + "\n";
        }
    }

    private static List<Destination> itinerary = new ArrayList<>();

    // Function to input travel details from the user
    public static void inputTravelDetails() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();

        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDateStr = scanner.nextLine();
        Date startDate = null;
        try {
            startDate = dateFormat.parse(startDateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Using default date.");
            startDate = new Date();
        }

        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDateStr = scanner.nextLine();
        Date endDate = null;
        try {
            endDate = dateFormat.parse(endDateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Using default date.");
            endDate = new Date();
        }

        System.out.print("Enter preferred activity for the destination (e.g., sightseeing, adventure): ");
        String activity = scanner.nextLine();

        System.out.print("Enter estimated budget for the trip: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline

        // Add the destination to the itinerary
        itinerary.add(new Destination(name, startDate, endDate, activity, budget));
    }

    // Function to display the full itinerary
    public static void displayItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("No itinerary created.");
            return;
        }

        double totalBudget = 0;
        System.out.println("\nYour Travel Itinerary:");
        for (Destination destination : itinerary) {
            System.out.println(destination);
            totalBudget += destination.budget;
        }

        System.out.println("Total estimated budget: $" + totalBudget);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuePlanning = true;

        while (continuePlanning) {
            System.out.println("\nTravel Itinerary Planner:");
            System.out.println("1. Add a new destination");
            System.out.println("2. View itinerary");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    inputTravelDetails();
                    break;
                case 2:
                    displayItinerary();
                    break;
                case 3:
                    continuePlanning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thanks for using the Travel Itinerary Planner!");
    }
}
