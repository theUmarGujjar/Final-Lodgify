package Test;

import java.util.Scanner;

import Administration.Admin;
import HotelReceptionist.Booking;
import RestaurantManagement.Restaurant;
import Staff.Run;

public class Test {
 public static void main (String [] args){

    //printing of LODGIFY......
    
            int width = 50;  // Width of the box
            int height = 7;  // Height of the box
            String text = " WELCOME TO LODGIFY ";
            
            // Calculate the row and starting column for the text
            int textRow = height / 2;  // Middle row for the text
            int textStartCol = (width - text.length()) / 2;  // Center text horizontally
    
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                        System.out.print("#");
                    } 
                    else if (i == textRow && j >= textStartCol && j < textStartCol + text.length()) {
                        System.out.print(text.charAt(j - textStartCol));
                    } 
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println();  // Move to the next line after each row
            }
    System.out.println();
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Check In for a Stay, Dine In for Delight! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println();


    
    while (true) {
        System.out.println("****************************************************************************************************************************");
        System.out.println();

        Scanner input = new Scanner(System.in);
        int number;
        System.out.println("                                Press 1 to sign in as an admin : ");
        System.out.println("                                Press 2 to sign in as an HotelReceptionist : ");
        System.out.println("                                Press 3 to sign in as an Restutant Receptionist : ");
        System.out.println("                                Press 4 to sign in as staff member : ");
        System.out.println("                                Press 0 to exit : ");
        System.out.println();
        System.out.println("****************************************************************************************************************************");


        number = input.nextInt();
        if(number == 1){
            Admin.adminMain();
        }
        else if (number == 2) {
            Booking.bookingMain();
        }
        else if (number == 3){
            Restaurant.resturantMain();
        }
        else if(number==4){
            Run.staffMain();
        }
        else if(number == 0){
            System.out.println("*******************************************************************************");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("*******************************************************************************");
            break;
        }
        else{
            System.out.println("Wrong Input ..");
            System.out.println("Press the new number : ");
        }
    
    }
 }    
    
}
