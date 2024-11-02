package Administration;
import java.util.Scanner;

public class ReceptionistHotel extends Employee{

    String department;
    String workStationLocation;
    String skills;
    

    Scanner input = new Scanner(System.in);

    public ReceptionistHotel(){
        super();
    };

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
    public void  displayInfo(){
        super.displayInfo();
        System.out.println("Department of that employee : " + department);
        System.out.println("Work Station of that employee : " + workStationLocation );
        System.out.println("Skills of that employee : " + skills );

    }
}