package Staff;

import java.util.Scanner;

import Administration.Room;
import HotelReceptionist.Booking;

public class Sweeper
{
    Scanner input=new Scanner(System.in);

    //method for showing room status
    public void roomStatus(){
        while(true)
        {   System.out.println();
            System.out.println("Press 1 to see the hygenic status of all Rooms : ");
            System.out.println("Press 2 to see the hygenic status of a specific Room : ");
            System.out.println("Press 3 to update the hygenic status of a specific Room");
            System.out.println("Press 0 to go exit : ");
            System.out.println("############################################################################################");

            int choice;
            if(!(input.hasNextInt())){
                System.out.println();
                System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY   ");
                System.out.println();
                input.nextLine();
                continue;
            }
            choice = input.nextInt();
            input.nextLine();
            ProgramStatus programStatus=ProgramStatus.chooseStatus(choice);
            switch (programStatus) {
                case EXIT:
                    System.out.println();
                    System.out.println("Exited Succcessfully!");
                    System.out.println("############################################################################################");
                    return;
                case SHOW_INFORMATION_OF_ALL:
                    System.out.println("------------------------Displaying Rooms Information-------------------------");
                    for(int i = 0 ; i < Booking.rLs1.size() ; i++){
                        System.out.println("Room status Room number : " + Booking.rLs1.get(i).getrNumber() + " is : " + Booking.rLs1.get(i).getrStatus());
                    }
                    System.out.println("*******************************************************************************");
                    break;
                case SHOW_INFORMATION_OF_ONE:
                    System.out.println("------------------------Displaying Selected Room's Information-------------------------");
                    showStatusForSpecificRoom();
                    System.out.println("*******************************************************************************");
                    break;
                case UPDATE_STATUS_OF_ONE:
                    System.out.println("------------------------Updating Status-------------------------");
                    updateRoomStatus();
                    System.out.println("*******************************************************************************");
                    break;

                default :
                    System.out.println("Invalid Choice!!");
                    input.nextLine();
                    System.out.println("Try Again...");
                    System.out.println();

            }
        }
    }

    //method just for showing a specific room status
    public void showStatusForSpecificRoom(){
        while(true){
            int rNumber;
            System.out.println("Enter the Room number which status you want to check : ");
            System.out.println("Enter 0 to go back : ");
            if(!(input.hasNextInt())){
                System.out.println();
                System.out.println("WRONG INPUT ::: It can only integer : ");
                System.out.println();
                input.nextLine();
                continue;
            }
            rNumber = input.nextInt();

            if(rNumber == 0){
                return;
            }
            System.out.println("((((((((((((((Result: ))))))))))))))");
            for(int i = 0 ; i < Booking.rLs1.size() ; i++){
                if(rNumber == Booking.rLs1.get(i).getrNumber()){
                    System.out.println("Room status Room number : " + Booking.rLs1.get(i).getrNumber() + " is : " + Booking.rLs1.get(i).getrStatus());
                }
                else{
                    System.out.println("There is no such room...");
                }
            }
        }
    }

    //method to update room status

    public void updateRoomStatus()
    {
        while(true)
        {
            int number;
            System.out.println("Enter the Room number which status you want to update : ");
            System.out.println("Enter 0 to go back : ");

            if(!(input.hasNextInt())){
                System.out.println();
                System.out.println("WRONG INPUT ::: It can only integer : ");
                System.out.println();
                input.nextLine();
                continue;
            }

            number = input.nextInt();
            input.nextLine();

            if(number == 0){
                break;
            }

            //loop to show the status of the Room.
            for(int i = 0 ; i < Booking.rLs1.size() ; i++){
                if(Booking.rLs1.get(i).getrNumber() == number){

                    System.out.println("Current Room status is : "+ Booking.rLs1.get(i).getrStatus());
                    String rStatus ;
                    System.out.println("Enter the new hygienic status of that Room : ");
                    rStatus = input.nextLine();
                    Booking.rLs1.get(i).setrStatus(rStatus);
                    System.out.println("((((((((((((((Result: ))))))))))))))");
                    System.out.println("Room Status Updated to : "+ Booking.rLs1.get(i).getrStatus());
                    return;
                }
                else{
                    System.out.println("There is no such room...");
                }
            }
        }
    }
}


    
