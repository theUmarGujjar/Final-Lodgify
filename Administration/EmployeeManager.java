package Administration;

import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeManager {

    Scanner input = new Scanner(System.in);


    // Static arraylists of different type 
    static ArrayList<ReceptionistHotel> hotelReceptionistList=new ArrayList<ReceptionistHotel>(10);
    static ArrayList<ReceptionistResturant> resturantReceptionistList=new ArrayList<ReceptionistResturant>(10);
    static  ArrayList<DriverM> driverList=new ArrayList<DriverM>(10);
    static ArrayList<SweeperM> sweeperList=new ArrayList<SweeperM>(10);


    // Objects of different datatype..
    Employee hotelReceptionist = new ReceptionistHotel();
    Employee driver = new DriverM();
    Employee sweeper = new SweeperM();
    Employee resturnatReceptionist = new ReceptionistResturant();


    public  void selectEmployee(String purpose){


        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Please select which type of Employee : ");
            String empType = input.nextLine();
            empType = empType.toLowerCase();
    
            if(empType.equals("driver") ){
                selectPurpose(purpose , driver);
                break;
            }
            else if(empType.equals("sweeper")){
                selectPurpose(purpose , sweeper);

                break;
            }
            else if(empType.equals("resturant receptionist") || empType.equals("resturantreceptionist")){
                selectPurpose(purpose , resturnatReceptionist);


                break;
            }
            else if(empType.equals("hotel receptionist")|| empType.equals("hotelreceptionist")){
                selectPurpose(purpose , hotelReceptionist);

                break;
            }
            else{
                System.out.println("Wrong input ...");
                System.out.println("Enter right input ...");
                System.out.println("1. driver");
                System.out.println("2. sweeper");
                System.out.println("3. resturant receptionist");
                System.out.println("4. hotel receptionist");
            }
    
        }
    }

    public void selectPurpose(String purpose , Employee emp){
        if(purpose.equals("add")){
            addEmp(emp);
        }
        else if(purpose.equals("remove")){
            removeAndUpdateEmp(emp , purpose);
        }
        else if(purpose.equals("update")){
            removeAndUpdateEmp(emp, purpose);
        }
    }



    // POLYMORPHISIM ..
    public  void addEmp(Employee emp){

        //check that emp refernce is instance of which class..

        if(emp instanceof DriverM){
            driver.loadEmp();// add for testing
            driverList.add(((DriverM)emp));

        }
        else if( emp instanceof SweeperM){
            sweeper.loadEmp();// add for testing
            sweeperList.add(((SweeperM)emp));
        }

        else if( emp instanceof ReceptionistHotel ){
            hotelReceptionist.loadEmp();// for testing
            hotelReceptionistList.add(((ReceptionistHotel)emp));
        }

        else if( emp instanceof ReceptionistResturant){
            resturnatReceptionist.loadEmp();// for testing
            resturantReceptionistList.add(((ReceptionistResturant)emp));
        }
    }

    
    public void removeAndUpdateEmp(Employee emp , String purpose){
        String cnic;
        System.out.println("Enter the CNIC of the employee : ");
        cnic = input.nextLine();

         // testing phase..
        if(emp instanceof DriverM){
            if(purpose.equals("remove")){
                delete(driverList,cnic);
            }
            else if(purpose.equals("update")){
                updateEmployee(driverList,cnic);     
            }
        }


        else if( emp instanceof SweeperM){
            if(purpose.equals("remove")){
                delete(sweeperList,cnic);
            }
            else if(purpose.equals("update")){
                updateEmployee(sweeperList,cnic);     
            }
        }


        else if( emp instanceof ReceptionistHotel ){
            if(purpose.equals("remove")){
                delete(hotelReceptionistList,cnic);
            }
            else if(purpose.equals("update")){
                updateEmployee(hotelReceptionistList,cnic);     
            }        }


        else if( emp instanceof ReceptionistResturant){
            if(purpose.equals("remove")){
                delete(resturantReceptionistList,cnic);
            }
            else if(purpose.equals("update")){
                updateEmployee(resturantReceptionistList,cnic);     
            }      
        }
    }
    public void updateEmp(Employee emp){

        System.out.println("......You can reset the gmail , phonenumber and salary after giving the cnic ......");
        System.out.println("Enter new details");

        System.out.println();
        System.out.println();

        System.out.println("Enter new gmail");
        String gmail=input.nextLine();
        emp.setGmail(gmail);

        System.out.println("Enter new salary");
       int salary=input.nextInt();
       emp.setSalary(salary);
       input.nextLine();

        System.out.println("enter new phone number");
        String phoneNumber=input.nextLine();
        emp.setPhoneNumber(phoneNumber);
        
    }


    public <T extends Employee>void updateEmployee(ArrayList<T> emp ,String cnic){
        Boolean found = false;

        for(int i = 0 ; i< emp.size() ; i++){
            if(cnic.equals(emp.get(i).getCnic())){
                updateEmp(emp.get(i));
                found = true;
                System.out.println("cnic matched...");// testing..

            }
        }
        if(!found){
            System.out.println("No employee in database with that  cnic ");
        }
    }
    


public <T extends Employee>void delete(ArrayList<T> emp ,String cnic){
    Boolean found = false;




    for(int i = 0 ; i< emp.size() ; i++){


        if(cnic.equals(emp.get(i).getCnic())){
            emp.remove(i);
            found = true;
            System.out.println("employee with this cnic is removed");
        }
    }
    if(!found){
        System.out.println("No employee in database with that  cnic ");
    }
}


public <T extends Employee>void setinfo(ArrayList<T> emp ,String cnic,String gmail,int salary,String phoneNumber){
    Boolean found = false;
    for(int i = 0 ; i< emp.size() ; i++){
        if(cnic.equals(emp.get(i).getCnic())){
           
            emp.get(i).setGmail(gmail);
            emp.get(i).setSalary(salary);
            emp.get(i).setPhoneNumber(phoneNumber);
           
           
           
            found = true;
        }
    }
    if(!found){
        System.out.println("No employee in database with that  cnic ");
    }
}



    public void displayEmployee() {

        if (hotelReceptionistList.isEmpty()) {
            System.out.println("No data available for hotel receptionists.");
        } else {
            System.out.println("Displaying hotel receptionists");
            for (ReceptionistHotel receptionist : hotelReceptionistList) {
                receptionist.displayInfo();

            }
        }

        if (resturantReceptionistList.isEmpty()) {



            System.out.println("No data available for restaurant receptionists.");
        } else {
            System.out.println("Displaying restaurant receptionists");
            for (ReceptionistResturant restaurant : resturantReceptionistList) {
                restaurant.displayInfo();
            }
        }

        if (driverList.isEmpty()) {
            System.out.println("No data available for driver receptionists.");
        } else {
            System.out.println("Displaying driver receptionists");
            for (DriverM driver : driverList) {
                driver.displayInfo();
            }
        }

        if (sweeperList.isEmpty()) {
            System.out.println("No data available for sweeper receptionists.");
        } else {
            System.out.println("Displaying sweeper receptionists");
            for (SweeperM sweeper : sweeperList) {
                sweeper.displayInfo();
            }
        }
    }

}