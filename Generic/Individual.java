package Generic;


public class Individual{
        public String name;
        private String cnic;
        private String gmail;
        private String phoneNumber;
        private String dob;
        
        Authorization aut = new Authorization();
    
        // constructors..
        public Individual(){
        }
    
        public Individual(String name , String cnic , String phoneNumber , String gmail , String dob){
            setInfo(name , cnic , phoneNumber , gmail , dob);
            
        }
    
        public void setAuthorization(String userName , String passWord){
            aut.setAuthorization( userName , passWord);
        }
    
        public void setName(String name){
            this.name = name;
        } 
    
        public void setCnic(String cnic){
            this.cnic = cnic;
        }
    
        public void setGmail(String gmail){
            this.gmail = gmail;
        }
    
        public void setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
        }
    
        public void setDob(String dob){
            this.dob = dob;
        }
    
        public void setInfo(String name , String cnic , String phoneNumber , String gmail , String dob){
            setName(name);
            setCnic(cnic);
            setPhoneNumber(phoneNumber);
            setGmail(gmail);
            setDob(dob);
        }
    
    
        public String getName(){
            return name;
        }
    
        public String getCnic (){
            return cnic;
        }
    
        public String getGmail(){
            return gmail;
        }
    
        public String getPhoneNumber(){
            return phoneNumber;
        }
    
        public String getDob(){
            return dob;
        }
    
    }

