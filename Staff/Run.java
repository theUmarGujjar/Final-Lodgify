package Staff;

import java.util.Scanner;

public class Run 
{
    public static void staffMain() 
    {
        Scanner input = new Scanner(System.in);
        int type;
        

        //entering program
        
        System.out.println("##################################### Welcome to Staff Portal #####################################");
        System.out.println();
                
                
        // asking employee category 
        while(true)
        {
            System.out.println("Are you a Driver or a Sweeper?");
            System.out.println("Press 1 for Driver\nPress 2 for Sweeper\nPress 0 to exit ");
            System.out.println("############################################################################################");
            System.out.println();

            if(!(input.hasNextInt())){
                System.out.println();
                System.out.println("WRONG INPUT ::: It can only integer : ");
                System.out.println();
                input.nextLine();
                continue;
            }
            type=input.nextInt();
            input.nextLine();
            System.out.println();
            switch (type) {
                case 0:
                    System.out.println("############################################################################################");
                    return;
                case 1:
                    System.out.println("------------------------Driver Portal-------------------------");
                    Driver driver = new Driver();
                    driver.showCarData();
                    break;
                case 2:
                    System.out.println("------------------------Sweeper Portal-------------------------");
                    Sweeper sweeper = new Sweeper();
                    sweeper.roomStatus();
                    break;
                default:
                    System.out.println("Invalid Input!!!!");
                    System.out.println("Please enter from given numbers.");
                    System.out.println();
                    continue;
                                
            }
            break;                    
                    
        }

            
                    

    }
}   
        
