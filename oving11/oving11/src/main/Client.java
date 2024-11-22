package main;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Client {
    private final PropertyRegistry pr = new PropertyRegistry();
    private final Scanner sc = new Scanner(System.in);
    private final MunicipalityLoader loader = new MunicipalityLoader();

    Map<Integer, String> municipalities = loader.loadMunicipalities();

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     *         If 0 is returned, the user has entered a wrong value
     */
    private int showMenu() {
        int menuChoice = 0;
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Calculate average area");
        System.out.println("5. Search for a property by lot number");
        System.out.println("6. Get a municipality by code");
        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");
        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
            sc.nextLine();
        }

        else {
            System.out.println("You must enter an integer");
            sc.nextLine();
        }
        return menuChoice;
    }

    public void start() {
        boolean running = true;

        do {
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case 1 -> addProperty();

                case 2 -> listProperties();

                case 3 -> searchPropertyById();

                case 4 -> calculateAverageArea();

                case 5 -> searchPropertyByLotNo();

                case 6 -> municipalityByCode();

                case 9 -> {
                    System.out.println("Exiting");
                    running = false;
                }

                default -> System.out.println("Error, try again");
            }
        } while (running);

        sc.close();
    }

    private void addProperty() {
        int munNo = -1;
        int lotNo = -1;
        int secNo = -1;
        double area = -1.0;
        String ownerName = null;

        try {
            System.out.println("Please enter the municipality number of the property");
            munNo = sc.nextInt();
            sc.nextLine();
            if (munNo <= 0) throw new IllegalArgumentException("Municipality number must be positive.");

            System.out.println("Please enter the lot number");
            lotNo = sc.nextInt();
            sc.nextLine();
            if (lotNo <= 0) throw new IllegalArgumentException("Lot number must be positive.");

            System.out.println("Please enter the section number");
            secNo = sc.nextInt();
            sc.nextLine();
            if (secNo <= 0) throw new IllegalArgumentException("Section number must be positive.");

            System.out.println("Please enter the area");
            area = sc.nextDouble();
            sc.nextLine();
            if (area <= 0) throw new IllegalArgumentException("Area must be a positive number.");

            System.out.println("Please enter the owner's name");
            ownerName = sc.nextLine();
            if (ownerName.isEmpty()) throw new IllegalArgumentException("Owner name cannot be empty.");

            // Add property to PropertyRegistry
            pr.addProperty(munNo, lotNo, secNo, area, ownerName);
            System.out.println("Property successfully registered");

            String propertyId = munNo + "-" + lotNo + "/" + secNo;
            System.out.println(pr.getProperty(propertyId));

            System.out.println("Does the property have a name? (yes/no)");
            if (sc.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("What is the name?");
                pr.getProperty(propertyId).setName(sc.nextLine());
            } else {
                System.out.println("OK");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
            sc.nextLine(); // Clear the invalid input from the scanner buffer
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }   

    private void listProperties() {
        System.out.println("All registered properties:");
        System.out.println(pr); // Assuming pr.toString() lists all properties
    }

    private void searchPropertyById() {
        System.out.println("Enter the ID of the property you're looking for (MunicipalityNo-LotNo/SectionNo):");
        String propertyId = sc.nextLine();
        System.out.println(pr.getProperty(propertyId));
    }

    private void calculateAverageArea() {
        System.out.println("Average area of registered properties is:");
        System.out.println(pr.getAreaMean() + " square meters");
    }

    private void searchPropertyByLotNo() {
        System.out.println("Please enter the lot number you're interested in:");
        int lotNo = sc.nextInt();
        sc.nextLine();
        System.out.println(pr.getPropertyByLotNo(lotNo));
    }

    private void municipalityByCode() {
        System.out.println("What code do you want to check for?");
        int id = sc.nextInt();
        municipalities.get(id);
        sc.nextLine();
    }

    public void addDummyProperties() {
        // Updated to include owner names as per the new constructor
        pr.addProperty(4650, 77, 631, 1017.6, "Jens Olsen");       // Jens Olsen's property
        pr.addProperty(4650, 77, 131, 661.3, "Nicolay Madsen");    // Nicolay Madsen's property
        pr.addProperty(4650, 75, 19, 650.6, "Evilyn Jensen");      // Evilyn Jensen's property
        pr.addProperty(4650, 74, 188, 1457.2, "Karl Ove Bråten");  // Karl Ove Bråten's property
        pr.addProperty(4650, 69, 47, 1339.4, "Elsa Indregård");    // Elsa Indregård's property
    }
}
