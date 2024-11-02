package RestaurantManagement;
import java.util.Scanner;

class SizePriceQuantity {
    private String size;
    private double price;
    private int quantity;

    SizePriceQuantity() {
        this("none",0.0,0);
    }

    SizePriceQuantity(String size, double price, int quantity) {
        setSize(size);
        setPrice(price);
        setQuantity(quantity);
    }

//  copy constructor

    SizePriceQuantity(SizePriceQuantity s){
        this(s.getSize(),s.getPrice(),s.getQuantity());
    }


//   getters and setter

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        size = size.trim().toLowerCase();
        if (size.equals("xl") || size.equals("l") || size.equals("n") || size.equals("s") || size.equals("xs") || size.equals("none")) {
            this.size = size;

        } else {
            throw new IllegalArgumentException("Size must be xl, l, n, s, es, or none");

        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price<0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        else{
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity<0){
            throw new IllegalArgumentException("quantity cannot be negative");
        }
        else{
            this.quantity = quantity;
        }

    }



    //    function that set everything manually
    public void setEveryThingManually(){
        Scanner input=new Scanner(System.in);

//      Taking input of size
        System.out.println("You have to set all the values manually");
        while(true){
            try{
                System.out.println("Enter the size [xl,l,n,s,es] ");
                setSize(input.nextLine());
                break;
            }
            catch(Exception e){
                if(e.getMessage()!=null){
                    System.out.println(e.getMessage());
                }
                System.out.println("please try again");

            }

        }

//       taking input of price

        while(true){
            try{
                System.out.println("Enter the price");
                setPrice(input.nextDouble());
                break;
            }
            catch(Exception e){
                if(e.getMessage()!=null){
                    System.out.println(e.getMessage());
                }
                else{
                    System.out.println("datatype error");
                }
                System.out.println("Please try again");
            }
            finally {
                input.nextLine();

            }
        }

//       taking input of quantity

        while(true){
            try{
                System.out.println("Enter the quantity availabe");
                setQuantity(input.nextInt());
                break;
            }
            catch(Exception e){
                if(e.getMessage()!=null){
                    System.out.println(e.getMessage());
                }
                else{
                    System.out.println("datatype error");
                }
                System.out.println("Please try again");
            }
            finally {
                input.nextLine();

            }
        }
    }

    public void display(){
        System.out.println("Size: " + getSize());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity: " + getQuantity());
    }

    @Override
    public String toString() {
        return "\nAvailabe data [size='" + getSize() + "', price=" + getPrice() + ", quantity=" + getQuantity() + "]";
    }

}
