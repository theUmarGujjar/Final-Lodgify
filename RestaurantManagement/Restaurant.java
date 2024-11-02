package RestaurantManagement;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    public static void resturantMain() {
        Menu menu = new Menu();
        ArrayList<Order> orders = new ArrayList<>();

        while(true){
            System.out.println("##################################### Welcome to Restraunt Portal #####################################");
            System.out.println("Enter 0 to exit");
            System.out.println("Enter 1 to manage Menu");
            System.out.println("Enter 2 to display Menu");
            System.out.println("Enter 3 to place order");
            System.out.println("Enter 4 to display previous orders");
            System.out.println("############################################################################################");

            int choice=getUserChoice();
            RestrauntStatus restrauntStatus=RestrauntStatus.chooseStatus(choice);
            switch (restrauntStatus){
                case EXIT:
                    System.out.println("############################################################################################");
                    return;
                case MANAGE_MENU:
                    menu.menuControl();
                    break;
                case DISPLAY_MENU:
                    System.out.println("------------------------Displaying Menu Items-------------------------");
                    menu.displayMenu();
                    break;
                case PLACE_ORDER:
                    if(menu.getMenuItems().isEmpty()){
                        System.out.println("((((((((((((((Result: ))))))))))))))");
                        System.out.println("There is no item in the menu");
                    }
                    else{
                        Order order = new Order();
                        order.manageOrders(menu);
                        if(order.isOrdered()){
                            orders.add(order);
                        }
                    }
                    break;
                case PREVIOUS_ORDERS:
                    System.out.println("------------------------Display Previous Orders -------------------------");
                    if(orders.size()==0){
                        System.out.println("no orders found");
                    }
                    else {
                        
                        for(int i=0;i<orders.size();i++){
                                orders.get(i).viewBill();
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Choice!!");
                    System.out.println("Try Again...");
                    System.out.println();
                    break;
            }
        }

        }
    public static int getUserChoice() {
        Scanner input=new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine();
                return choice;
            } catch (Exception e) {
                System.out.println("WRONG INPUT ::: ENTER INTEGER ONLY  ");
                input.nextLine();
            }
        }
    }
}
