package Generic;

public class Authorization{
    private String userName;
    private String passWord;

    public  void setAuthorization(String userName , String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }
    
    

    public Authorization() {
    }



    public Authorization(String userName , String passWord){
        setAuthorization(userName,passWord);
    }

    //check authorization..
    public Boolean checkAuthorization(String userName , String passWord ){
        if(userName.equals(this.userName)){
            if(passWord.equals(this.passWord)){
                System.out.println("Authorized Successfully...");
                return true;
            }
            else {
                System.out.println("Wrong Password..");
                return false;
            }
        }
        else{
            System.out.println("Wrong credentials..");
            return false;
        }
    }

    public void displayPassword(){
        // We have to use username and password or any other method here to stop illegal access.
        System.out.println("UserName is : " + userName);
        System.out.println("passWord is : " + passWord);
    }
}