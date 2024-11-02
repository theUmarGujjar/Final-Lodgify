package RestaurantManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class FoodItem {
    private String name;
    private ArrayList<SizePriceQuantity> sizePriceQuantities;

    // Constructors
    FoodItem() {
        this("no name", new ArrayList<>(5));
    }

    FoodItem(String name, ArrayList<SizePriceQuantity> sizePriceQuantities) {
        setName(name);
        setSizePriceQuantities(sizePriceQuantities);
    }

    // Copy constructor
    FoodItem(FoodItem foodItem) {
        this(foodItem.getName(), new ArrayList<>(foodItem.sizePriceQuantities));
    }

    // Getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim().toLowerCase();
    }

    public ArrayList<SizePriceQuantity> getSizePriceQuantities() {
        return sizePriceQuantities;
    }

//  functions
    public void setSizePriceQuantities(ArrayList<SizePriceQuantity> sizePriceQuantities) {
        if (sizePriceQuantities.size() > 5) {
            throw new IllegalArgumentException("SizePriceQuantities array size must be less than 6!");
        }

        for (int i = 0; i < sizePriceQuantities.size(); i++) {
            for (int j = i + 1; j < sizePriceQuantities.size(); j++) {
                if (sizePriceQuantities.get(i).getSize().equals(sizePriceQuantities.get(j).getSize())) {
                    throw new IllegalArgumentException("Duplicate size found: " + sizePriceQuantities.get(i).getSize());
                }
            }
        }

        this.sizePriceQuantities = sizePriceQuantities;
    }

    // Get user choice method
    private int getUserChoice(String prompt, int min, int max) {
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                System.out.println(prompt);
                choice = input.nextInt();
                input.nextLine();
                if (choice < min || choice > max) {
                    throw new IllegalArgumentException("Choice must be between " + min + " and " + max);
                }
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                input.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Function that sets everything manually
    public void setEverythingManually() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter everything manually");
        System.out.println("Enter Name of item");
        setName(input.nextLine().trim().toLowerCase());

        int size = getUserChoice("How many sizes do you want to add (1-5)?", 1, 5);

        ArrayList<SizePriceQuantity> sizePriceQuantity = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    SizePriceQuantity item = new SizePriceQuantity();
                    System.out.println("Enter the size #" + (i + 1) + " --------------------");
                    item.setEveryThingManually();
                    sizePriceQuantity.add(item);
                    setSizePriceQuantities(sizePriceQuantity);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage() != null ? e.getMessage() : "Something went wrong");
                    sizePriceQuantity.remove(sizePriceQuantity.size() - 1);
                }
            }
        }
    }

    // Display method
    public void display() {
        System.out.println("Food Item Details:");
        System.out.println("Name: " + getName());
        System.out.println("Sizes, Prices, and Quantities:");

        for (SizePriceQuantity spq : sizePriceQuantities) {
            System.out.println("Size: " + spq.getSize());
            System.out.println("Price: " + spq.getPrice());
            System.out.println("Quantity: " + spq.getQuantity());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(getName()).append("\nSizes: ");

        for (SizePriceQuantity spq : sizePriceQuantities) {
            stringBuilder.append(spq.toString()).append(";");
        }

        return stringBuilder.toString();
    }
}
