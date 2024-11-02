package RestaurantManagement;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private static int id;
    private final int orderID = ++id;
    private boolean ordered;
    private ArrayList<OrderItem> myorder;

     Scanner input=new Scanner(System.in);


//    constructor
    Order(){
        this(new ArrayList<>(), false);
    }

    Order(ArrayList<OrderItem> myorder,boolean ordered) {
        setMyorder(myorder);
        setOrdered(ordered);
    }

//    getter and setters
    public int getid(){
        return id;
    }
    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public ArrayList<OrderItem> getMyorder() {
        return myorder;
    }

    public void setMyorder(ArrayList<OrderItem> myorder) {
        this.myorder = myorder;
    }

    public void print() {
        System.out.println("Order ID: " + orderID);
    }

    public void manageOrders(Menu menu) {
        int choice;
        while (true) {
            menu.displayMenu();
            System.out.println("Your order ID: " + orderID);
            System.out.println("##################################### Order Portal #####################################");
            System.out.println("Enter 0 to Exit (current Order will be lost)");
            System.out.println("Enter 1 to add item");
            System.out.println("Enter 2 to update item");
            System.out.println("Enter 3 to delete item");
            System.out.println("Enter 4 to view order");
            System.out.println("Enter 5 to view current bill");
            System.out.println("Enter 6 to place order (it cannot be changed)");
            System.out.println("########################################################################################");
            choice =  Restaurant.getUserChoice();
            ItemStatus itemStatus=ItemStatus.chooseStatus(choice);


            switch (itemStatus) {
                case EXIT:
                    --id;
                    System.out.println("Exiting the order management.");
                    System.out.println("Your current order is lost");
                    return;
                case ADD:
                    System.out.println("--------------------------Add new menu item--------------------------");
                    addItem(menu);
                    break;
                case UPDATE:
                    System.out.println("--------------------------update order item---------------------------");
                    updateItem(menu);
                    break;
                case REMOVE:
                    System.out.println("--------------------------Delete order item---------------------------");
                    deleteItem();
                    break;
                case VIEW:
                    System.out.println("------------------------display ordered items-------------------------");
                    display();
                    break;
                case VIEWBILL:
                    System.out.println("------------------------view bill-------------------------");
                    viewBill();
                    break;
                case PLACEORDER:
                    System.out.println("-----------------------------Place order--------------------------------");
                    placeOrder(menu);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addItem(Menu menu) {
        int itemIndex;
        OrderItem orderItem;
        String name;
        String size;
        int quantity;
        double price;

        System.out.println("Enter the item name");
        name = input.nextLine().trim().toLowerCase();
        itemIndex = findItemIndexByName(name,menu.getMenuItems());

        if (itemIndex == -1) {
            System.out.println("Invalid item name. Please try again.");
            return;
        }
        else{
            ArrayList<SizePriceQuantity> menuItemDetail=menu.getMenuItems().get(itemIndex).getSizePriceQuantities();
            int sizeIndex=-1;

            while(true){
                System.out.println("Enter the size of item");
                size=input.nextLine().trim().toLowerCase();
                for(int i=0;i<menuItemDetail.size();i++){
                    if(size.equalsIgnoreCase(menuItemDetail.get(i).getSize())){
                        sizeIndex=i;
                        break;
                    }
                }
                if(sizeIndex==-1){
                    System.out.println("Invalid size. Please try again.");
                }
                else{
                    System.out.println("Your entered size is selected");
                    break;
                }

            }
            for(int i=0;i<myorder.size();i++){
                if(myorder.get(i).getItemName().equalsIgnoreCase(name)){
                    if(myorder.get(i).getSize().equalsIgnoreCase(size)){
                        System.out.println("Item with similar name and size also exist in the order");
                        System.out.println("please update that item rahter than making new item");
                        return;
                    }
                }
            }

            int totalQuantity=menuItemDetail.get(sizeIndex).getQuantity();
            while (true){
                System.out.println("Enter quantity of "+name+" "+"with size "+ size);
                System.out.println("Total Quantity availabe are: "+ totalQuantity);
                quantity= Restaurant.getUserChoice();
                if(quantity<0 || quantity>totalQuantity){
                    System.out.println("Invalid quantity. Please try again.");
                }
                else {
                    System.out.println("Your Enter Quantity is Added Your order");
                    break;
                }
            }
            price=menuItemDetail.get(sizeIndex).getPrice()*quantity;
            orderItem=new OrderItem(name,size,quantity,price);
            myorder.add(orderItem);
            System.out.println("((((((((((((((Result: ))))))))))))))");
            System.out.println("Your item is add in order successfully")  ;
        }

    }
    public void updateItem(Menu menu) {
        OrderItem orderItem;
        String name;
        String size;
        int quantity;
        double price;
        int orderindex;
        int menuindex;

        System.out.println("Enter the item name");
        name = input.nextLine().trim().toLowerCase();
        menuindex = findItemIndexByName(name,menu.getMenuItems());
        orderindex=findItemIndexFromOrder(name,myorder);

        if (orderindex == -1) {
            System.out.println("Invalid item name. Please try again.");
            return;
        }
        else{
            ArrayList<SizePriceQuantity> menuItemDetail=menu.getMenuItems().get(menuindex).getSizePriceQuantities();
            int sizeIndex=-1;
            while(true){
                System.out.println("Enter the size of item");
                size=input.nextLine();
                for(int i=0;i<menuItemDetail.size();i++){
                    if(size.equalsIgnoreCase(menuItemDetail.get(i).getSize())){
                        sizeIndex=i;
                        break;
                    }
                }
                if(sizeIndex==-1){
                    System.out.println("Invalid size. Please try again.");
                }
                else{
                    System.out.println("Your entered size is selected");
                    break;
                }

            }

            int totalQuantity=menuItemDetail.get(sizeIndex).getQuantity();

            while (true){
                System.out.println("Enter quantity of "+ name+" "+"with size "+ size);
                System.out.println("Total Quantity availabe are: "+ totalQuantity);
                quantity= Restaurant.getUserChoice();
                if(quantity<0 || quantity>totalQuantity){
                    System.out.println("Invalid quantity. Please try again.");
                }
                else {
                    System.out.println("Your Enter Quantity is Added Your order");
                    break;
                }
            }

            price=menuItemDetail.get(sizeIndex).getPrice()*quantity;
            orderItem=new OrderItem(name,size,quantity,price);
            myorder.set(orderindex,orderItem);
            System.out.println("((((((((((((((Result: ))))))))))))))");
            System.out.println("Your item is updated in order successfully")  ;
        }



    }

    public void deleteItem(){
        int choice;
        String itemName;

        while (true){
            System.out.println("Enter 0 to exit");
            System.out.println("Enter 1 to delete item");
            System.out.println("Enter 2 to delete all");
            choice =  Restaurant.getUserChoice();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println("Enter the item name");
                    itemName = input.nextLine().trim().toLowerCase();
                    int index=findItemIndexFromOrder(itemName,myorder);
                    if(index==-1){
                        System.out.println("((((((((((((((Result: ))))))))))))))");
                        System.out.println("Your searched item not found");
                    }
                    else{
                        System.out.println("((((((((((((((Result: ))))))))))))))");
                        System.out.println("Item removed successfully");
                        myorder.remove(index);
                    }
                   return;

                case 2:
                    System.out.println("((((((((((((((Result: ))))))))))))))");
                    System.out.println("all the Item have been deleted successfully");
                    myorder.clear();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    public void display(){
       if(myorder.size()==0){
           System.out.println("There is no item available in the order");
       }
       else{
           int num=0;
           System.out.println("Order ID: " + orderID);
           for(OrderItem orderItem:myorder){
               System.out.println(++num+". "+orderItem.getItemName()+"     ====>     Size: "+orderItem.getSize()+"     Quantity: "+orderItem.getQuantity());
           }
       }
    }

    public void viewBill(){
        double total=0;
        for(OrderItem orderItem:myorder){
            total+=orderItem.getPrice();
        }
        if(myorder.size()==0){
            System.out.println("There is no item available in the order");
        }
        else{
            int num=0;
            System.out.println("Order ID: " + orderID);
            for(OrderItem orderItem:myorder){
                System.out.println(++num+". "+orderItem.getItemName()+"     ====>     Size: "+orderItem.getSize()+"     Quantity: "+orderItem.getQuantity()+"     Price: "+orderItem.getPrice());
            }
        }

        System.out.println("                                              -------------------------------");
        System.out.println("                                               Total: "+total );
    }

    public void placeOrder(Menu menu){
        viewBill();
        System.out.println("your order have been done successfully");
        updateMenu(menu);
        setOrdered(true);


    }

    public void updateMenu(Menu menu){
        int buyQuantity;
        int menuQuantity;

        if(!isOrdered()){
            for(int i=0;i< myorder.size();i++){
                for(int j=0;j<menu.getMenuItems().size();j++){
                    if(myorder.get(i).getItemName().equals(menu.getMenuItems().get(j).getName())){
                       for(int k=0;k<menu.getMenuItems().get(j).getSizePriceQuantities().size();k++){
                            if(menu.getMenuItems().get(j).getSizePriceQuantities().get(k).getSize().equalsIgnoreCase(myorder.get(i).getSize())){
                                menuQuantity=menu.getMenuItems().get(j).getSizePriceQuantities().get(k).getQuantity();
                                buyQuantity=myorder.get(i).getQuantity();
                                menu.getMenuItems().get(j).getSizePriceQuantities().get(k).setQuantity(menuQuantity-buyQuantity);
                            }

                       }
                    }
                }
            }
        }
        else{
            System.out.println("Order is already placed");
        }




    }

    private int findItemIndexByName(String name,ArrayList<FoodItem> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int findItemIndexFromOrder(String name,ArrayList<OrderItem> orderItems) {
        for (int i = 0; i < myorder.size(); i++) {
            if (myorder.get(i).getItemName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }



}
