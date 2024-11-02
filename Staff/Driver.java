package Staff;

import java.util.ArrayList;
import java.util.Scanner;

import Administration.Car;
import Administration.CarManager;

public class Driver
{   
    
    Scanner input=new Scanner(System.in);

    public void showCarData(){
        while(true){
            System.out.println();
            System.out.println("Press 1 to check all cars' information");
            System.out.println("Press 2 to check a specific car's information");
            System.out.println("Press 3 to update a specific car's status");
            System.out.println("Press 0 to exit");
            System.out.println("############################################################################################");

            int choice;
            if(!(input.hasNextInt())){
                System.out.println();
                System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
                System.out.println();
                input.nextLine();
                continue;
            }
            
            choice = input.nextInt();
            input.nextLine();
            ProgramStatus programStatus=ProgramStatus.chooseStatus(choice);
            switch (programStatus)
            {
                case EXIT:
                    System.out.println();
                    System.out.println("Exited Succcessfully!");
                    System.out.println("############################################################################################");

                    return;
                case SHOW_INFORMATION_OF_ALL:
                    ArrayList<Car> carlist=CarManager.getCarList();
                    System.out.println("------------------------Displaying Cars Information-------------------------");
                    for(Car car:carlist){
                        car.displayinfo();
                    }
                    System.out.println("*******************************************************************************");
                    break;

                    
                case SHOW_INFORMATION_OF_ONE:
                    System.out.println("------------------------Displaying Selected Car's Information-------------------------");
                    showOneCarData();
                    System.out.println("*******************************************************************************");
                    break;
                    
                case UPDATE_STATUS_OF_ONE:
                System.out.println("------------------------Updating Status-------------------------");
                    updateCarStatus();
                    System.out.println("*******************************************************************************");
                    break;
                    
                default:
                    System.out.println("Invalid Choice!!");
                    input.nextLine();
                    System.out.println("Try Again...");
                    System.out.println();
                    break;
            }
        }


    }

    public void showOneCarData(){
        while(true){
            int carNumber;
            System.out.println("Enter the Car ID whose information you want to check : ");
            System.out.println("Enter 0 to go back : ");
            if(!(input.hasNextInt())){
                System.out.println();
                System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
                System.out.println();
                input.nextLine();
                continue;
            }
            carNumber = input.nextInt();
            input.nextLine();

            if(carNumber == 0){
                return;
            }
            System.out.println("((((((((((((((Result: ))))))))))))))");
            for(Car car1: CarManager.carlist){
                if(carNumber==car1.getId()){
                    System.out.println("Information of Car ID : " + car1.getId() + " is :" );
                    car1.displayinfo();
                }
                System.out.println("There is no such car...");
            }
        }
    }

    public void updateCarStatus(){
        while(true){
            int number;
            System.out.println("Enter the car ID whose status you want to update : ");
            System.out.println("Enter 0 to go back : ");

            if(!(input.hasNextInt())){
                System.out.println();
                System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY   ");
                System.out.println();
                input.nextLine();
                continue;
            }

            number = input.nextInt();
            input.nextLine();

            if(number == 0){
                break;
            }
            for(Car car1:CarManager.carlist){
                if(number==car1.getId()){
                    System.out.println();
                    System.out.println("Current Status of Car "+ car1.getId()+" is "+car1.getAvailability());
                    String availibility ;
                    System.out.println("Enter the updated status of that Car : ");
                    availibility = input.nextLine();
                    car1.setAvailability(availibility);
                    System.out.println("((((((((((((((Result: ))))))))))))))");
                    System.out.println("Status Updated to : " + car1.getAvailability());
                    return;
                }
                else{
                    System.out.println("There is no such car...");
                }
            }
        }
    }
}
