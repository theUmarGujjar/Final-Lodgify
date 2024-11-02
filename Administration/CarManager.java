package Administration;
import java.util.ArrayList;

public class CarManager {
    public static ArrayList<Car> carlist=new ArrayList<Car>(10);
    void addCar(Car car){

        carlist.add(car);
        System.out.println("car added");
        
    }
    //removing car by matching id
    void removeCar(int id){
    Boolean found = false;
    for(int i = 0 ; i< carlist.size() ; i++){
        if(id == carlist.get(i).getId()){
            carlist.remove(i);

            found = true;
            System.out.println("car with id : "+ id + "is removed");
        }
    }
    if(!found){
        System.out.println("No car  in database with that id ");
    }
}


    //updaing cars after matching id
    void updateCar(int id,String model,String L_plateno){
       for(Car car:carlist){
        if(car.getId()==id){
          car.setL_plateno(L_plateno);
          car.setModel(model);
         System.out.println("Car updated");
         return;
        }
       }System.out.println("There is no car with this id");
    }
    void displayCars(){
        if(carlist.isEmpty()){
            System.out.println("there is no car in the list");
        }else{
            for(Car car:carlist){
                car.displayinfo();
            }
        }
    }

    public static ArrayList<Car> getCarList(){
        return carlist;
    }

}
