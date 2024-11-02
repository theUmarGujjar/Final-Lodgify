package Administration;

import java.util.Scanner;

public class Admin {


  static EmployeeManager emp = new EmployeeManager();

  public static void selection() {
    System.out.println("Press 1 to add  ");
    System.out.println("Press 2 to remove ");
    System.out.println("Press 3 to update");
    System.out.println("Press 0 to exit");
    System.out.println("############################################################################################");

  }

  public static int getValidIntInput(String prompt) {
    System.out.println(prompt);
    while (!input.hasNextInt()) { 
      System.out.println("Invalid input.You must enter an integer.");
      input.nextLine(); 
    }
    return input.nextInt();
  }

  // car related
  static CarManager carManager = new CarManager();
  static Scanner input = new Scanner(System.in);
  static int id;
  static String L_plateno;
  static String model;

  public static void showingCars() {

    int num = getValidIntInput("If you want to see the details of  car enter 1 .Enter 2 to go back");
    input.nextLine();
    if (num == 1) {
      System.out.println("These cars are available");
      carManager.displayCars();
    } else if (num == 2)
      return;
  }

  public static void takeCarinfo() {

    // taking info about cars from user

    System.out.println("Enter the details of car ");
    id = getValidIntInput("id :");
    input.nextLine();
    System.out.println("Model :");
    model = input.nextLine();
    System.out.println("Lisence plate number :");
    L_plateno = input.nextLine();
    return;

  }

  public void addEmp() {

  }

  // room related
  static RoomManager roomManager = new RoomManager();
  static int rNumber;
  static int rPrice;
  static String rType;
  static int rBeds;
  static String rStatus;
  static String rFloor;
  static String rAvailability;
  public static Object roomlist;

  public static void showingRooms() {

    int num = getValidIntInput("If you want to see details of rooms enter 1.Enter 2 to go back ");
    input.nextLine();
    if (num == 1) {
      System.out.println("These rooms are available");
      roomManager.displayRooms();
    } else if (num == 2)
      return;
  }

  public static void takeRoominfo() {

    // taking info aboutroomsfrom user

    System.out.println("Enter the details of room ");
    rNumber = getValidIntInput("Room number: ");
    input.nextLine();
    rPrice = getValidIntInput("Room price : ");
    input.nextLine();
    System.out.println("Room type : ");
    rType = input.nextLine();
    rBeds = getValidIntInput("Number of beds : ");
    input.nextLine();
    System.out.println("room status : ");
    rStatus = input.nextLine();
    System.out.println("room Floor : ");
    rFloor = input.nextLine();
    System.out.println("room availablility : ");
while(true){    
  System.out.println("You can only enter yes / no");

  rAvailability = input.nextLine();

  if(!(rAvailability.equals("yes") || rAvailability.equals("no"))){
      
    System.out.println("Invalid input ");
    System.out.println("Enter again");    
  }
else{
  break;
}
}
  
      
    

  }

  public static void adminMain() {
    System.out.println("##################################### Welcome to Admin Portal #####################################");

    boolean mainLoop = true;
    while (mainLoop) {
      System.out.println("which of the following do you want to manage");
      System.out.println("For cars enter 1");
      System.out.println("For employees enter 2 ");
      System.out.println("For rooms enter 3 ");
      System.out.println("Enter 0 to exit ");
      System.out.println("############################################################################################");


      String num = input.nextLine();

      switch (num) {
        case "1":
          boolean run = true;
          while (run) {
            System.out.println("##################################### Cars #####################################");

            selection();// selection of operation like add remove update
            String choice = input.nextLine();

            if (choice.equals("1")) {
              int n = getValidIntInput("How many cars do you want to add?");
              input.nextLine();
              for (int i = 0; i < n; i++) {
                takeCarinfo();
                Car c = new Car(id, model, L_plateno);
                carManager.addCar(c);
              }
              showingCars();

            } else if (choice.equals("2")) {
              // removing car
              int no = getValidIntInput("How many cars do you want to remove?");
              input.nextLine();

              for (int i = 0; i < no; i++) {
                int id = getValidIntInput("enter the id of car you want to remove");
                input.nextLine();

                // Car c=new Car();
                carManager.removeCar(id);
              }
              showingCars();

            } else if (choice.equals("3")) {
              // updating car
              int n = getValidIntInput("enter the number of cars you want to update");
              input.nextLine();

              for (int i = 0; i < n; i++) {
                takeCarinfo();
                carManager.updateCar(id, model, L_plateno);

              }
              showingCars();

            } else if (choice.equals("0")) {
              System.out.println("exiting");
              run = false;

            } else {
              System.out.println("invalid choice");
              System.out.println("select again and you can only enter integer");

            }
          }
          break;
        case "2":
        System.out.println("##################################### Employees #####################################");

          boolean go = true;
          while (go) {

            System.out.println("Press 1 to add  ");
            System.out.println("Press 2 to remove");
            System.out.println("Press 3 to update");
            System.out.println("Press 4 to display");
            System.out.println("Press 0 to exit");
            System.out.println("############################################################################################");

            String choice = input.nextLine();

            if (choice.equals("1")) {
              int no = getValidIntInput("How many employees do you want to add");
              input.nextLine();
              for (int i = 0; i < no; i++) {
                emp.selectEmployee("add");
              }

            } else if (choice.equals("2")) {
              // removing employee
              int no = getValidIntInput("How many employees do you want to remove");
              input.nextLine();

              for (int i = 0; i < no; i++) {

                emp.selectEmployee("remove");
              }

            } else if (choice.equals("3")) {
              // updating employee
              int no = getValidIntInput("How many employees do you want to update");
              input.nextLine();

              for (int i = 0; i < no; i++) {
                emp.selectEmployee("update");
              }

            } else if (choice.equals("4")) {
              emp.displayEmployee();

            } else if (choice.equals("0")) {
              System.out.println("exiting");
              go = false;

            } else {
              System.out.println("invalid choice");
              System.out.println("select again and you can only enter integer");

            }
          }
          break;
        case "3":
        System.out.println("##################################### Rooms #####################################");

          boolean move = true;
          while (move) {
            selection();
            String choice = input.nextLine();

            if (choice.equals("1")) {
              // adding rooms
              int n = getValidIntInput("How many rooms do you want to add");
              input.nextLine();

              for (int i = 0; i < n; i++) {
                takeRoominfo();
                Room room = new Room(rNumber, rPrice, rType, rBeds, rStatus, rFloor, rAvailability);
                roomManager.addRoom(room);
              }
              showingRooms();

            } else if (choice.equals("2")) {
              // removing rooms

              int no = getValidIntInput("How many rooms do you want to remove?");
              input.nextLine();

              for (int i = 0; i < no; i++) {
                int rNumber = getValidIntInput("Enter the number of room you want to remove?");
                input.nextLine();

                roomManager.removeRoom(rNumber);
              }
              showingRooms();

            } else if (choice.equals("3")) {
              // updating car
              System.out.println(
                  "You can reset the room price, room type and number of beds in a room after giving its room number ");
              int n = getValidIntInput("How many rooms do you want to update");
              input.nextLine();

              for (int i = 0; i < n; i++) {

                rNumber = getValidIntInput("Room number :");
                input.nextLine();
                System.out.println("enter new details");
                rPrice = getValidIntInput("Room price :");
                input.nextLine();
                System.out.println("Room type : ");
                rType = input.nextLine();
                rBeds = getValidIntInput("Number of beds :");
                input.nextLine();
                roomManager.updateRooms(rNumber, rPrice, rType, rBeds);

              }
              showingRooms();

            } else if (choice.equals("0")) {
              System.out.println("exiting");
              move = false;

            } else {
              System.out.println("invalid choice");
              System.out.println("select again and you can only enter integer");

            }
          }
          break;
        case "0": // Exit option
          System.out.println("############################################################################################");
          mainLoop = false;
          break;

        default:
          System.out.println("invalid selection.Enter integer");
          break;
      }

    }
  }

}