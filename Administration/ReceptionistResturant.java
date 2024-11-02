package Administration;

public class ReceptionistResturant extends Employee{

String department;
String workStationLocation;
String skills;



    @Override
    public void loadEmp(){

        super.loadEmp();

        System.out.println("Enter the department of that employee : ");
        department = input.nextLine();
        System.out.println("Enter the work station where that employe work : ");
        workStationLocation = input.nextLine();
        System.out.println("Enter the skill of that employee : ");
        skills = input.nextLine();
        


    }
    
}
