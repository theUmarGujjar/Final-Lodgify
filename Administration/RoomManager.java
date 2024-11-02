package Administration;

import java.util.ArrayList;

public class RoomManager {
    public static ArrayList<Room> roomlist=new ArrayList<Room>(10);
    void addRoom(Room r){

    roomlist.add(r);
    System.out.println("room added");
    
}



//removing room by matching number
void removeRoom(int rNumber){
    boolean found=false;
      for(int i=0;i<roomlist.size();i++){
        if(rNumber==roomlist.get(i).getrNumber()){
            roomlist.remove(i);
            found=true;
            System.out.println("room with room no " + rNumber + "is removed");
        }
        if(!found){
            System.out.println("There is no room with this room number");
        }
      }
           
        }
        
      


    

//updaing rooms after matching room no
void updateRooms(int rNumber,int price,String rType,int rBeds){
   for(Room r:roomlist){
    if(r.getrNumber()==rNumber){
      r.setrPrice(price);
      r.setrType(rType);
      r.setrBeds(rBeds);
     System.out.println("Room updated");
     return;
    }
   }System.out.println("There is no room with this number");
}
void displayRooms(){
    if(roomlist.isEmpty()){
        System.out.println("there is no room in the list");
    }else{
        for(Room r:roomlist){
            r.show(); //displayinfo
        }
    }
}

}


