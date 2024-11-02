package HotelReceptionist;
import java.util.Scanner;

import Generic.Individual;

public class PersonWhoBook extends Individual{
    public int rNumber;



    public PersonWhoBook(int num){
        loadIndividual(num);
    }



    public void loadIndividual(int rNumber){
        
        Scanner input = new Scanner(System.in);

        //take inputs to load the object for new customer..
        System.out.print("Enter the name of the customer : ");
        setName(input.nextLine());
        System.out.print("Enter the CNIC of that customer : ");
        setCnic(input.nextLine());//for controlling input stream
        System.out.print("Enter the phone number of that customer : ");
        setPhoneNumber(input.nextLine());
        System.out.print("Enter the gmail of that customer : ");
        setGmail(input.nextLine());
        System.out.print("Enter the Dob of that customer : ");
        setDob(input.nextLine());

        this.rNumber = rNumber;  

    }

    public void displayData(){
        System.out.println("*******************************************************************************");
        System.out.println();
        System.out.println("Name : " + getName());
        System.out.println("CNIC : " + getCnic());
        System.out.println("Phone Number : " + getPhoneNumber());
        System.out.println("Gmail : " + getGmail());
        System.out.println("Date of Birth : " + getDob());
        System.out.println();
        System.out.println("*******************************************************************************");
        System.out.println();

    }



}






















































