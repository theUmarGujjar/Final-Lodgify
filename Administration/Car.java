package Administration;
public class Car {
    private int id;
    private String model;
    private String L_plateno;
    private String availability;

   //constructor to setinfo
    public Car(int id,String model,String L_plateno){
    setCar( id, model, L_plateno);
  
}
    public Car(){
        
    }
    //setters
     void setId(int id) {
        this.id=id;
        
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

 
     void setModel(String model) {
        this.model = model;
    }
   
     void setL_plateno(String l_plateno) {
        this.L_plateno = l_plateno;
    }
//setter to set info
void setCar(int id,String model,String L_plateno) {
    this.id = id;
    this.model = model;
    this.L_plateno = L_plateno;


}

    //getters
    public int getId() {
        return id;
        
    }

    public String getAvailability() {
            return availability;
    }
   
    public String getModel() {
        return model;
    }

    public String getL_plateno() {
        return L_plateno;
    }

    public void displayinfo(){
    System.out.println("Car id is : " + id);
    System.out.println("Car lisence plate no is : " + L_plateno);
    System.out.println("Car model is : " + model);
        System.out.println("Car availability is : " + availability);
    }


   

}
